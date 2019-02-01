package service.impl;
import domain.entity.*;
import domain.exception.PayException;
import domain.exception.WalletException;
import domain.service.UsrWithDrawService;
import domain.tranlog.MoneyTransferScheduleContext;
import domain.type.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import service.manager.UsrWalletManager;
import service.manager.UsrWithDrawManager;
import java.util.*;

public class UsrWithDrawServiceImpl implements UsrWithDrawService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private TransactionTemplate transactionTemplate;
    private UsrWithDrawManager usrWithDrawManager;
	private UsrWalletManager usrWalletManager;

	/**这个方法用于，当客户端发起一笔提款时，生成提款记录、生成提款流水日志、用户钱包可用金额、冻结金额操作。
	 * 提款记录在后台是需要审核，当审核通过后，admin才向第三方发起提款
	 * 向第三方发起提款，是提款网关paygateway那边去发起,当第三方通知我们的时候，
	 * 再调用acceptThirdWithDrawInform（第三方提款通知）的方法，进行真正的提款操作
	 * 几个重要操作：
	 * 保存提款记录
	 * 保存提款日志
	 * 修改用户钱包
	 * @param usrWithDraw
	 * @param userOperParam
	 * @return
	 */
	public WithdrawResult saveWithDrawInfo(UsrWithDraw usrWithDraw, UsrOperationParam userOperParam) {
		WithdrawResult modelResult = new WithdrawResult();
		/*校验：
			用户名不能为空
			用户ID不能为空
			提款金额不能为空
			提款金额需大于0
			用户类型不能为空
			操作信息不能为空
			......
		 */
		//提款备注
		usrWithDraw.setWithdrawDesc(userOperParam.getOperIp());
		//组装用户绑卡信息
		//审核状态：状态初始化
		usrWithDraw.setAuditStatus(AuditStatus.AUDITINIT.getIndex());
		//获取用户信息
		//标记位实名判断
		//提款金额大于可用提款金额
		//判断用户是否有多条正在提款的记录
		//提款状态：初始化
		usrWithDraw.setWithdrawStatus(WithdrawStatus.WD_INIT.getIndex());
		//提款手续费

		MoneyTransferScheduleContext context = transactionTemplate.execute(new TransactionCallback<MoneyTransferScheduleContext>() {
			@Override
			public MoneyTransferScheduleContext doInTransaction(TransactionStatus transactionStatus) {
				//保存提款记录
				int succCount = usrWithDrawManager.saveWithDrawInfo(usrWithDraw);
				if(succCount <= 0){
					throw new PayException("申请提款异常");
				}
				//会员钱包交易VO UsrTransVo
				UsrTransVo usrTransVo = new UsrTransVo();
				usrTransVo.setTransOrderId(usrWithDraw.getId());
				usrTransVo.setTransType(TransType.FREEZE_TK.getIndex());
				usrTransVo.setUserId(usrWithDraw.getUserId());
				usrTransVo.setUserType(usrWithDraw.getUserType());
				usrTransVo.setAmount(usrWithDraw.getAmount());
				usrTransVo.setTransInfo("某某支付");
				userOperParam.setOpRemark("提款冻结");

				//可用钱包可用余额减少，冻结金额增加
				usrWalletManager.subtractAbleBalanceAndAddFreeze(usrTransVo, UsrWalletHandle.subtractPrizeFirst,
						userOperParam, UsrWalletExpandParam.getDefaultInstance());

				return null;
			}
		});
		return modelResult;
	}

	/**第三方提款通知VO
	 * 第三方提款的情况，调用这个方法，不管成功还是失败
	 * @param thirdWithDrawInformVo
	 * @return
	 */
	public ModelResult<Boolean> acceptThirdWithDrawInform(ThirdWithDrawInformVo thirdWithDrawInformVo) {

		ModelResult<Boolean> result= new ModelResult<Boolean>();
		//根据交易号查询提款记录
		List<UsrWithDraw> listUsr= usrWithDrawManager.queryUsrWithDrawByUniqueIdToOuter(thirdWithDrawInformVo.getUniqueIdToOuter());
		//如果数据库没有提款记录，则返回
		UsrWithDraw usrWithDraw = listUsr.get(0);
		MoneyTransferScheduleContext context = transactionTemplate.execute(new TransactionCallback<MoneyTransferScheduleContext>() {
			@Override
			public MoneyTransferScheduleContext doInTransaction(TransactionStatus transactionStatus) {
				//如果是提款成功
				if (thirdWithDrawInformVo.isSuccess(usrWithDraw.getPaymentWay())) {
					logger.info("第三方提款回调-交易号[{}],提款成功[{}]开始执行", thirdWithDrawInformVo.getUniqueIdToOuter(), thirdWithDrawInformVo.getResultPay());
					//修改 提款记录 的结果状态
					int count = usrWithDrawManager.updateWithdrawResultByIdAndAuditPass(
							WithdrawStatus.WD_SUCCESS.getIndex(), WithdrawStatus.PENDING_AUDIT.getIndex(),
							usrWithDraw.getWithdrawDesc(), usrWithDraw.getId(), thirdWithDrawInformVo.getBusinessTradeNo());
					//修改失败
					if (count <= 0) {
						logger.warn("提款成功updateWithdrawResultByIdAndAuditPass异常-交易号[{}]", thirdWithDrawInformVo.getUniqueIdToOuter());
						throw new PayException("修改提款状态异常");
					}
					//冻结转支付
					usrWithDrawManager.payForGetMoney(usrWithDraw);

				} else if (thirdWithDrawInformVo.isFail(usrWithDraw.getPaymentWay())) {
					//如果是提款失败
					//update 修改usrWithDraw 提款记录的状态等，参考提款成功

					//提款解冻，提款申请打回
					usrWithDrawManager.unfreezeForGetMoney(usrWithDraw);

				} else if (thirdWithDrawInformVo.isCancel(usrWithDraw.getPaymentWay())) {
					//提款取消
					//update 修改usrWithDraw 提款记录的状态等，参考提款成功

					//提款先成功之后又发现失败了,进行退款
					addMoneyReturnTicket(usrWithDraw);
				}

				return null;
			}
		});
		result.setModel(true);
		return result;
	}

	/**
	 * 提款先成功之后又发现失败了,进行退款
	 * @param usrWithDraw
	 * @throws WalletException
	 */
	private void addMoneyReturnTicket(UsrWithDraw usrWithDraw) throws WalletException{

		UsrTransVo usrTransVo = new UsrTransVo();
		usrTransVo.setTransOrderId(usrWithDraw.getId());
		usrTransVo.setTransType(TransType.PAY_BACK_GET_MONEY.getIndex());
		usrTransVo.setAmount(usrWithDraw.getAmount());
		usrTransVo.setUserId(usrWithDraw.getUserId());
		usrTransVo.setTransOrderNo(usrWithDraw.getUniqueIdToOuter() + "");
		usrTransVo.setUserType(usrWithDraw.getUserType());
		final UsrOperationParam userOperationParam = new UsrOperationParam(null, 0, null);
		userOperationParam.setOpRemark("银行退票");//提款先成功之后又发现失败了,进行退款

		usrWalletManager.addAbleBalance(usrTransVo, userOperationParam.getSellClient(), userOperationParam,
				UsrWalletExpandParam.getDefaultInstance());
	}
}

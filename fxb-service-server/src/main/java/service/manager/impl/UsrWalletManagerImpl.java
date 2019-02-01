package service.manager.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import domain.UsrWallet;
import domain.entity.*;
import domain.exception.WalletErrorTable;
import domain.exception.WalletException;
import domain.service.GenericDao;
import domain.tranlog.PayOrderContext;
import domain.type.TransType;
import domain.type.UserType;
import domain.type.WithdrawStatus;
import domain.util.DateTools;
import domain.util.MathUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import service.manager.MoneyTransferManager;
import service.manager.UsrWalletLogManager;
import service.manager.UsrWalletManager;
import service.manager.UsrWithDrawManager;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsrWalletManagerImpl implements UsrWalletManager {
	private TransactionTemplate transactionTemplate;
	private UsrWalletLogManager usrWalletLogManager;
	private GenericDao walletDao;
	private UsrWalletHandle usrWalletHandle;
	@Override
	public UsrWallet initUsrConsumerWallet(UsrConsumer usrConsumer) {
		return null;
	}

	@Override
	public UsrWallet queryUsrWalletByUserId(long userId, int userType) {
		return null;
	}

	@Override
	public UsrWallet queryUsrWalletByUserIdAndAccount(Map<String, Object> map) {
		return null;
	}

	@Override
	public List<UsrWallet> queryUsrWalletsByUserIdAndAccount(Map<String, Object> map) {
		return null;
	}

	@Override
	public int updateForAddAbleBalance(UsrWallet wallet) {
		return 0;
	}

	@Override
	public int saveWalletForIncome(UsrWallet wallet) {
		return 0;
	}

	@Override
	public int saveWalletForCharge(UsrWallet wallet) {
		return 0;
	}

	@Override
	public int saveWalletForDirectPay(UsrWallet wallet) {
		return 0;
	}

	@Override
	public int saveWalletForRefund(UsrWallet wallet) {
		return 0;
	}

	@Override
	public int saveWalletForPay(UsrWallet wallet) {
		return 0;
	}

	@Override
	public void updateForFreeze(UsrWallet wallet) {
//		update usr_wallet
//		set
//		able_gift_balance=#{ableGiftBalance},
//		able_cash_balance=#{ableCashBalance},
//		able_prize_balance=#{ablePrizeBalance},
//		able_income_balance=#{ableIncomeBalance},
//		freeze_gift_balance=#{freezeGiftBalance},
//		freeze_cash_balance=#{freezeCashBalance},
//		freeze_prize_balance=#{freezePrizeBalance},
//		freeze_income_balance=#{freezeIncomeBalance},
//		deposit=#{deposit},
//		freeze_deposit_balance=#{freezeDepositBalance},
//		verify_md5 =#{saveVerifyMd5ToDb},
//		update_time =now()
//		where id =#{id}
	}

	@Override
	public int saveAddGift(UsrWallet wallet, boolean needChangeDeposit) {
		return 0;
	}

	@Override
	public UsrWalletLog addAbleBalance(UsrTransVo usrTransVo, Integer sellClient, UsrOperationParam usrOperParam, UsrWalletExpandParam usrWalletExpandParam) {
		final Integer transType = usrTransVo.getTransType();
		final WalletLogActualVo actualVo = usrWalletHandle.buildLogActualVoForAddAbleBalance(usrTransVo);

		final UsrWallet wallet = this.queryUsrWalletByUserId(usrTransVo.getUserId(),usrTransVo.getUserType());
		UsrWalletLog walletlog = transactionTemplate.execute(new TransactionCallback<UsrWalletLog>() {
			@Override
			public UsrWalletLog doInTransaction(TransactionStatus status) {
				UsrWallet walletRealTime = walletDao.queryOneWithPessimisticLock("UsrWalletDao.selectPessimisticLock", wallet.getId());

				UsrWalletLog walletLog = usrWalletHandle.buildWalletLogForTransType( walletRealTime, actualVo, usrTransVo,null,
						sellClient, usrOperParam.getOpRemark());
				walletLog.setLogTime(usrWalletExpandParam.getLogTime());
				//设置流水充值类型
				JSONObject json = new JSONObject();
				json.put("transInfo", usrTransVo.getTransInfo());
				walletLog.setFeatures(json.toString());
				updateForAddAbleBalance(walletLog.getAfterUsrWallet());
				usrWalletLogManager.insertWalletLog(walletLog);
				return walletLog;
			}
		});
		return walletlog;
	}

	@Override
	public UsrWalletLog addAbleBalanceByProvider(UsrTransVo memberTransVo, Integer sellClient, UsrOperationParam userOperParam, UsrWalletExpandParam usrWalletExpandParam) {
		return null;
	}

	@Override
	public UsrWalletLog subtractFreeze(WalletLogActualVo walletLogActualVo, UsrTransVo usrTransVo, UsrOperationParam usrOperParam, UsrWalletExpandParam usrWalletExpandParam) {
		final BigDecimal amount =  walletLogActualVo.getAmount();
		//查询先前的walletLog 的
		final UsrWalletLog prevLog = new UsrWalletLog();
		// 检查需支付的金额是不是大于先前被冻结的金额
		UsrWallet wallet = this.queryUsrWalletByUserId(usrTransVo.getUserId(),usrTransVo.getUserType());
		final long walletId = wallet.getId();

		UsrWalletLog walletLog = transactionTemplate.execute(new TransactionCallback<UsrWalletLog>() {

			@Override
			public UsrWalletLog doInTransaction(TransactionStatus status) {

				UsrWallet walletRealTime = walletDao.queryOneWithPessimisticLock("UsrWalletDao.selectPessimisticLock", walletId);
				List<UsrWalletLog> walletLogList = usrWalletLogManager.queryWalletLogListByTransTypeAndOrderId(usrTransVo.getTransType(),
						usrTransVo.getTransOrderId(),usrTransVo.getUserType());

				UsrWalletLog walletLog = usrWalletHandle.buildWalletLogForTransType( walletRealTime, walletLogActualVo,usrTransVo,
						prevLog.getId(),prevLog.getSellClient(),usrOperParam.getOpRemark());

				//保存转支付
				saveWalletForPay(walletLog.getAfterUsrWallet());
				walletLog.setWalletOrderId(usrTransVo.getPayOrderId());
				walletLog.setFeatures(usrTransVo.getTransInfo());
				usrWalletLogManager.insertWalletLog(walletLog);
				return walletLog;
			}
		});
		return walletLog;
	}

	@Override
	public UsrWalletLog addAbleBalanceForIncome(WalletLogActualVo actualVo, Long walletId, UsrTransVo memberTransVo, UsrOperationParam userOperParam, UsrWalletExpandParam usrWalletExpandParam) {
		return null;
	}

	@Override
	public UsrWalletLog addAbleBalanceForCharge(WalletLogActualVo actualVo, Long walletId, UsrTransVo usrTransVo, Integer sellClient, UsrOperationParam usrOperParam, UsrWalletExpandParam usrWalletExpandParam) {
		return null;
	}

	@Override
	public UsrWalletLog refund(UsrTransVo usrTransVo, UsrOperationParam usrOperParam, UsrWalletExpandParam usrWalletExpandParam) {
		return null;
	}

	@Override
	public UsrWalletLog subtractAbleBalanceAndAddFreeze(UsrTransVo usrTransVo, int firstOption, UsrOperationParam usrOperParam, UsrWalletExpandParam usrWalletExpandParam) {
		final BigDecimal amount = usrTransVo.getAmount();
		final Long memberId = usrTransVo.getUserId();
		UsrWallet wallet = this.queryUsrWalletByUserId(usrTransVo.getUserId(),usrTransVo.getUserType());
		//简单判断提款金额是否超过可用金额
		if (wallet.getAbleBalance().compareTo(amount) < 0) {
			String errorMsg = String.format("会员[%s]会员类型[%s]执行交易[%s]时钱包可用余额不足,需冻结[%s]元,钱包[%s],业务id:%s", new Object[] { memberId,usrTransVo.getUserType(),
					usrTransVo.getTransType(), amount.toPlainString(), wallet.getAbleBalance().toPlainString(), usrTransVo.getTransOrderId() });
			throw new  WalletException(WalletErrorTable.NOT_SUFFICIENT_FUNDS);
		}
		final long walletId = wallet.getId();
		UsrWalletLog walletlog=null;

		walletlog=transactionTemplate.execute(new TransactionCallback<UsrWalletLog>() {
			@Override
			public UsrWalletLog doInTransaction(TransactionStatus status) {
				return subtractAbleBalanceAndAddFreezeNeedTransactionOutside(memberId, walletId,
						usrTransVo,firstOption, usrOperParam);
			}

		});

		return walletlog;
	}

	private UsrWalletLog subtractAbleBalanceAndAddFreezeNeedTransactionOutside(Long memberId, Long walletId,
																			   final UsrTransVo memberTransVo,
																			   int firstOption,final UsrOperationParam userOperParam){

		BigDecimal amount = memberTransVo.getAmount();
		//是否有相同的钱包流水
		List<UsrWalletLog> checkLogList = usrWalletLogManager.queryWalletLogListByTransTypeAndOrderId(memberTransVo.getTransType(),
				memberTransVo.getTransOrderId(),memberTransVo.getUserType());
		if(!checkLogList.isEmpty()){
			String warnMsg=String.format("会员ID[%s]在冻结交易(%s)有重复的钱包流水,本次不做处理.", memberId, memberTransVo.getTransOrderId());
			return checkLogList.get(0);
		}

		/*  锁表:for update 数据库中用户钱包这条记录便只可读，不能改
			select
			....
			from usr_wallet
			where id = #{id} for update
		 */
		UsrWallet walletRealTime = walletDao.queryOneWithPessimisticLock("UsrWalletDao.selectPessimisticLock", walletId);
		if (walletRealTime.getAbleBalance().compareTo(amount) < 0) {
			//执行交易,时钱包可用余额不足
			throw new WalletException(WalletErrorTable.NOT_SUFFICIENT_FUNDS);
		}
		//算出这次扣款 需要用到 彩金多少、现金多少、收益奖金多少
		WalletLogActualVo walletLogActualVo = usrWalletHandle.buildLogActualVoForSubtractAbleBalance(firstOption, memberTransVo, walletRealTime);

		//根据walletLogActualVo 生成walletLog 提款日志
		//TransType 不同生成的日志也不同
		UsrWalletLog walletLog=usrWalletHandle.buildWalletLogForTransType( walletRealTime,  walletLogActualVo, memberTransVo,null,
				userOperParam.getSellClient() ,userOperParam.getOpRemark());

		//保存修改 用户钱包 流水发生后的AfterUsrWallet
		this.updateForFreeze(walletLog.getAfterUsrWallet());

		walletLog.setWalletOrderId(memberTransVo.getPayOrderId());
		//保存 提款日志
		usrWalletLogManager.insertWalletLog(walletLog);
		return walletLog;
	}

	@Override
	public UsrWalletLog subtractAbleBalance(int firstOption, UsrTransVo usrTransVo, Integer sellClient, UsrOperationParam usrOperParam, UsrWalletExpandParam usrWalletExpandParam) {
		return null;
	}

	@Override
	public UsrWalletLog subtractFreezeAndAddAbleBalance(WalletLogActualVo walletLogActualVo, UsrTransVo usrTransVo, UsrOperationParam usrOperParam, UsrWalletExpandParam usrWalletExpandParam) {
		//查询关联的walletLog
		//usrWalletLogManager.queryWalletLogListByTransTypeAndOrderId
		final UsrWalletLog freezeLog = new UsrWalletLog();
		//检查以前的单据出现重复等

		UsrWallet wallet = this.queryUsrWalletByUserId(freezeLog.getUserId(),freezeLog.getUserType());
		final long walletId = wallet.getId();
		final Integer sellClient=freezeLog.getSellClient();
		UsrWalletLog walletLog=null;
		walletLog=transactionTemplate.execute(new TransactionCallback<UsrWalletLog>() {
			@Override
			public UsrWalletLog doInTransaction(TransactionStatus status) {
				return subtractFreezeAndAddAbleBalanceNeedTransactionOutside(walletId,walletLogActualVo, usrTransVo,
						sellClient,usrOperParam.getOpRemark() );
			}
		});
		return walletLog;
	}

	/**
	 */
	private UsrWalletLog subtractFreezeAndAddAbleBalanceNeedTransactionOutside(long walletId, final WalletLogActualVo walletLogActualVo,
																			   UsrTransVo usrTransVo,
																			   Integer sellClient,String remark){

		UsrWallet walletRealTime = walletDao.queryOneWithPessimisticLock("UsrWalletDao.selectPessimisticLock", walletId);
		Integer transType = usrTransVo.getTransType();
		BigDecimal amount = walletLogActualVo.getAmount();

		//查询关联usrWalletLog
		UsrWalletLog freezeLog = new UsrWalletLog();

		// 检查需解冻的金额是不是大于先前被冻结的金额
		//进行交易时,传入的解冻金额为零或大于冻结金额

		UsrWalletLog walletLog=usrWalletHandle.buildWalletLogForTransType( walletRealTime, walletLogActualVo,usrTransVo,
				freezeLog.getId(),sellClient, remark);

		this.saveUnfreeze(walletRealTime);

		walletLog.setWalletOrderId(usrTransVo.getPayOrderId());
		usrWalletLogManager.insertWalletLog(walletLog);
		return walletLog;
	}

	@Override
	public void saveUnfreeze(UsrWallet wallet) {

	}

	@Override
	public void asyncCheckSinaAndLocalWallet(long userId, UserType userType) {

	}

	@Override
	public UsrWalletLog getRelatedWalletLogThrowException(UsrTransVo usrTransVo) {
		return null;
	}

	@Override
	public UsrWalletLog addGiftAndAddDeposit(int UserType, long userId, int transType, BigDecimal giftAmount, BigDecimal addDeposit, long giftId, String giftName) {
		return null;
	}

	@Override
	public UsrWalletLog addGiftAndAddDeposit(int UserType, long userId, int transType, BigDecimal giftAmount, BigDecimal addDeposit, long giftId, String giftName, String planNo) {
		return null;
	}

	@Override
	public List<UsrWallet> queryWalletListByProviderIds(List<String> providerIds) {
		return null;
	}

	@Override
	public AbleGetMoneyVo queryAbleGetMoney(long userId) {
		return null;
	}

	@Override
	public AbleGetMoneyVo queryAbleGetMoneyByUsrType(long userId, Integer userType) {
		return null;
	}

	@Override
	public UsrWalletLog subtractAbleBalanceForProvider(int firstOption, UsrTransVo memberTransVo, Integer sellClient, UsrOperationParam userOperParam, UsrWalletExpandParam usrWalletExpandParam) {
		return null;
	}

	@Override
	public void addAbleBalanceForProviderDgOperWallet(Long walletId, UsrTransVo usrTransVo, UsrOperationParam userOperParam, UsrWalletLogQueryOption condition, int countId) {

	}

	@Override
	public void subtractAbleBalanceForProviderPrizeOperWallet(Long walletId, UsrTransVo usrTransVo, UsrOperationParam userOperParam, UsrWalletLogQueryOption condition, int countId) {

	}
}

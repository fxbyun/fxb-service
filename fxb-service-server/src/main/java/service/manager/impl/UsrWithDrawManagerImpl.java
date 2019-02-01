package service.manager.impl;

import domain.UsrWallet;
import domain.entity.*;
import domain.exception.PayException;
import domain.exception.WalletErrorTable;
import domain.exception.WalletException;
import domain.type.AuditStatus;
import domain.type.PaymentWay;
import domain.type.TransType;
import domain.type.UserType;
import domain.util.MathUtil;
import domain.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.manager.UsrWalletManager;
import service.manager.UsrWithDrawManager;

import java.math.BigDecimal;
import java.util.*;

public class UsrWithDrawManagerImpl implements UsrWithDrawManager {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private UsrWalletManager usrWalletManager;
	private UsrWalletHandle usrWalletHandle;
	@Override
	public int saveWithDrawInfo(UsrWithDraw usrWithDraw) {
		return 0;
	}

	@Override
	public Map<String, BigDecimal> queryWithDrawTotalAmount(Map<String, Object> param) {
		return null;
	}

	@Override
	public int updateUsrWithDrawById(Map<String, Object> param) {
		return 0;
	}

	@Override
	public UsrWithDraw queryUsrWithDrawById(long withDrawId) {
		return null;
	}

	@Override
	public UsrWithDraw queryUsrWithDrawAndCardInfoById(long withDrawId) {
		return null;
	}

	@Override
	public int queryUsrWithDrawByAccountCount(Map<String, Object> param) {
		return 0;
	}

	@Override
	public int queryUsrApplicationCount(Map<String, Object> param) {
		return 0;
	}

	@Override
	public List<UsrWithDraw> queryUsrWithDrawByUniqueNo(Map<String, Object> param) {
		return null;
	}

	@Override
	public List<UsrWithDraw> handleNoInputPWScheduler() {
		return null;
	}

	@Override
	public int updateFrozenMoneyFailAuditById(Map<String, Object> param) {
		return 0;
	}

	@Override
	public int updateAuditPassById(Map<String, Object> param) {
		return 0;
	}

	@Override
	public int updateAuditNoPassById(Map<String, Object> param) {
		return 0;
	}

	@Override
	public int updateAuditStutus(int withdrawStatus, String withdrawDesc, int auditStatus, int oldAuditStatus, String auditUser, String auditInfo, long withDrawId) {
		return 0;
	}

	@Override
	public int updateAuditStutusAndwithdrawStatus(int withdrawStatus, int oldWithdrawStatus, int auditStatus, int oldAuditStatus, String auditUser, String auditInfo, long withDrawId) {
		return 0;
	}

	@Override
	public int updateAuditAndWithdrawStatusById(int withdrawStatus, int auditStatus, String auditUser, long withDrawId) {
		return 0;
	}

	@Override
	public int updateWithDrawToPendingById(Map<String, Object> param) {
		return 0;
	}

	@Override
	public int updateCallbackToProcessedById(Map<String, Object> param) {
		return 0;
	}

	@Override
	public int updateCallbackWithDrawStatusById(Map<String, Object> param) {
		return 0;
	}

	@Override
	public int updateWithDrawToFailById(Map<String, Object> param) {
		return 0;
	}

	@Override
	public int updateAgainToUniqIdToOuterById(Map<String, Object> param) {
		return 0;
	}

	@Override
	public int updatePwdPaymentToWDStatusById(Map<String, Object> param) {
		return 0;
	}

	@Override
	public List<UsrWithDraw> queryUsrWithDrawExcel(Map<String, Object> param) {
		return null;
	}

	@Override
	public BigDecimal sumDrawAmountByStatus(long userId, int userType, List<Integer> withdrawStatus, Date beginDate, Date endDate) {
		return null;
	}

	@Override
	public boolean updateUnbindCardWithDrawNoFeeById(long withDrawId) {
		return false;
	}

	@Override
	public List<Long> queryUsrWithDrawIds(Map<String, Object> param) {
		return null;
	}

	@Override
	public UsrWalletLog payForGetMoney(UsrWithDraw usrWithDraw) throws WalletException {
		logger.info("用户[{}],开始把冻结资金转支付", new Object[]{ usrWithDraw.getAccount()});
		final UsrTransVo usrTransVo = new UsrTransVo();
		usrTransVo.setAmount(usrWithDraw.getAmount());
		usrTransVo.setUserId(usrWithDraw.getUserId());
		usrTransVo.setPayOrderId(null);
		usrTransVo.setReTransOrderId(usrWithDraw.getId());
		usrTransVo.setReTransType(TransType.FREEZE_TK.getIndex());
		usrTransVo.setTransOrderId(usrWithDraw.getId());
		usrTransVo.setTransType(TransType.PAY_TK.getIndex());
		usrTransVo.setUserType(usrWithDraw.getUserType());

		final UsrOperationParam userOperationParam = new UsrOperationParam(null, 0, null);
		userOperationParam.setOpRemark("提款处理");

		//查询关联的钱包流水  改成调用方法
		UsrWalletLog prevLog =  usrWalletManager.getRelatedWalletLogThrowException(usrTransVo);
		usrTransVo.setTransTime(usrWithDraw.getWithdrawTime());
		usrTransVo.setPayOrderId(prevLog.getId());
		usrTransVo.setTransInfo("某某支付");
		UsrWallet wallet = usrWalletManager.queryUsrWalletByUserId(prevLog.getUserId(), usrTransVo.getUserType());
		WalletLogActualVo walletLogActualVo = usrWalletHandle.buildLogActualVoForSubtractFreezeBalance(UsrWalletHandle.subtractPrizeFirst, usrTransVo, wallet, prevLog);
		UsrWalletLog resultLog =  usrWalletManager.subtractFreeze(walletLogActualVo, usrTransVo, userOperationParam, UsrWalletExpandParam.getDefaultInstance());
		return resultLog;
	}

	@Override
	public UsrWalletLog unfreezeForGetMoney(UsrWithDraw usrWithDraw) throws WalletException {
		final String orderNo = StringTools.buildYYMMDDNo("B", usrWithDraw.getId(), 9);//从coreservice复制过来
		final UsrTransVo unfreezeTransVo = new UsrTransVo();
		unfreezeTransVo.setAmount(usrWithDraw.getAmount());
		unfreezeTransVo.setUserId(usrWithDraw.getUserId());
		unfreezeTransVo.setPayOrderId(null);
		unfreezeTransVo.setReTransOrderId(usrWithDraw.getId());
		unfreezeTransVo.setReTransType(TransType.FREEZE_TK.getIndex());
		unfreezeTransVo.setTransOrderId(usrWithDraw.getId());
		unfreezeTransVo.setTransOrderNo(orderNo);
		unfreezeTransVo.setTransType(TransType.UNFREEZE_TK.getIndex());
		unfreezeTransVo.setUserType(usrWithDraw.getUserType());

		TransType nowTransType = TransType.findByIndex(unfreezeTransVo.getTransType());
		if (TransType.UNFREEZE_TK.getIndex() != nowTransType.getIndex()) {
			throw new WalletException(WalletErrorTable.ILLEGAL_RELATE_TRANS);
		}

		//查询关联的钱包流水  改成调用方法
		UsrWalletLog prevLog =  usrWalletManager.getRelatedWalletLogThrowException(unfreezeTransVo);
		UsrOperationParam userOperationParam = new UsrOperationParam("", 0, null);
		userOperationParam.setOpRemark("提款解冻");

		UsrWallet wallet = usrWalletManager.queryUsrWalletByUserId(prevLog.getUserId(), unfreezeTransVo.getUserType());
		WalletLogActualVo walletLogActualVo = usrWalletHandle.buildLogActualVoForSubtractFreezeBalance(UsrWalletHandle.subtractPrizeFirst, unfreezeTransVo, wallet, prevLog);
		UsrWalletLog resultLog = usrWalletManager.subtractFreezeAndAddAbleBalance(walletLogActualVo, unfreezeTransVo, userOperationParam, UsrWalletExpandParam.getDefaultInstance());

		return resultLog;
	}

	@Override
	public int updateAuditStatusById(int oldAuditStatus, int auditStatus, long id) {
		return 0;
	}

	@Override
	public int updateUserCancelWithdrawByIdAndAuditWait(int withdrawStatus, int oldWithdrawStatus, String withdrawDesc, long id) {
		return 0;
	}

	@Override
	public int updateWithdrawResultByIdAndAuditPass(int withdrawStatus, int oldWithdrawStatus, String withdrawDesc, long id) {
		return 0;
	}

	@Override
	public int updateWithdrawResultByIdAndAuditPass(int withdrawStatus, int oldWithdrawStatus, String withdrawDesc, long id, String businessTradeNo) {
		return 0;
	}

	@Override
	public int updateWithdrawStautsByIdAndAuditPass(int withdrawStatus, int oldWithdrawStatus, long id) {
		return 0;
	}

	@Override
	public int updateWithdrawStautsByIdAndAuditInit(int withdrawStatus, int oldWithdrawStatus, String withdrawDesc, long id) {
		return 0;
	}

	@Override
	public int cancelWithDraw(int withdrawStatus, int oldWithdrawStatus, String withdrawDesc, String auditInfo, long withDrawId) {
		return 0;
	}

	@Override
	public List<UsrWithDraw> queryApplyingGetMoneyByAuditPass() {
		return null;
	}

	@Override
	public List<UsrWithDraw> queryUsrWithDrawByUniqueIdToOuter(long uniqueIdToOuter) {
		return null;
	}

	@Override
	public List<Long> queryAutoWithDrawIds(String[] amountArr) {
		return null;
	}

	@Override
	public List<UsrWithDraw> handleInitScheduler() {
		return null;
	}

	@Override
	public BigDecimal getDrawAmountTodayByBankNo(UsrWithDrawVo usrWithDrawVo, String bankNo) {
		return null;
	}

	@Override
	public List<UsrWithDraw> queryUsrWithDrawForSinaTransfer(UsrWithDrawVo usrWithDrawVo, Integer limit) {
		return null;
	}

	@Override
	public int updateRequsetWeiBoWithdrawStautsByIdAndAuditPass(int withdrawStatus, int oldWithdrawStatus, long id) {
		return 0;
	}

	@Override
	public BigDecimal querySumUserDayTotalAmount(long userId, int userType, int paymentWay) {
		return null;
	}

	@Override
	public int updateTradeRelatedNoById(Long id, String tradeRelatedNo) {
		return 0;
	}

}

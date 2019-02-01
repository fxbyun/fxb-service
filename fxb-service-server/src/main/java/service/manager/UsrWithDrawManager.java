package service.manager;

import domain.entity.UsrWalletLog;
import domain.entity.UsrWithDraw;
import domain.entity.UsrWithDrawVo;
import domain.exception.WalletException;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UsrWithDrawManager {

	/**
	 * 保存用户提款信息
	 * @param usrWithDraw
	 * @return
	 */
	public int saveWithDrawInfo(UsrWithDraw usrWithDraw);
	
	/**
	 * 根据条件查询总提款金额,和手续费
	 * @param param
	 * @return
	 */
	public Map<String, BigDecimal> queryWithDrawTotalAmount(Map<String, Object> param);

	/**
	 * 修改提款信息
	 * @param param
	 * @return
	 */
	public int updateUsrWithDrawById(Map<String, Object> param);

	/**
	 * 根据ID查询信息
	 * @param withDrawId
	 * @return
	 */
	public UsrWithDraw queryUsrWithDrawById(long withDrawId);

	public UsrWithDraw queryUsrWithDrawAndCardInfoById(long withDrawId);

	/**
	 * 根据用户名查询用户正在提款的信息条数
	 * @param param
	 * @return
	 */
	public int queryUsrWithDrawByAccountCount(Map<String, Object> param);

	/**
	 * 根据条件查询用户提款条数
	 * @param param
	 * @return
	 */
	public int queryUsrApplicationCount(Map<String, Object> param);

	/**
	 * 根据交易号查询用户正在提款的信息
	 * @param param
	 * @return
	 */
	public List<UsrWithDraw> queryUsrWithDrawByUniqueNo(Map<String, Object> param);

	/**
	 * 查询已审核，状态为支付中，长期未处理的信息
	 * @return
	 */
	public List<UsrWithDraw> handleNoInputPWScheduler();

	/**
	 * 冻结失败后，修改提款状态和审核状态
	 * @param param
	 * @return
	 */
	public int updateFrozenMoneyFailAuditById(Map<String, Object> param);

	/**
	 * 审核成功，更新审核信息
	 * @param param
	 * @return
	 */
	public int updateAuditPassById(Map<String, Object> param);

	/**
	 * 审核失败，更新审核信息，和提款信息
	 * @param param
	 * @return
	 */
	public int updateAuditNoPassById(Map<String, Object> param);

    /**
     * 更新审核状态等信息
     * @param param
     * @return
     */
    public int updateAuditStutus(int withdrawStatus, String withdrawDesc, int auditStatus,
                                 int oldAuditStatus, String auditUser, String auditInfo, long withDrawId);

    /**
     * 更新审核状态,提款状态等信息
     * @param param
     * @return
     */
    public int updateAuditStutusAndwithdrawStatus(int withdrawStatus, int oldWithdrawStatus, int auditStatus,
                                                  int oldAuditStatus, String auditUser, String auditInfo, long withDrawId);

    /**
     * 根据提款id更改提款状态和审核状态
     * @param withdrawStatus
     * @param auditStatus
     * @param auditUser
     * @param withDrawId
     * @return
     */
    public int updateAuditAndWithdrawStatusById(int withdrawStatus, int auditStatus,
                                                String auditUser, long withDrawId);

	/**
	 * 用户点击提款，更新提款状态为受理中
	 * @param param
	 * @return
	 */
	public int updateWithDrawToPendingById(Map<String, Object> param);

	/**
	 * 回调处理已经处理过的信息，保存之前没有保存的信息
	 * @param param
	 * @return
	 */
	public int updateCallbackToProcessedById(Map<String, Object> param);

	/**
	 * 回执提款成功或失败后的状态
	 * @param param
	 * @return
	 */
	public int updateCallbackWithDrawStatusById(Map<String, Object> param);

	/**
	 * 手工解除冻结资金，更新状态
	 * @param param
	 * @return
	 */
	public int updateWithDrawToFailById(Map<String, Object> param);

	/**
	 * 更改交易号，可以让用户重新发起提款
	 * @param param
	 * @return
	 */
	public int updateAgainToUniqIdToOuterById(Map<String, Object> param);

	/**
	 * 用户输入提款密码后，更改提款状态为处理中（id = #{id} and withdraw_status = 1）
	 * @param param
	 * @return
	 */
	public int updatePwdPaymentToWDStatusById(Map<String, Object> param);

	/**
	 * 导出Excel提款数据
	 * @param param
	 * @return
	 */
	public List<UsrWithDraw> queryUsrWithDrawExcel(Map<String, Object> param);

	/**
	 * sum提款金额
	 * @param userId
	 * @param userType
	 * @param withdrawStatus
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @create_time 2015年11月19日 上午11:07:21
	 */
	public BigDecimal sumDrawAmountByStatus(long userId, int userType, List<Integer> withdrawStatus, Date beginDate, Date endDate);

	/**
	 * 如果用户在提出账户中所有金额时不大于1块钱，免除手续费
	 * @param withDrawId
	 * @return
	 */
	public boolean updateUnbindCardWithDrawNoFeeById(long withDrawId);

	/**
	 * 根据条件查询用户提款的所有ID
	 * @param param
	 * @return
	 */
	public List<Long> queryUsrWithDrawIds(Map<String, Object> param);

	/***
	 *  提款冻结转支付
	 * @param usrWithDraw
	 * @return
	 * @throws WalletException
	 */
	public UsrWalletLog payForGetMoney(UsrWithDraw usrWithDraw)  throws WalletException;
	/**
	 * 提款解冻，提款申请打回
	 * @param usrWithDraw
	 * @return
	 * @throws WalletException
	 */
	public UsrWalletLog unfreezeForGetMoney(UsrWithDraw usrWithDraw) throws WalletException;

	/***
	 * 修改审核状态
	 * @param oldAuditStatus
	 * @param auditStatus
	 * @param id
	 * @return
	 */
	public int updateAuditStatusById(int oldAuditStatus, int auditStatus, long id);

	/***
	 * 用户取消-申请中的提款
	 * @param withdrawStatus
	 * @param oldWithdrawStatus
	 * @param withdrawDesc
	 * @param id
	 * @return
	 */
	public int updateUserCancelWithdrawByIdAndAuditWait(int withdrawStatus, int oldWithdrawStatus, String withdrawDesc, long id);
	/**
	 * 修改审核通过的提款结果
	 * @param withdrawStatus
	 * @param oldWithdrawStatus
	 * @param withdrawDesc
	 * @param id
	 * @return
	 */
	public int updateWithdrawResultByIdAndAuditPass(int withdrawStatus, int oldWithdrawStatus, String withdrawDesc, long id);
	/***
	 * 修改审核通过的提款结果
	 * @param withdrawStatus
	 * @param oldWithdrawStatus
	 * @param withdrawDesc
	 * @param id
	 * @param businessTradeNo
	 * @return
	 */
	public int updateWithdrawResultByIdAndAuditPass(int withdrawStatus, int oldWithdrawStatus, String withdrawDesc, long id, String businessTradeNo);

	/***
	 * 修改已审核后的提款状态
	 * @param withdrawStatus
	 * @param oldWithdrawStatus
	 * @param id
	 * @return
	 */
	public int updateWithdrawStautsByIdAndAuditPass(int withdrawStatus, int oldWithdrawStatus, long id);
	/***
	 * 修改审核为初始化的 提款状态
	 * @param withdrawStatus
	 * @param oldWithdrawStatus
	 * @param withdrawDesc
	 * @param id
	 * @return
	 */
	public int updateWithdrawStautsByIdAndAuditInit(int withdrawStatus, int oldWithdrawStatus, String withdrawDesc, long id);

    /**
     * 修改提款状态
     * @param param
     * @return
     */
    public int cancelWithDraw(int withdrawStatus, int oldWithdrawStatus, String withdrawDesc, String auditInfo, long withDrawId);


	/***
	 * 查询最近三天，第三方申请中并且审核通过的提款记录-进行提款
	 * @param thirdPaymentWayList
	 * @return
	 */
	public List<UsrWithDraw> queryApplyingGetMoneyByAuditPass();

	/***
	 * 根据交易号查询提款记录
	 * @param uniqueIdToOuter
	 * @return
	 */
	public List<UsrWithDraw> queryUsrWithDrawByUniqueIdToOuter(long uniqueIdToOuter);

	/**
	 * 查询提款自动审核金额：
	 * 1.01≤提款金额≤5000
	 * 提款状态withdrawStatus=0为申请中或者初始化
	 * 审核状态auditStatus=0为审核中
	 * 超过十分钟，不超过2天前的提款申请IDS
	 * @param amountArr
	 * @return
	 */
	public List<Long> queryAutoWithDrawIds(String[] amountArr);


    /**
     * 查询已审核，状态为初始化，2个小时还未处理的信息
     * @return
     */
    public List<UsrWithDraw> handleInitScheduler();

    /**
	 *  获取指定银行卡号的当日提款金额（主要针对于连连提款）
	 * @param usrWithDrawVo
	 * @param bankNo
	 * @return
	 */
	public BigDecimal getDrawAmountTodayByBankNo(UsrWithDrawVo usrWithDrawVo, String bankNo);


	public List<UsrWithDraw> queryUsrWithDrawForSinaTransfer(UsrWithDrawVo usrWithDrawVo, Integer limit);

	public int updateRequsetWeiBoWithdrawStautsByIdAndAuditPass(int withdrawStatus, int oldWithdrawStatus, long id);

	/***
	 * 查询当日提款总金额（包括申请成功、处理中的、提款成功的数据）
	 * @param userId
	 * @param userType
	 * @return
	 */
	public BigDecimal querySumUserDayTotalAmount(long userId, int userType, int paymentWay);
	
	/**
	 * 给提款流水设置 关联号
	 * @param id
	 * @return
	 */
	public int updateTradeRelatedNoById(Long id, String tradeRelatedNo);

}

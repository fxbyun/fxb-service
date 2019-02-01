package service.manager;


import domain.tranlog.MoneyTransferLog;
import domain.tranlog.MoneyTransferSchedule;
import domain.tranlog.MoneyTransferScheduleContext;

public interface MoneyTransferManager {
	/***
	 * 执行退款的的划转
	 * 包括：1、用户钱包的划转
	 *     2、可能有抵扣券的划转
	 * @param moneyTransferScheduleContext
	 */
	public void tansferRefundMoney(MoneyTransferScheduleContext moneyTransferScheduleContext);
	/***
	 * 代收 或  代付  划转  
	 * <br>(退款的划转-可能包含抵扣券-使用MoneyTransferManager.tansferRefundMoney)
	 * @param moneyTransferScheduleContext
	 * @return
	 */
	public MoneyTransferScheduleContext tansferMoney(MoneyTransferScheduleContext moneyTransferScheduleContext);

	/**
	 * 修改计划-和log-成功
	 * @param moneyTransferSchedule
	 * @param moneyTransferLog
	 */
	public boolean updateTransferSucces(MoneyTransferSchedule moneyTransferSchedule, MoneyTransferLog moneyTransferLog);
	/***
	 * 修改计划-和log-成功-并且修改原资金来源ID
	 * 场景：由于加钱是先加新浪钱包，但加新浪钱包时还没有 资金来源ID，所以在本地加钱之后 再update进去
	 * @param moneyTransferSchedule
	 * @param moneyTransferLog
	 * @param amountSourceId
	 */
	public boolean updateTransferSucces(MoneyTransferSchedule moneyTransferSchedule, MoneyTransferLog moneyTransferLog, Long amountSourceId);
	/***
	 * 修改成失败-标志着 这一笔划转-作废结束
	 * @param moneyTransferSchedule
	 * @param moneyTransferLog
	 * @param errorMsg
	 */
	public boolean updateTransferFail(MoneyTransferSchedule moneyTransferSchedule, MoneyTransferLog moneyTransferLog, String errorMsg);
	/***
	 * 修改成故障-需要人工干预
	 * @param moneyTransferSchedule
	 * @param moneyTransferLog
	 * @param errorMsg
	 */
	public boolean updateTransferStoped(MoneyTransferSchedule moneyTransferSchedule, MoneyTransferLog moneyTransferLog, String errorMsg);

	/***
	 * 新浪普惠划转接口
	 * @param moneyTransferScheduleContext
	 * @return
	 */
	public MoneyTransferScheduleContext tansferMoneyBySinaPh(MoneyTransferScheduleContext moneyTransferScheduleContext);
}

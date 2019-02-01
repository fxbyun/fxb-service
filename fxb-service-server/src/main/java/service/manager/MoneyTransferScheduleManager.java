package service.manager;


import domain.entity.ModelResult;
import domain.tranlog.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public interface MoneyTransferScheduleManager {
	public MoneyTransferSchedule buildWithoutSave(int bizType, int sourceBizorderType, long sourceBizorderId, int internalOuterMode, Long memberId) ;
	 public	MoneyTransferSchedule initMoneyTransferSchedule(MoneyTransferSchedule moneyTransferSchedule,
                                                               int internalTransferStatus, int outerTransferStatus, int status);

	public MoneyTransferSchedule insertMoneyTransferSchedule(MoneyTransferSchedule moneyTransferSchedule);

	public MoneyTransferSchedule queryMoneyTransferScheduleById(long id);

	public List<MoneyTransferSchedule> queryMoneyTransferScheduleList(int bizType, int sourceBizorderType, long sourceBizorderId);

	public boolean updateInternalTransferStatus(int internalTransferStatus, int oldInternalTransferStatus, long id);

	public boolean updateOuterTransferStatus(int outerTransferStatus, int oldOuterTransferStatus, long id);

	public boolean updateMoneyTransferScheduleStatus(int status, int oldStatus, long id);

	public boolean updateMoneyTransferLogStatus(int transferStatus, long id);

	public MoneyTransferLog insertMoneyTransferLog(MoneyTransferLog moneyTransferLog);

	public MoneyTransferLog queryMoneyTransferLogById(long id);

	public MoneyTransferLog queryMoneyTransferLog(int fromAccountType, String fromAccountId, int toAccountType, String toAccountId, long transferScheduleId, int amountSourceType, long amountSourceId);

	public List<MoneyTransferLog> queryMemberTransferLogByScheduleId(long transferScheduleId);

	public int updateMoneyTransferScheduleAllStatus(MoneyTransferScheduleOption option);

	public BigDecimal sumTransferAmount(MoneyTransferLogOption option);

	public boolean updateTransferLogStatus(int transferLogToStatus, int transferLogOldStatus, long transferLogId);

	public boolean updateTransferLogStatusAndUniqId(int transferLogToStatus, int transferLogOldStatus, long transferLogId);

	public MoneyTransferSchedule queryMoneyTransferScheduleByUniqueIdToOuter(long uniqueIdToOuter);

	public MoneyTransferLog queryMemberTransferLogByUniqueIdToOuter(long uniqueIdToOuter);

	public boolean updateTransferLogStatusAndAmountSourceId(int transferLogToStatus, int transferLogOldStatus, long amountSourceId, long transferLogId);

	public boolean updateTransferLogStatusBytypeAndMsg(int transferLogToStatus, int transferLogOldStatus, String transferResponseMsg, long transferLogId);

	public List<Long> queryTransferLogIdByProcessingTimeout(List<Integer> bizTypeList, int transferStatus, Calendar transferStatusContinueTime, Calendar transferStatusEndTime, long flagBit);

	public boolean updateTransferLogFlagBitAndFeaturesById(long id, String features, Long flagBit);

	public boolean updateTransferLogUniqueIdFromOuterById(String uniqueIdFromOuter, long transferLogId);

	public MoneyTransferSchedule queryBySourceBizorderId(long sourceBizorderId, int sourceBizorderType);

	public boolean updateMoneyTransferLogRelateTypeAndRelateId(Long transferLogId, int relateType, Long relateId);

	/***
	 * 处理所有故障的划转计划
	 * 需要注意- 不支持一个计划下多个划转
	 * @return 故障的记录数
	 */
	public ModelResult<Integer> performAllStoppedTransfer();
	/***
	 * 处理所有故障的划转计划
	 * @param bizTypeList 指定业务类型
	 * @return
	 */
	public ModelResult<Integer> performAllStoppedTransfer(List<Integer> bizTypeList, Calendar beginTime, Calendar endTime);
	public List<MoneyTransferLog> queryMoneyTransferLogListByStopped(List<Integer> bizTypeList, Calendar beginTime, Calendar endTime);
	/**
	 * 按业务类别查询总金额
	 * @param bizType
	 * @return
	 */
	public BigDecimal queryAmountByBizType(int bizType, Date beginDate, Date endDate);

	public void insertScheduleAndLog(MoneyTransferScheduleContext context,
									 MoneyTransferSchedule transferSchedule,
									 List<MoneyTransferLog> moneyTransferLogList);

	public void buildScheduleLog(BigDecimal amount, int amountSourceType, long amountSourceId, String checkCodePrefix,
                                 MoneyTransferLog moneyTransferLog);
	public MoneyTransferSchedule buildSchedule(int bizType, int sourceBizorderType, long sourceBizorderId, long userId, String BizNo) ;
}

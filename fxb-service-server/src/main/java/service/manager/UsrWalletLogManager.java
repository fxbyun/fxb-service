package service.manager;

import domain.entity.UsrWalletLog;
import domain.entity.UsrWalletLogQueryOption;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public interface UsrWalletLogManager {
	public int insertWalletLog(UsrWalletLog walletLog) ;
 
	public List<UsrWalletLog> queryWalletLogListByTransTypeAndOrderId(int transType, long orderId, int userType);
	public int isExistSameWalletLogByOrderIdAndTransType(long orderId, Integer transType, int userType);

	/**
	 * @param condition
	 * @return
	 */
	public List<UsrWalletLog> queryWithCondition(UsrWalletLogQueryOption condition);

    /**
     * 判断收益流水是否存在
     * @return
     */
    public boolean isBonusLogExist(long userId, int userType, long usrBonusLogId);

    /**
     * 查询门店用户的代购收入
     * @param condition
     * @return
     */
    public BigDecimal sellSumMoney(UsrWalletLogQueryOption condition);

	 /***
	  * 汇总钱包流水金额
	  * @param userType
	  * @param userId
	  * @param transTypeList
	  * @param startTime
	  * @param endTime
	  * @return
	  */
	 public BigDecimal sumWalletLogAmountByUserId(int userType,
                                                  long userId, Integer[] transTypeList, Calendar startTime,
                                                  Calendar endTime);
	/**
	 * 查询站点用户钱包流水,用于导出excel.
	 * @param userId
	 * @param
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<UsrWalletLog> queryProviderWalletLogExcelDataByUserId(Long userId, Integer[] transTypes, Calendar startTime, Calendar endTime);

	/**
	 * 世界杯期间赠送彩金
	 * @param userId
	 * @return
	 */
	public BigDecimal sjbZsGiftAmount(Long userId);

	/**
     * 给钱包流水加标记
     */
    public boolean addFlagBit(long walletLogId, long flagBit, int userType);
    
    /**
     * 批量给钱包流水加标记
     */
	public int addFlagBitByOption(long flagBit, UsrWalletLogQueryOption condition);


	
}

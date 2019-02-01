package service.manager.impl;

import domain.entity.UsrWalletLog;
import domain.entity.UsrWalletLogQueryOption;
import domain.type.TransType;
import domain.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import service.manager.UsrWalletLogManager;

import java.math.BigDecimal;
import java.util.*;

public class UsrWalletLogManagerImpl implements UsrWalletLogManager {

	private static final Logger log = LoggerFactory.getLogger(UsrWalletLogManagerImpl.class) ;

	@Override
	public int insertWalletLog(UsrWalletLog walletLog) {
		return 0;
	}

	@Override
	public List<UsrWalletLog> queryWalletLogListByTransTypeAndOrderId(int transType, long orderId, int userType) {
		return null;
	}

	@Override
	public int isExistSameWalletLogByOrderIdAndTransType(long orderId, Integer transType, int userType) {
		return 0;
	}

	@Override
	public List<UsrWalletLog> queryWithCondition(UsrWalletLogQueryOption condition) {
		return null;
	}

	@Override
	public boolean isBonusLogExist(long userId, int userType, long usrBonusLogId) {
		return false;
	}

	@Override
	public BigDecimal sellSumMoney(UsrWalletLogQueryOption condition) {
		return null;
	}

	@Override
	public BigDecimal sumWalletLogAmountByUserId(int userType, long userId, Integer[] transTypeList, Calendar startTime, Calendar endTime) {
		return null;
	}

	@Override
	public List<UsrWalletLog> queryProviderWalletLogExcelDataByUserId(Long userId, Integer[] transTypes, Calendar startTime, Calendar endTime) {
		return null;
	}

	@Override
	public BigDecimal sjbZsGiftAmount(Long userId) {
		return null;
	}

	@Override
	public boolean addFlagBit(long walletLogId, long flagBit, int userType) {
		return false;
	}

	@Override
	public int addFlagBitByOption(long flagBit, UsrWalletLogQueryOption condition) {
		return 0;
	}
}


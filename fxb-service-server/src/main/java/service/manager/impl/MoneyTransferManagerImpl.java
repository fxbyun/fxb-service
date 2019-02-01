package service.manager.impl;

import domain.entity.ModelResult;
import domain.tranlog.MoneyTransferLog;
import domain.tranlog.MoneyTransferSchedule;
import domain.tranlog.MoneyTransferScheduleContext;
import domain.type.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.manager.MoneyTransferManager;
import service.manager.MoneyTransferScheduleManager;

public class MoneyTransferManagerImpl implements MoneyTransferManager {

    private static final transient Logger logger = LoggerFactory.getLogger(MoneyTransferManagerImpl.class);

    private MoneyTransferScheduleManager moneyTransferScheduleManager;

    @Override
    public void tansferRefundMoney(MoneyTransferScheduleContext moneyTransferScheduleContext) {

    }

    @Override
    public MoneyTransferScheduleContext tansferMoney(MoneyTransferScheduleContext moneyTransferScheduleContext) {
        return null;
    }

    @Override
    public boolean updateTransferSucces(MoneyTransferSchedule moneyTransferSchedule, MoneyTransferLog moneyTransferLog) {
        return false;
    }

    @Override
    public boolean updateTransferSucces(MoneyTransferSchedule moneyTransferSchedule, MoneyTransferLog moneyTransferLog, Long amountSourceId) {
        return false;
    }

    @Override
    public boolean updateTransferFail(MoneyTransferSchedule moneyTransferSchedule, MoneyTransferLog moneyTransferLog, String errorMsg) {
        return false;
    }

    @Override
    public boolean updateTransferStoped(MoneyTransferSchedule moneyTransferSchedule, MoneyTransferLog moneyTransferLog, String errorMsg) {
        return false;
    }

    @Override
    public MoneyTransferScheduleContext tansferMoneyBySinaPh(MoneyTransferScheduleContext moneyTransferScheduleContext) {
        return null;
    }
}

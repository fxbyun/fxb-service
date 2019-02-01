package domain.exception;

 

/**
 * 钱包错误码
 * @project commons
 * @author yaya
 * @date 2010-12-2
 * Copyright (C) 2010-2012 www.2caipiao.com Inc. All rights reserved.
 */
public class WalletErrorTable extends BaseErrorTable {

    /**钱包余额不足*/
    public static final ErrorCode NOT_SUFFICIENT_FUNDS = new ErrorCode("not.sufficient.funds", "钱包余额不足");

    /** 重复的交易 */
    public static final ErrorCode REPEATED_TRANS = new ErrorCode("repeated.trans", "重复的交易");

    /** 无效的关联交易 */
    public static final ErrorCode ILLEGAL_RELATE_TRANS = new ErrorCode("illegal.relate.trans", "无效的关联交易或交易类型");
    
    /** 无效的关联交易 */
    public static final ErrorCode ILLEGAL_First_OPTION = new ErrorCode("illegal.firt.option", "无效的金额优先选项");

    /** 交易金额非法 */
    public static final ErrorCode ILLEGAL_TRANS_AMOUNT = new ErrorCode("illegal.trans.amount", "交易金额非法");
    /** 提款参数非法 */
    public static final ErrorCode GET_MONEY_PARM_ERROR = new ErrorCode("get.money.parm.error", "提款参数非法");
    
    /** 提款三笔限制 */
    public static final ErrorCode GET_MONEY_THREE_LIMITED = new ErrorCode("get.money.three.limited", "一天提款不能超过三笔.");
	/** 提款绑定类型错误 */
	public static final ErrorCode GET_MONEY_BIND_TYPE_ERROR = new ErrorCode("get.money.bind.type.error", "提款绑定类型错误");
	/** 提款必要参数不能为空 */
	public static final ErrorCode GET_MONEY_PARAMETER_NOT_BLANK  = new ErrorCode("get.money.bind.type.error", "提款必要参数不能为空");
    /***
     * 用户在迁移中
     */
    public static final ErrorCode MEMBER_IS_MIGRATING = new ErrorCode("member_is_migrating", "用户正在迁移中,退出处理!");
    
    /***
     * 修改条数不一致
     */
    public static final ErrorCode COUNT_NOT_EQUAL = new ErrorCode("count_not_equal", "修改站点钱包时流水修改条数不一致,退出处理!");
}
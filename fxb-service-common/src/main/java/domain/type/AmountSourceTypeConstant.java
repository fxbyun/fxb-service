package domain.type;

public class AmountSourceTypeConstant {
    //用户钱包流水    
	public static int usrWalletLogConsumer = 1;
    //站点钱包流水
    public static int usrWalletLogProvider = 3;
    
    //订单
    public static int tzOrder = 5;
	
	public static int memberChargeLog = 10;
	//提款请求
	public static int membergetmoneylog = 12;
	
	//损益金额划转
	public static int lossProfitMoneyTransfer = 15;
	
	// 批量派奖
	public static int batchPrize = 16;
	
	
	// 借款还款
	public static int moneyPlatConsumer = 17;

	//用户活动礼品表
	public static int hd_gift_log = 18;
	
	//用户活动兑换码表
	public static int hd_charg_code=19;
	
	//用户支付流水表
	public static int usr_pay_log = 20;

	
	
	public static int tzHoldonIssue= 21;

	//回购表
	public static int tz_repo_order = 22;
	
	/**
	 * 跟投方案
	 */
	public static int gtFollowPlan = 23;

	/**
	 *第三方业务关联表
	 */
	public static int usr_third_business = 24;
	/**
	 *部分出票
	 */
	public static int tz_ticket_part = 25;
	/**
	 * 代理领奖
	 */
	public static int transferAward = 26;
	/***
	 * 根据用户（普通会员、站点用户）类型返回金额来源类型
	 * @param userType
	 * @return
	 */
	public static Integer getAmountSourceTypeByUserType(int userType){
		if(userType==UserType.buyer.getIndex()){
			return AmountSourceTypeConstant.usrWalletLogConsumer;
		}else if(userType==UserType.seller.getIndex()){
			return AmountSourceTypeConstant.usrWalletLogProvider;
		}
		return null;
	}
}

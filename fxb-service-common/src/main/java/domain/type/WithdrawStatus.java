package domain.type;

import java.util.List;

/**
 * 提款状态
 * 新浪提款-初始化-> 审核通过 -> 等新浪代付成功 -> 才改成审核中   
 * @author ming.chen
 *
 */
public class WithdrawStatus extends BaseType {
	private static final long serialVersionUID = -4381322126225374226L;

	public WithdrawStatus(Integer status, String description){
		super(status, description);
	}
	/***
	 *  初始化状态 
	 *  <p>新浪提款： 允许用户取消  （如果是审核成功的   允许用户提款）
	 *  <p>连连支付等第三方提款：如果还未审核  允许用户取消
	 */
	public static WithdrawStatus APPLICATION = new WithdrawStatus(0, "申请中");
	/***
	 * 支付中，就是跳转到新浪页面了，但没输入支付密码
	 * 定时任务会去扫描 支付中的数据,判断是否改成受理中
	 * <p>
	 * 对于连连支付等第三方提款: 无该状态
	 * 微博支付：表示确认转账中
	 * ***/
	public static WithdrawStatus PWD_PAYMENT = new WithdrawStatus(1, "支付中");
	/****
	 * 受理中
	 * <p>输入密码成功，银行在处理了
	 * <p>
	 * 对于连连支付等第三方提款：说明已成功提交到第三方提款
	 *    */
    public static WithdrawStatus PENDING_AUDIT  = new WithdrawStatus(2, "受理中");
	
    public static WithdrawStatus WD_SUCCESS  = new WithdrawStatus(3, "提款成功");

    public static WithdrawStatus WD_FAIL = new WithdrawStatus(4, "提款失败");
    
    public static WithdrawStatus BANK_REFUNDED = new WithdrawStatus(5, "银行退票");
    
    public static WithdrawStatus USER_CANCEL_WD = new WithdrawStatus(6, "用户取消提款");
    /****
     * 应该是冰鑫加的 补充一下解释：
     * 
     * 原因：由于用户已经升级, 新浪的提款  需要给用户新浪钱包 打一笔钱,所以增加初始化状态来控制
     * 处理过程：初始化  -> 新浪基本户 打钱给 用户新浪钱包  -> 申请中
     */
    public static WithdrawStatus WD_INIT = new WithdrawStatus(7, "初始化");
    
    public static WithdrawStatus WD_CANCEL_ING = new WithdrawStatus(8, "取消中");
    
    public static List<WithdrawStatus> getAllList() {
		return getAll(WithdrawStatus.class);
	}
    
	public static WithdrawStatus valueOf(Integer index){
		return valueOf(WithdrawStatus.class, index);
	}
	
}

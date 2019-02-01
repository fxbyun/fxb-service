package domain.type;

import java.util.List;

/**
 * 第三方支付状态 对应 usr_third_pay_log.pay_status
 * 和 usr_third_drawback_log.drawback_status共用
 *
 */
public class UsrThirdPayStatus extends BaseType{

	private static final long serialVersionUID = 1L;
	
	public static UsrThirdPayStatus created  = new UsrThirdPayStatus(0, "创建");
	public static UsrThirdPayStatus paying  = new UsrThirdPayStatus(1, "支付中");
	public static UsrThirdPayStatus pay_success  = new UsrThirdPayStatus(2, "支付成功");
	public static UsrThirdPayStatus pay_fail  = new UsrThirdPayStatus(3, "支付失败");
	public static UsrThirdPayStatus pay_break  = new UsrThirdPayStatus(4, "支付故障");
	public static UsrThirdPayStatus change  = new UsrThirdPayStatus(5, "转入代发");
	public static UsrThirdPayStatus not_balance  = new UsrThirdPayStatus(6, "余额不足");

	protected UsrThirdPayStatus(Integer index, String description) {
		super(index, description);
	}
	
	/***
	 * 是否可以重新请求的状态
	 * @param status
	 * @return
	 */
	public static boolean canReRequest(int status){
		if(pay_break.getIndex() == status) return true;
		if(pay_fail.getIndex() == status) return true;
		if(change.getIndex() == status) return true;
		if(created.getIndex() == status) return true;
		if(not_balance.getIndex() == status) return true;
		return false;
	}
	
	public static List<UsrThirdPayStatus> getAll() {
		return getAll(UsrThirdPayStatus.class);
	}

	public static UsrThirdPayStatus valueOf(Integer index) {
		return valueOf(UsrThirdPayStatus.class, index);
	}
}

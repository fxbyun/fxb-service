package domain.entity;
import domain.type.PaymentWay;

/***
 * 提款返回结果
 * @author zl
 *
 */
public class WithdrawResult extends BaseResult {

	private static final long serialVersionUID = -8254290656849052523L;
	 
	
	/**输入新浪支付密码界面地址**/
	private String sinaPayPwdUrl; 
	
	/***
	 * 提款支付方式  com.woqutz.didi.constants.PaymentWay
	 */
    private int paymentWay = PaymentWay.sina_pay;
 
	public String getSinaPayPwdUrl() {
		return sinaPayPwdUrl;
	}
	public void setSinaPayPwdUrl(String sinaPayPwdUrl) {
		this.sinaPayPwdUrl = sinaPayPwdUrl;
	}
	public int getPaymentWay() {
		return paymentWay;
	}
	public void setPaymentWay(int paymentWay) {
		this.paymentWay = paymentWay;
	}
	 
	
}

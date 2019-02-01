package domain.tranlog;
public class ThirdPayContext {

	/**支付流水*/
	private UsrPayLog usrPayLog;
	
	/**第三方支付退款*/
	private UsrThirdDrawbackLog usrThirdDrawbackLog;

	


	
	public UsrPayLog getUsrPayLog() {
		return usrPayLog;
	}

	public void setUsrPayLog(UsrPayLog usrPayLog) {
		this.usrPayLog = usrPayLog;
	}

	public UsrThirdDrawbackLog getUsrThirdDrawbackLog() {
		return usrThirdDrawbackLog;
	}

	public void setUsrThirdDrawbackLog(UsrThirdDrawbackLog usrThirdDrawbackLog) {
		this.usrThirdDrawbackLog = usrThirdDrawbackLog;
	}
 
	
	
	
}

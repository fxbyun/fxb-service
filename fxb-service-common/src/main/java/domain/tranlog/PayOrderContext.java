package domain.tranlog;

import domain.entity.UsrConsumer;
import domain.entity.UsrPayLog;
import domain.entity.UsrWalletLog;
import domain.type.UsrPayMerchant;

import java.util.List;

/***
 * 支付订单上下文
 * @author zl
 *
 */
public class PayOrderContext {
 
	private UsrWalletLog usrWalletLog;

	private MoneyTransferSchedule moneyTransferSchedule;
	private List<MoneyTransferLog> moneyTransferLogList;
	/***
	 * 专门增加抵扣券的划转计划
	 */
	private MoneyTransferSchedule rebateMoneyTransferSchedule;
	private List<MoneyTransferLog> rebateMoneyTransferLogList;
 
	/**第三方支付上下文*/
	private ThirdPayContext thirdPayContext;
	
	/**第三方支付流水*/
	private UsrThirdPayLog usrThirdPayLog;
	
	private UsrPayLog usrPayLog;
	
	private UsrConsumer usrConsumer;
	
	/***
	 * 本地钱包是否支付成功
	 */
	private boolean isPaySuccess=false;
	/***
	 * 是否需要发送抵扣卷-消息
	 */
	private boolean isSendRebatejsm;
	/***
	 * 前置业务-是否是新浪划转
	 */
	private boolean isPreSinaMoneyTransfer=false;
	
	private UsrPayMerchant usrPayMerchant = null;
	
	/***
	 * 是否是新浪划转
	 * @return
	 */
	public boolean isSinaMoneyTransfer(){
		if(moneyTransferSchedule!=null && moneyTransferLogList!=null){
			return true;
		}
		return false;
	}
	/***
	 * 是否是第三方支付
	 * @return
	 */
	public boolean isThirdPay(){
		if(usrThirdPayLog!=null){
			return true;
		}
		return false;
	}
	
	
	public UsrWalletLog getUsrWalletLog() {
		return usrWalletLog;
	}

	public void setUsrWalletLog(UsrWalletLog usrWalletLog) {
		this.usrWalletLog = usrWalletLog;
	}
	/**输入新浪支付密码界面地址**/
	private String sinaPayPwdUrl;

	public String getSinaPayPwdUrl() {
		return sinaPayPwdUrl;
	}

	public void setSinaPayPwdUrl(String sinaPayPwdUrl) {
		this.sinaPayPwdUrl = sinaPayPwdUrl;
	} 
	
	public MoneyTransferSchedule getMoneyTransferSchedule() {
		return moneyTransferSchedule;
	}
	public void setMoneyTransferSchedule(MoneyTransferSchedule moneyTransferSchedule) {
		this.moneyTransferSchedule = moneyTransferSchedule;
	}
	public List<MoneyTransferLog> getMoneyTransferLogList() {
		return moneyTransferLogList;
	}
	public void setMoneyTransferLogList(List<MoneyTransferLog> moneyTransferLogList) {
		this.moneyTransferLogList = moneyTransferLogList;
	}

	public MoneyTransferSchedule getRebateMoneyTransferSchedule() {
		return rebateMoneyTransferSchedule;
	}

	public void setRebateMoneyTransferSchedule(
			MoneyTransferSchedule rebateMoneyTransferSchedule) {
		this.rebateMoneyTransferSchedule = rebateMoneyTransferSchedule;
	}

	public List<MoneyTransferLog> getRebateMoneyTransferLogList() {
		return rebateMoneyTransferLogList;
	}

	public void setRebateMoneyTransferLogList(
			List<MoneyTransferLog> rebateMoneyTransferLogList) {
		this.rebateMoneyTransferLogList = rebateMoneyTransferLogList;
	}

	public boolean isPaySuccess() {
		return isPaySuccess;
	}

	public void setPaySuccess(boolean isPaySuccess) {
		this.isPaySuccess = isPaySuccess;
	}

	public ThirdPayContext getThirdPayContext() {
		return thirdPayContext;
	}

	public void setThirdPayContext(ThirdPayContext thirdPayContext) {
		this.thirdPayContext = thirdPayContext;
	}

	public UsrThirdPayLog getUsrThirdPayLog() {
		return usrThirdPayLog;
	}

	public void setUsrThirdPayLog(UsrThirdPayLog usrThirdPayLog) {
		this.usrThirdPayLog = usrThirdPayLog;
	}
	public UsrPayLog getUsrPayLog() {
		return usrPayLog;
	}
	public void setUsrPayLog(UsrPayLog usrPayLog) {
		this.usrPayLog = usrPayLog;
	}
	public UsrConsumer getUsrConsumer() {
		return usrConsumer;
	}
	public void setUsrConsumer(UsrConsumer usrConsumer) {
		this.usrConsumer = usrConsumer;
	}
	public boolean isSendRebatejsm() {
		return isSendRebatejsm;
	}
	public void setSendRebatejsm(boolean isSendRebatejsm) {
		this.isSendRebatejsm = isSendRebatejsm;
	}
	/***
	 * 前置支付是否 有新浪划转,如果有则需要新浪退款
	 * @return
	 */
	public boolean isPreSinaMoneyTransfer() {
		return isPreSinaMoneyTransfer;
	}

	public void setPreSinaMoneyTransfer(boolean isPreSinaMoneyTransfer) {
		this.isPreSinaMoneyTransfer = isPreSinaMoneyTransfer;
	}
	public UsrPayMerchant getUsrPayMerchant() {
		return usrPayMerchant;
	}
	public void setUsrPayMerchant(UsrPayMerchant usrPayMerchant) {
		this.usrPayMerchant = usrPayMerchant;
	}
	
	  
}




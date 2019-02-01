package domain.tranlog;


import java.io.Serializable;
import java.util.List;


/**
 * 划转计划上下文
 * @author zl
 *
 */
public class MoneyTransferScheduleContext implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private MoneyTransferSchedule moneyTransferSchedule;
	private List<MoneyTransferLog> moneyTransferLogList;
	
	/***
	 * 专门增加抵扣券的划转计划
	 */
	private MoneyTransferSchedule rebateMoneyTransferSchedule;
	private List<MoneyTransferLog> rebateMoneyTransferLogList;
	
	
    /***
     * 新浪输入支付密码-后  返回商户地址
     */
	private String payPwdReturnUrl;
	
    /***
     * 新浪返回输入支付密码 地址
     */
	private String sinaPayPwdUrl;
	 /***
     * 新浪返回输入支付密码 html源码
     */
	private String sinaPayPwdHtmlSource; 
	
	
	private TzTransferAward tzTransferAward;
 
 
	public MoneyTransferScheduleContext(){}
	public MoneyTransferScheduleContext(MoneyTransferSchedule moneyTransferSchedule,
                                        List<MoneyTransferLog> moneyTransferLogList){
		this.setMoneyTransferLogList(moneyTransferLogList);
		this.setMoneyTransferSchedule(moneyTransferSchedule);
	}
	public MoneyTransferScheduleContext(PayOrderContext payOrderContext){
		if(payOrderContext!=null){
			this.setMoneyTransferLogList(payOrderContext.getMoneyTransferLogList());
			this.setMoneyTransferSchedule(payOrderContext.getMoneyTransferSchedule());
			
			this.setRebateMoneyTransferLogList(payOrderContext.getRebateMoneyTransferLogList());
			this.setRebateMoneyTransferSchedule(payOrderContext.getRebateMoneyTransferSchedule());
		}
	}
	 
	public List<MoneyTransferLog> getMoneyTransferLogList() {
		return moneyTransferLogList;
	}
	public void setMoneyTransferLogList(List<MoneyTransferLog> moneyTransferLogList) {
		this.moneyTransferLogList = moneyTransferLogList;
	}
 
	public MoneyTransferSchedule getMoneyTransferSchedule() {
		return moneyTransferSchedule;
	}
	public void setMoneyTransferSchedule(MoneyTransferSchedule moneyTransferSchedule) {
		this.moneyTransferSchedule = moneyTransferSchedule;
	}
	public String getPayPwdReturnUrl() {
		return payPwdReturnUrl;
	}
	public void setPayPwdReturnUrl(String payPwdReturnUrl) {
		this.payPwdReturnUrl = payPwdReturnUrl;
	}
	public String getSinaPayPwdUrl() {
		return sinaPayPwdUrl;
	}
	public void setSinaPayPwdUrl(String sinaPayPwdUrl) {
		this.sinaPayPwdUrl = sinaPayPwdUrl;
	}
	public String getSinaPayPwdHtmlSource() {
		return sinaPayPwdHtmlSource;
	}
	public void setSinaPayPwdHtmlSource(String sinaPayPwdHtmlSource) {
		this.sinaPayPwdHtmlSource = sinaPayPwdHtmlSource;
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
	
	public TzTransferAward getTzTransferAward() {
		return tzTransferAward;
	}
	public void setTzTransferAward(TzTransferAward tzTransferAward) {
		this.tzTransferAward = tzTransferAward;
	}
	public MoneyTransferScheduleContext getRebateMoneyTransferScheduleContext() {
		MoneyTransferScheduleContext context = new MoneyTransferScheduleContext();
		context.setMoneyTransferLogList(this.getRebateMoneyTransferLogList());
		context.setMoneyTransferSchedule(this.getRebateMoneyTransferSchedule());
		return context;
	}
 
}

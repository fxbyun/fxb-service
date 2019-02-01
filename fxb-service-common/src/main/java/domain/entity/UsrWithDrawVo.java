package domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UsrWithDrawVo implements Serializable{

	private static final long serialVersionUID = 5812930391572006563L;

	private Long id;
	
	/**用户类型：0 购彩用户；1 站点用户*/
	private Integer userType;
	
	/**用户或者站长ID*/
	private Long userId;
	
	/**用户帐号*/
	private String account;
	
	/**对应usr_consumer_bind_card的主键*/
	private Long bindCardId;
	
	/**商户交易号--可据此流水号去对方查询相关信息*/
    private String businessTradeNo;
    
    /**和对方关联号--新浪提现交易流水号*/
    private Long uniqueIdToOuter;
	
	/**提款金额*/
	private BigDecimal amount = BigDecimal.ZERO;
	private BigDecimal startAmount;
	private BigDecimal endAmount;
	
	/**用户承担的手续费*/
	private BigDecimal userFee = BigDecimal.ZERO;
	
	/**提款状态:0申请中;1支付中;2受理中;3 提款成功;4 提款失败;5 银行退票;6用户取消退款*/
	private Integer withdrawStatus;
	
	private List<Integer> withdrawStatusList;
	
	/**提交新浪接口时间*/
	private Date requestTime;
    private Date startRequestTime;
    private Date endRequestTime;
	
	/**提款成功或者失败时间*/
	private Date withdrawTime;
	private Date startWithdrawTime;
	private Date endWithdrawTime;
	
	/**提款备注（失败原因等）*/
	private String withdrawDesc;
	
	/**客户端,0 WEB 1 WAP*/
	private Integer sellClient;
	
	/**审核状态：0审核中;1审核不通过; 2审核通过*/
	private Integer auditStatus;
	
	/**提款审核人*/
	private String auditUser;
	
	/**审核备注信息*/
	private String auditInfo;
	
	/**审核时间*/
	private Date auditTime;
	/**审核前时间*/
	private Date beforeAuditTime;
	
	/**创建时间**/
	private Date createTime;
	private Date startCreateTime;
	private Date endCreateTime;
	
	private Date updateTime;
	
	//普惠第三方交易关联号
	private String tradeRelatedNo ;
	
	
	/***
	 * 提款支付方式  com.woqutz.didi.constants.PaymentWay
	 */
    private int paymentWay;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Long getBindCardId() {
		return bindCardId;
	}

	public void setBindCardId(Long bindCardId) {
		this.bindCardId = bindCardId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getUserFee() {
		return userFee;
	}

	public void setUserFee(BigDecimal userFee) {
		this.userFee = userFee;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public Date getWithdrawTime() {
		return withdrawTime;
	}

	public void setWithdrawTime(Date withdrawTime) {
		this.withdrawTime = withdrawTime;
	}

	public String getWithdrawDesc() {
		return withdrawDesc;
	}

	public void setWithdrawDesc(String withdrawDesc) {
		this.withdrawDesc = withdrawDesc;
	}
	
	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getWithdrawStatus() {
		return withdrawStatus;
	}

	public void setWithdrawStatus(Integer withdrawStatus) {
		this.withdrawStatus = withdrawStatus;
	}

	public List<Integer> getWithdrawStatusList() {
		return withdrawStatusList;
	}

	public void setWithdrawStatusList(List<Integer> withdrawStatusList) {
		this.withdrawStatusList = withdrawStatusList;
	}

	public Integer getSellClient() {
		return sellClient;
	}

	public void setSellClient(Integer sellClient) {
		this.sellClient = sellClient;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public String getAuditInfo() {
		return auditInfo;
	}

	public void setAuditInfo(String auditInfo) {
		this.auditInfo = auditInfo;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getStartCreateTime() {
		return startCreateTime;
	}

	public void setStartCreateTime(Date startCreateTime) {
		this.startCreateTime = startCreateTime;
	}

	public Date getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(Date endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

	public String getBusinessTradeNo() {
		return businessTradeNo;
	}

	public void setBusinessTradeNo(String businessTradeNo) {
		this.businessTradeNo = businessTradeNo;
	}

	public Long getUniqueIdToOuter() {
		return uniqueIdToOuter;
	}

	public void setUniqueIdToOuter(Long uniqueIdToOuter) {
		this.uniqueIdToOuter = uniqueIdToOuter;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getStartWithdrawTime() {
		return startWithdrawTime;
	}

	public void setStartWithdrawTime(Date startWithdrawTime) {
		this.startWithdrawTime = startWithdrawTime;
	}

	public Date getEndWithdrawTime() {
		return endWithdrawTime;
	}

	public void setEndWithdrawTime(Date endWithdrawTime) {
		this.endWithdrawTime = endWithdrawTime;
	}

	public BigDecimal getStartAmount() {
		return startAmount;
	}

	public void setStartAmount(BigDecimal startAmount) {
		this.startAmount = startAmount;
	}

	public BigDecimal getEndAmount() {
		return endAmount;
	}

	public void setEndAmount(BigDecimal endAmount) {
		this.endAmount = endAmount;
	}

	public int getPaymentWay() {
		return paymentWay;
	}

	public void setPaymentWay(int paymentWay) {
		this.paymentWay = paymentWay;
	}

    public Date getStartRequestTime() {
        return startRequestTime;
    }

    public void setStartRequestTime(Date startRequestTime) {
        this.startRequestTime = startRequestTime;
    }

    public Date getEndRequestTime() {
        return endRequestTime;
    }

    public void setEndRequestTime(Date endRequestTime) {
        this.endRequestTime = endRequestTime;
    }

	public Date getBeforeAuditTime() {
		return beforeAuditTime;
	}

	public void setBeforeAuditTime(Date beforeAuditTime) {
		this.beforeAuditTime = beforeAuditTime;
	}

	public String getTradeRelatedNo() {
		return tradeRelatedNo;
	}

	public void setTradeRelatedNo(String tradeRelatedNo) {
		this.tradeRelatedNo = tradeRelatedNo;
	}
    
    
}
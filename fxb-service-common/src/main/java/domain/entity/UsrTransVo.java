package domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员钱包交易VO
 * @author zl
 *
 */
public class UsrTransVo implements Serializable{
private static final long serialVersionUID = 1L;
	
	private  Long payOrderId;
	
	private  Long userId;//钱包将要变化的用户
	/**用户类型 */
	private Integer userType;
	private  BigDecimal amount;//要交易的钱(包括彩金)
	
	private  Integer transType;//交易类型(由orderType和payType决定)
	private  Integer reTransType;//关联交易类型
	/**
	 * 关联交易业务id，也是起始业务id
	 */
	private  Long reTransOrderId;//关联交易业务id，也是起始业务id
	/**
	 * 如果是追号解冻，则这个为追号明细的id
	 */
	private  Long transOrderId;//如果是追号解冻，则这个为追号明细的id
	private  String transOrderNo;
	
	private  Integer gameId;
	private  String planNo;
	private  String issueNo;
	
	private Date transTime;//交易时间
	/***
	 * true: 说明有新浪划转计划
	 * 钱包流水标记是否有新浪划转,参数  
	 */
	private boolean isPreSinaMoneyTransfer=false;
	
	/***
	 * 交易方式等信息，例如（支付宝、微信支付、银行卡1234）
	 */
	private String transInfo;//交易方式等信息
	
	public UsrTransVo(){}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Integer getTransType() {
		return transType;
	}
	public void setTransType(Integer transType) {
		this.transType = transType;
	}
	public Integer getReTransType() {
		return reTransType;
	}
	public void setReTransType(Integer reTransType) {
		this.reTransType = reTransType;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	 
	public Long getTransOrderId() {
		return transOrderId;
	}
	public void setTransOrderId(Long transOrderId) {
		this.transOrderId = transOrderId;
	}
	
	public String getTransOrderNo() {
		return transOrderNo;
	}
	public void setTransOrderNo(String transOrderNo) {
		this.transOrderNo = transOrderNo;
	}
	
	public Integer getGameId() {
		return gameId;
	}
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}
	public String getPlanNo() {
		return planNo;
	}
	public void setPlanNo(String planNo) {
		this.planNo = planNo;
	}
	public String getIssueNo() {
		return issueNo;
	}
	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}
	public Long getPayOrderId() {
		return payOrderId;
	}
	public void setPayOrderId(Long payOrderId) {
		this.payOrderId = payOrderId;
	}
	
	public Long getReTransOrderId() {
		return reTransOrderId;
	}
	public void setReTransOrderId(Long reTransOrderId) {
		this.reTransOrderId = reTransOrderId;
	}

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }
	 
    public boolean isPreSinaMoneyTransfer() {
		return isPreSinaMoneyTransfer;
	}

	public void setPreSinaMoneyTransfer(boolean isPreSinaMoneyTransfer) {
		this.isPreSinaMoneyTransfer = isPreSinaMoneyTransfer;
	}
	public String getTransInfo() {
		return transInfo;
	}
	public void setTransInfo(String transInfo) {
		this.transInfo = transInfo;
	}
	
	
}

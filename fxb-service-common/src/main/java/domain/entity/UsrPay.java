package domain.entity;

import java.util.Date;

public class UsrPay extends BaseEntity{
	private static final long serialVersionUID = 4041220737792043623L;

	/** 支付名称 */
    private String payName;
    /** 支付类型 1支付宝，2微信,3银行卡 */
    private Integer payType;

    /** 支付帐号 */
    private String payAccount;

    /** 支付记录状态 1有效 0无效 */
    private Integer payStatus;
    /** 创建时间  */
    private Date createTime;

    /**帐号姓名 */
    private String accountName;

    /** 用户ID */
    private Long consumerId;
    /** 1是 0不是 */
    private Integer isDefaultPay;

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName == null ? null : payName.trim();
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount == null ? null : payAccount.trim();
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

	public Integer getIsDefaultPay() {
		return isDefaultPay;
	}

	public void setIsDefaultPay(Integer isDefaultPay) {
		this.isDefaultPay = isDefaultPay;
	}
}
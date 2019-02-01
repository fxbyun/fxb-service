package domain.entity;

import java.math.BigDecimal;
import java.util.Date;

public class UsrWithDraw extends BaseEntity {

    private static final long serialVersionUID = 9037524145167280393L;

    /**用户类型：0 购彩用户；1 站点用户*/
    private Integer userType;

    /**用户或者站长ID*/
    private Long userId;

    /**用户帐号*/
    private String account;
    
    /**  对应usr_bind_card的sina_card_id */
    private Long bindCardId;
    private UsrBindCard usrBindCard;
    
    /**商户交易号--可据此流水号去对方查询相关信息*/
    private String businessTradeNo;
    
    /**和对方关联号--新浪提现交易流水号*/
    private Long uniqueIdToOuter;

    /**提款金额*/
    private BigDecimal amount = BigDecimal.ZERO;

    /**用户承担的手续费*/
    private BigDecimal userFee = BigDecimal.ZERO;

    /**提款状态:0申请中;1受理中;2 提款成功;3 提款失败;4 银行退票*/
    private Integer withdrawStatus;

    /**提交新浪接口时间*/
    private Date requestTime;

    /**提款成功或者失败时间*/
    private Date withdrawTime;

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

    /**创建时间**/
    private Date createTime;
    
    /**更新时间**/
    private Date updateTime;
    
    /**计划表log状态*/
    private Integer transferStatus;
    
	/***
	 * 市场渠道
	 */
	private long sellChannel;
	/***
	 * 提款支付方式  com.woqutz.didi.constants.PaymentWay
	 */
    private int paymentWay;
    /** 银行代码 */
    private String bankCode;
    /** 银行名称 */
    private String bankName;
    /** 银行卡号 */
    private String bankNo;
    
    /** 省份 */
    private String provinces;
    /** 城市 */
    private String city;
    /** 分行 */
    private String partBank;

    /*****数据库并无该字段-只作为参数传递
     * <p> 对应UsrBindCard.id****/
    private int usrBindCardId;

    private String isTransfer;
    
    /** 第三方交易关联号*/
    private String tradeRelatedNo;

    public String getIsTransfer() {
        return isTransfer;
    }

    public void setIsTransfer(String isTransfer) {
        this.isTransfer = isTransfer;
    }

    public UsrWithDraw(){
    }
    
    public UsrWithDraw(Long id, Integer auditStatus, String auditUser, String auditInfo, Date auditTime, Date updateTime){
    	this.id = id;
    	this.auditStatus = auditStatus;
    	this.auditUser = auditUser;
    	this.auditInfo = auditInfo;
    	this.auditTime = auditTime;
    	this.updateTime = updateTime;
    }
    
    public UsrWithDraw(Long id, Integer withdrawStatus, String withdrawDesc, Date withdrawTime, Date updateTime){
    	this.id = id;
    	this.withdrawStatus = withdrawStatus;
    	this.withdrawDesc = withdrawDesc;
    	this.withdrawTime = withdrawTime;
    	this.updateTime = updateTime;
    }
    
    public UsrWithDraw(Long id, Integer auditStatus, String auditUser, String auditInfo, Date auditTime
    		, Integer withdrawStatus, String withdrawDesc, Date withdrawTime, Date updateTime){
    	this.id = id;
    	this.auditStatus = auditStatus;
    	this.auditUser = auditUser;
    	this.auditInfo = auditInfo;
    	this.auditTime = auditTime;
    	this.updateTime = updateTime;
    	this.withdrawStatus = withdrawStatus;
    	this.withdrawDesc = withdrawDesc;
    	this.withdrawTime = withdrawTime;
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

	public UsrBindCard getUsrBindCard() {
		return usrBindCard;
	}

	public void setUsrBindCard(UsrBindCard usrBindCard) {
		this.usrBindCard = usrBindCard;
	}

	public Integer getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(Integer transferStatus) {
		this.transferStatus = transferStatus;
	}

	public long getSellChannel() {
		return sellChannel;
	}

	public void setSellChannel(long sellChannel) {
		this.sellChannel = sellChannel;
	}

	public int getPaymentWay() {
		return paymentWay;
	}

	public void setPaymentWay(int paymentWay) {
		this.paymentWay = paymentWay;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getProvinces() {
		return provinces;
	}

	public void setProvinces(String provinces) {
		this.provinces = provinces;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPartBank() {
		return partBank;
	}

	public void setPartBank(String partBank) {
		this.partBank = partBank;
	}
    /*****数据库并无该字段-只作为参数传递   
     * <p> 对应UsrBindCard.id****/
	public int getUsrBindCardId() {
		return usrBindCardId;
	}
    /*****数据库并无该字段-只作为参数传递   
     * <p> 对应UsrBindCard.id****/
	public void setUsrBindCardId(int usrBindCardId) {
		this.usrBindCardId = usrBindCardId;
	}
	
	public String getTradeRelatedNo() {
		return tradeRelatedNo;
	}

	public void setTradeRelatedNo(String tradeRelatedNo) {
		this.tradeRelatedNo = tradeRelatedNo;
	}

	@Override
	public String toString() {
		return "UsrWithDraw [userType=" + userType + ", userId=" + userId + ", account=" + account + ", bindCardId="
				+ bindCardId + ", usrBindCard=" + usrBindCard + ", businessTradeNo=" + businessTradeNo
				+ ", uniqueIdToOuter=" + uniqueIdToOuter + ", amount=" + amount + ", userFee=" + userFee
				+ ", withdrawStatus=" + withdrawStatus + ", requestTime=" + requestTime + ", withdrawTime="
				+ withdrawTime + ", withdrawDesc=" + withdrawDesc + ", sellClient=" + sellClient + ", auditStatus="
				+ auditStatus + ", auditUser=" + auditUser + ", auditInfo=" + auditInfo + ", auditTime=" + auditTime
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", transferStatus=" + transferStatus
				+ ", sellChannel=" + sellChannel + ", paymentWay=" + paymentWay + ", bankCode=" + bankCode
				+ ", bankName=" + bankName + ", bankNo=" + bankNo + ", provinces=" + provinces + ", city=" + city
				+ ", partBank=" + partBank + ", usrBindCardId=" + usrBindCardId + ", isTransfer=" + isTransfer
				+ ", tradeRelatedNo=" + tradeRelatedNo + "]";
	}

}
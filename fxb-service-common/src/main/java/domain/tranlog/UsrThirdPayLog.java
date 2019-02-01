package domain.tranlog;

import domain.entity.BaseEntity;
import domain.type.UsrPayMerchant;
import domain.type.UsrThirdPayStatus;

import java.util.Date;

/**
 * 第三方支付 
 *
 */
public class UsrThirdPayLog extends BaseEntity {

	private static final long serialVersionUID = -8562198126853989764L;

	/**第三方支付  ThirdPayType*/
    private Integer thirdType;

    /**用户ID*/
    private Long userId;

    /**帐号*/
    private String account;

    /**支付单号*/
    private String payNo;

    /**金额*/
    private Integer amount;

    /**支付状态*/
    private Integer payStatus = UsrThirdPayStatus.created.getIndex();

    /**支付商订单号*/
    private String outPayNo;

    /**第三方帐号*/
    private String thirdAccount;

    /**响应信息*/
    private String payResponeInfo;

    /**支付成功响应时间*/
    private Date responeTime;

    /**创建时间*/
    private Date createTime = new Date();

    /**备注*/
    private String remarks;

    /**次要属性json格式*/
    private Long flagBit = 0L;

    /**次要属性json格式*/
    private String features = "{}";

    /**市场渠道*/
    private long sellChannel;

    /**客户端*/
    private Integer sellClient;

    /**对账标识码*/
    private String checkCode;

    /**关联业务ID*/
    private Long relateId;

    /**关联业务号*/
    private String relateNo;
    
    /**业务类型 UsrThirdPayLogBizType*/
    private Integer bizType;
    
    /**购彩订单ID*/
    private Long orderId;
    
    /**购彩订单号*/
    private String orderNo;
    
  //用于查询条件
    /** 开始时间 */
	private Date beginTime;
	
	/** 结束时间 */
	private Date endTime;
	
	/** 支付商户表ID */
	private Long merchantId;
	
	private UsrPayMerchant usrPayMerchant;//支付商户表实体
	
    public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getThirdType() {
        return thirdType;
    }

    public void setThirdType(Integer thirdType) {
        this.thirdType = thirdType;
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

  

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

     

    public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getOutPayNo() {
        return outPayNo;
    }

    public void setOutPayNo(String outPayNo) {
        this.outPayNo = outPayNo;
    }

    public String getThirdAccount() {
        return thirdAccount;
    }

    public void setThirdAccount(String thrdAccount) {
        this.thirdAccount = thrdAccount;
    }
 
    public String getPayResponeInfo() {
		return payResponeInfo;
	}

	public void setPayResponeInfo(String payResponeInfo) {
		this.payResponeInfo = payResponeInfo;
	}

	public Date getResponeTime() {
        return responeTime;
    }

    public void setResponeTime(Date responeTime) {
        this.responeTime = responeTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getFlagBit() {
        return flagBit;
    }

    public void setFlagBit(Long flagBit) {
        this.flagBit = flagBit;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public long getSellChannel() {
		return sellChannel;
	}

	public void setSellChannel(long sellChannel) {
		this.sellChannel = sellChannel;
	}
	

	public Integer getSellClient() {
        return sellClient;
    }

    public void setSellClient(Integer sellClient) {
        this.sellClient = sellClient;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRelateId() {
		return relateId;
	}

	public void setRelateId(Long relateId) {
		this.relateId = relateId;
	}

	public String getRelateNo() {
		return relateNo;
	}

	public void setRelateNo(String relateNo) {
		this.relateNo = relateNo;
	}


	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getBizType() {
		return bizType;
	}

	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public UsrPayMerchant getUsrPayMerchant() {
		return usrPayMerchant;
	}

	public void setUsrPayMerchant(UsrPayMerchant usrPayMerchant) {
		this.usrPayMerchant = usrPayMerchant;
	}

}
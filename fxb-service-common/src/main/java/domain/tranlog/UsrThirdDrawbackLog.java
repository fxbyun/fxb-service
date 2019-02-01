package domain.tranlog;

import domain.entity.BaseEntity;
import domain.type.CheckCodePrefix;
import domain.type.ThirdPayType;
import domain.type.UsrThirdPayStatus;

import java.util.Date;

/**
 * 第三方支付退款
 *
 */
public class UsrThirdDrawbackLog extends BaseEntity {

	private static final long serialVersionUID = -8562198126853989764L;

	/**第三方支付  ThirdPayType*/
    private Integer thirdType;

    /**用户ID*/
    private Long userId;

    /**帐号*/
    private String account;

    /**支付编号--退款号*/
    private String drawbackNo;

    /**原支付单号*/
    private String payNo;

    /**金额*/
    private Integer amount;

    /**退款状态 0 创建支付 1 支付中 2 支付成功 3 支付失败 4 支付故障 5 转入代发 */
    private Integer drawbackStatus = UsrThirdPayStatus.created.getIndex();

    /**支付商订单号*/
    private String outPayNo;

    /**第三方帐号*/
    private String thirdAccount;

    /**响应信息*/
    private String drawbackResponeInfo;

    /**支付成功响应时间*/
    private Date responeTime;

    /**创建时间*/
    private Date createTime;

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
    
    /**业务类型 {@link UsrThirdPayLogBizType}*/
    private Integer bizType;
    
    /**购彩订单ID*/
    private Long orderId;
    
    /**购彩订单号*/
    private String orderNo;
    
	/** 支付商户表ID */
	private Long merchantId;

    //用于查询条件
    /** 开始时间 */
	private Date beginTime;
	
	/***
	 * 原支付订单金额，数据库没有该字段，用于属性传递
	 */
	private Integer oldPayTotalAmount;
	
	public Integer getOldPayTotalAmount() {
		return oldPayTotalAmount;
	}

	public void setOldPayTotalAmount(Integer oldPayTotalAmount) {
		this.oldPayTotalAmount = oldPayTotalAmount;
	}

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

	/** 结束时间 */
	private Date endTime;
    
    public UsrThirdDrawbackLog(Integer thirdType, Long userId, String account, String drawbackNo, String payNo,
                               Integer amount, Integer drawbackStatus, String outPayNo, String thirdAccount, String drawbackResponeInfo,
                               Date responeTime, Date createTime, String remarks, Long flagBit, String features, long sellChannel,
                               Integer sellClient, String checkCode, Long relateId, String relateNo, Integer bizType, Long orderId,
                               String orderNo) {
		super();
		this.thirdType = thirdType;
		this.userId = userId;
		this.account = account;
		this.drawbackNo = drawbackNo;
		this.payNo = payNo;
		this.amount = amount;
		this.drawbackStatus = drawbackStatus;
		this.outPayNo = outPayNo;
		this.thirdAccount = thirdAccount;
		this.drawbackResponeInfo = drawbackResponeInfo;
		this.responeTime = responeTime;
		this.createTime = createTime;
		this.remarks = remarks;
		this.flagBit = flagBit;
		this.features = features;
		this.sellChannel = sellChannel;
		this.sellClient = sellClient;
		this.checkCode = checkCode;
		this.relateId = relateId;
		this.relateNo = relateNo;
		this.bizType = bizType;
		this.orderId = orderId;
		this.orderNo = orderNo;
	}

	public UsrThirdDrawbackLog() {
		super();
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

    public String getDrawbackNo() {
        return drawbackNo;
    }

    public void setDrawbackNo(String drawbackNo) {
        this.drawbackNo = drawbackNo;
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

    public Integer getDrawbackStatus() {
        return drawbackStatus;
    }

    public void setDrawbackStatus(Integer drawbackStatus) {
        this.drawbackStatus = drawbackStatus;
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

    public String getDrawbackResponeInfo() {
        return drawbackResponeInfo;
    }

    public void setDrawbackResponeInfo(String drawbackResponeInfo) {
        this.drawbackResponeInfo = drawbackResponeInfo;
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

    public Long getSellChannel() {
		return sellChannel;
	}

	public void setSellChannel(Long sellChannel) {
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

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
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

	public void setSellChannel(long sellChannel) {
		this.sellChannel = sellChannel;
	}
	
    public String getConvertCheckCodeParamName(){
    	if(ThirdPayType.weixin_wft.getIndex() == thirdType 
    			|| ThirdPayType.alipay_st.getIndex() == thirdType
    			|| ThirdPayType.alipay_xy.getIndex() == thirdType
    			|| ThirdPayType.wft_weixin_h5.getIndex() == thirdType 
    			){
    		return CheckCodePrefix.wftRefundCheckCodeParamName;
    	}else if(ThirdPayType.weixin.getIndex() == thirdType){
    		return CheckCodePrefix.zwxCheckCodeParamName;
    	}
    	return CheckCodePrefix.wftCheckCodeParamName;
    }
}
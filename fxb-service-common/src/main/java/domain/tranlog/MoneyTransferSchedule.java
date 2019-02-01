package domain.tranlog;

import com.alibaba.fastjson.JSONObject;
import domain.ExtensionFeatures;
import domain.ExtensionFlagBit;
import domain.type.*;

import java.io.Serializable;
import java.util.Calendar;

/**
 * 转账计划
 * 
 * @author cxp
 *
 */
public class MoneyTransferSchedule implements Serializable , ExtensionFeatures, ExtensionFlagBit {
	private static final long serialVersionUID = -7384577369506668025L;
	private long id;
	/**
	 * 本身的业务订单类型
	 */
	private int bizType = BizTypeConstant.c2b_zf;
	/**
	 * 关联业务单记录id（订单ID对应方案ID，如果只有自己没有相关业务单，可以填自己）
	 */
	private long bizId;
	/**
	 * 关联业务单记录no （订单NO对应方案NO，如果只有自己没有相关业务单，可以填自己）
	 */
	private String bizNo;
	/**
	 * 业务单类型
	 */
    private int  sourceBizorderType = SourceBizorderTypeConstant.tzOrder;
    /**
     * 业务单id（如订单，充值单，提款单）
     * 这个ID主ID，以这个为主，对应有多个MoneyTransferSchedule（如订单有支付，派奖，支付回退．．．）
     */
    private long sourceBizorderId;
    /**
     * 业务单MemberId
     */
    private Long sourceBizorderMemberId;
    
    /**
     * 向外划转的模式
     * 1：先扣会员内部余额再扣外部余额
     * 2：先加会员外部余额再加内部余额
     * 3：与会员账户无关
     * */
    private int internalOuterMode = InternalOuterModeConstant.innerWalletFirst;
    
    /**
     * 内部划转状态
     * 0：刚创建/未进行
     * 1：进行中
     * 2：完成
     * 3：未明故障需人员介入
     * */
    private int internalTransferStatus = InternalTransferStatusConstant.notDo;
    
    /**
     * 外部划转状态
     * 0：刚创建/未进行
     * 1：进行中
     * 2：完成
     * 3：未明故障需人员介入
     * */
    private int outerTransferStatus = OuterTransferStatusConstant.notDo;
    
    /**
     * 划转日志状态
     * 0：刚创建,未分解transfer_log
     * 1：分解transfer_log 中
     * 2：分解transfer_log完成
     * 3：刚创建但不用预先分解transfer_log
     * */
    private int status = TransferScheduleStatusConstant.waiting;
    
    /**
     * 备注
     */
    private String remark;
	
	private long flagBit ;
	private String features = "{}";
	private int flagVersion;
	private int featuresVersion;
	private Calendar createTime;
	private Calendar updateTime;
	
	
	
	public MoneyTransferSchedule(int bizType, int sourceBizorderType,
                                 long sourceBizorderId, int internalOuterMode,
                                 int internalTransferStatus, int outerTransferStatus, int status, Long sourceBizorderMemberId) {
		super();
		this.bizType = bizType;
		this.sourceBizorderType = sourceBizorderType;
		this.sourceBizorderId = sourceBizorderId;
		this.internalOuterMode = internalOuterMode;
		this.internalTransferStatus = internalTransferStatus;
		this.outerTransferStatus = outerTransferStatus;
		this.status = status;
		this.sourceBizorderMemberId = sourceBizorderMemberId;
	}
	
	
	public MoneyTransferSchedule(int bizType, int sourceBizorderType,
                                 long sourceBizorderId, int internalOuterMode, Long sourceBizorderMemberId) {
		super();
		this.bizType = bizType;
		this.sourceBizorderType = sourceBizorderType;
		this.sourceBizorderId = sourceBizorderId;
		this.internalOuterMode = internalOuterMode;
		this.sourceBizorderMemberId = sourceBizorderMemberId;
	}



	public MoneyTransferSchedule() {
		super();
	}

	public int getInternalOuterMode() {
        return internalOuterMode;
    }

    public void setInternalOuterMode(int internalOuterMode) {
        this.internalOuterMode = internalOuterMode;
    }

    public int getInternalTransferStatus() {
        return internalTransferStatus;
    }

    public void setInternalTransferStatus(int internalTransferStatus) {
        this.internalTransferStatus = internalTransferStatus;
    }

    public int getOuterTransferStatus() {
        return outerTransferStatus;
    }

    public void setOuterTransferStatus(int outerTransferStatus) {
        this.outerTransferStatus = outerTransferStatus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public int getBizType() {
        return bizType;
    }

    public void setBizType(int bizType) {
        this.bizType = bizType;
    }
    
    public long getBizId() {
		return bizId;
	}


	public void setBizId(long bizId) {
		this.bizId = bizId;
	}


	public String getBizNo() {
		return bizNo;
	}


	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}


	public int getSourceBizorderType() {
        return sourceBizorderType;
    }

    public void setSourceBizorderType(int sourceBizorderType) {
        this.sourceBizorderType = sourceBizorderType;
    }

    public long getSourceBizorderId() {
        return sourceBizorderId;
    }

    public void setSourceBizorderId(long sourceBizorderId) {
        this.sourceBizorderId = sourceBizorderId;
    }

    
	public Long getSourceBizorderMemberId() {
		return sourceBizorderMemberId;
	}


	public void setSourceBizorderMemberId(Long sourceBizorderMemberId) {
		this.sourceBizorderMemberId = sourceBizorderMemberId;
	}


	public long getId() {
		return id;
	}
	
	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

	public Calendar getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Calendar updateTime) {
		this.updateTime = updateTime;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setFlagBit(long flagBit) {
		this.flagBit = flagBit;
	}

	public void setFlagVersion(int flagVersion) {
		this.flagVersion = flagVersion;
	}

	public void setFeaturesVersion(int featuresVersion) {
		this.featuresVersion = featuresVersion;
	}

	public String getFeatures() {
		return features;
	}
	
	public long getFlagBit() {
		return flagBit;
	}

	public int getFlagVersion() {
		return flagVersion;
	}

	public int getFeaturesVersion() {
		return featuresVersion;
	}

	
	@Override
	public void setupFeature(String columnName, String value) {
		JSONObject jsonO=JSONObject.parseObject(features);
		jsonO.put(columnName, value);
		features=jsonO.toJSONString();
	}
	@Override
	public void setupFeature(String columnName, Object value) {
		JSONObject jsonO=JSONObject.parseObject(features);
		jsonO.put(columnName, value);
		features=jsonO.toJSONString();
	}
	@Override
	public void removeFeature(String columnName) {
		JSONObject jsonO=JSONObject.parseObject(features);
		jsonO.remove(columnName);
		features=jsonO.toJSONString();
	}
	@Override
	public String getFeature(String columnName) {
		JSONObject jsonO=JSONObject.parseObject(features);
		return jsonO.getString(columnName);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getFeature(String columnName, Class<T> clz) {
		JSONObject jsonO=JSONObject.parseObject(features);
		return (T)jsonO.get(columnName);
	}
	public void addFlagBit(Long flagBit) {
		this.flagBit |= flagBit.longValue();
	}
	public void setFlagBit(Long flagBit) {
		this.flagBit = flagBit==null?0:flagBit;
	}
	public void setFeatures(String features) {
		this.features = features==null?"{}":features;
	}
	public void setFlagVersion(Integer flagVersion) {
		this.flagVersion = flagVersion==null?0:flagVersion;
	}
	public void setFeaturesVersion(Integer featuresVersion) {
		this.featuresVersion = featuresVersion==null?0:featuresVersion;
    }
}

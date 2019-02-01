package domain.tranlog;

import com.alibaba.fastjson.JSONObject;
import domain.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class TzTransferAward extends BaseEntity {
	private static final long serialVersionUID = 1243062544065245474L;
	
	private Long fromUserId;		// 来源用户ID(站点)
	private Long toUserId;			// 到账用户ID
	/***
	 * {@link TransferAwardOrderType}
	 */
	private Integer outOrderType;	// 业务订单类型，1、中奖订单
	private Long outOrderId;		// 业务订单ID
	private String planNo;			// 方案编号
	private BigDecimal amount;		// 派奖金额，单位为元
	private Integer status;			// 处理状态，1刚创建 2代收中 3已代收 4支付中 5已支付 6代付中 7已代付
	private Date createTime;		// 创建时间
	private Date updateTime;		// 修改时间
	
	private Long flagBit = 0L; 			// 标志位
	private Integer flagVersion = 0;	// flag_bit版本号
	private String features = "{}"; 	// Json属性
	private Integer featuresVersion = 0;// features版本号
	
	private Integer amountInt;	// 数据库字段，单位为分，与amount字段对应
	
	public Long getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}
	public Long getToUserId() {
		return toUserId;
	}
	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}
	public Integer getOutOrderType() {
		return outOrderType;
	}
	public void setOutOrderType(Integer outOrderType) {
		this.outOrderType = outOrderType;
	}
	public Long getOutOrderId() {
		return outOrderId;
	}
	public void setOutOrderId(Long outOrderId) {
		this.outOrderId = outOrderId;
	}
	public String getPlanNo() {
		return planNo;
	}
	public void setPlanNo(String planNo) {
		this.planNo = planNo;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
		if (this.amount != null) {
			this.amountInt = this.amount.multiply(BigDecimal.valueOf(100)).intValue();
		}
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Long getFlagBit() {
		return flagBit;
	}
	public Integer getFlagVersion() {
		return flagVersion;
	}
	public String getFeatures() {
		return features;
	}
	public Integer getFeaturesVersion() {
		return featuresVersion;
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
	public void setupFeature(String columnName, String value) {
		JSONObject jsonO=JSONObject.parseObject(features);
		jsonO.put(columnName, value);
		features=jsonO.toJSONString();
	}
	public void setupFeature(String columnName, Object value) {
		JSONObject jsonO=JSONObject.parseObject(features);
		jsonO.put(columnName, value);
		features=jsonO.toJSONString();
	}
	public void removeFeature(String columnName) {
		JSONObject jsonO=JSONObject.parseObject(features);
		jsonO.remove(columnName);
		features=jsonO.toJSONString();
	}
	public String getFeature(String columnName) {
		JSONObject jsonO=JSONObject.parseObject(features);
		return jsonO.getString(columnName);
	}
	@SuppressWarnings("unchecked")
	public <T> T getFeature(String columnName, Class<T> clz) {
		JSONObject jsonO=JSONObject.parseObject(features);
		return (T)jsonO.get(columnName);
	}
	public void addFlagBit(Long flagBit) {
		if (this.flagBit == null) {
			this.flagBit = 0L;
		}
		this.flagBit |= flagBit.longValue();
	}
	public void removeFlagBit(long flagBit) {
		this.flagBit &= flagBit ^ Long.MAX_VALUE;
	}
	public Integer getAmountInt() {
		return amountInt;
	}
	public void setAmountInt(Integer amountInt) {
		this.amountInt = amountInt;
		if (this.amountInt != null) {
			this.amount = BigDecimal.valueOf(this.amountInt).divide(BigDecimal.valueOf(100));
		}
	}
}

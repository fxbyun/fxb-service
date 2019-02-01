package domain.type;

import domain.entity.BaseEntity;

import java.util.Date;


/**
 * 支付商户表
 * @author zl
 *
 */
public class UsrPayMerchant extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /***
     * 商户号
     */
	private String mchNo;

    /**支付类型 SysLimitedConfigPayType*/
    private Integer payType;

    /**支付方式 SysLimitedConfigWxPayWay*/
    private Integer payWay;
    /***
     * 商户秘钥
     */
	private String secretKey;
    /***销售渠道：0代表所有**/
	private Long sellChannel;
	
	/**权重,(长度最大4位数)*/
	private Integer weight;
    
    /** 创建时间 */
    private Date createTime = new Date();
    /** 修改时间 */
    private Date updateTime;
    
    /**商户状态：1：启用 2：停用  UsrPayMerchantStatus */
    private Integer mchStatus;
    
    /***
     * 商户公司名称
     */
	private String mchCompany;
    /***
     * 后台操作人
     */
	private String operUser;
    /***
     * 备注
     */
	private String remark;
	
    private Long flagBit=0L;			// 次要状态合并字段
	private String features="{}";		// 次要属性json格式
	public String getMchNo() {
		return mchNo;
	}
	public void setMchNo(String mchNo) {
		this.mchNo = mchNo;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public Integer getPayWay() {
		return payWay;
	}
	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
	public Long getSellChannel() {
		return sellChannel;
	}
	public void setSellChannel(Long sellChannel) {
		this.sellChannel = sellChannel;
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
	public Integer getMchStatus() {
		return mchStatus;
	}
	public void setMchStatus(Integer mchStatus) {
		this.mchStatus = mchStatus;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getMchCompany() {
		return mchCompany;
	}
	public void setMchCompany(String mchCompany) {
		this.mchCompany = mchCompany;
	}
	public String getOperUser() {
		return operUser;
	}
	public void setOperUser(String operUser) {
		this.operUser = operUser;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
}

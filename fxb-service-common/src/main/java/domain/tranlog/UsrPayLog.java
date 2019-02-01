package domain.tranlog;

import com.alibaba.fastjson.JSONObject;
import domain.entity.BaseEntity;
import domain.entity.UsrWalletLog;
import domain.type.ThirdPayType;
import domain.type.UsrPayLogProccesStatusConstant;
import domain.util.MathUtil;

import java.util.Date;


/**
 * 用户支付流水表
 * @author zl
 *
 */
public class UsrPayLog extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /***
     * 支付流水编号
     */
	private String payLogNo;
    /**支付类型  UsrPayLogPayType*/
    private Integer payType;
    /**支付来源 UsrPayLogPayFrom*/
    private Integer payFrom;
    /**支付处理状态 UsrPayLogProccesStatusConstant*/
    private Integer proccesStatus = UsrPayLogProccesStatusConstant.init;
    
    /** 用户ID */
    private Long userId;
    /** 用户账户 */
    private String account;
    /**业务订单类型 UsrPayLogOrderType*/
    private Integer outOrderType;
    /**业务订单ID*/
    private Long outOrderId;
    /**业务订单No*/
    private String outOrderNo;
    
    /**方案id（如果是追号代购显示-追号的方案ID）*/
    private Long planId;
    /**方案编号(如果是追号代购显示-追号的方案号)*/
    private String planNo;
    
    /** 时间 */
    private Date createTime = new Date();
    
    /** 客户端类型  */
    private Integer sellClient;
	/** 市场渠道  */
	private long sellChannel;
	
    /**彩种*/
    private Integer gameId;
    /**彩期号*/
    private String issueNo;
    /*** 冗余方案创建时间 **/
    private Date  planCreateTime;
    /*** 冗余-第三方支付类型  ThirdPayType**/
    private Integer thirdType = ThirdPayType.unknown.getIndex();
 
    /** 实际交易金额(当条支付来源的总金额)  （单位：分）  **/
    private Integer amount=0;
    /** 必消金 （单位：分） **/
    private Integer deposit=0;
    /** (用户钱包发生金额)彩金 （单位：分） **/
    private Integer giftAmount=0;
    /** (用户钱包发生金额)现金 （单位：分） **/
    private Integer cashAmount=0;
    /** (用户钱包发生金额)奖金 （单位：分） **/
    private Integer prizeAmount=0;
    /** (用户钱包发生金额)收益 （单位：分） **/
    private Integer incomeAmount=0;
    
    /** 抵扣卷面值 **/
    private Integer faceValue=0;
    /**备注*/
    private String remarks;
     
 
    private Long flagBit=0L;			// 次要状态合并字段
	private String features="{}";		// 次要属性json格式
 
	//用于查询条件
    /** 开始时间 */
	private Date beginTime;
	
	/** 结束时间 */
	private Date endTime;
	
	public UsrPayLog(){}
	 
	
	public UsrPayLog(String payLogNo, Integer payType, Integer payFrom, Integer proccesStatus, Long userId, String account,
                     Integer outOrderType, Long outOrderId, String outOrderNo, Long planId, String planNo, Date createTime,
                     Integer sellClient, long sellChannel, Integer gameId, String issueNo, Date planCreateTime, Integer thirdType,
                     Integer amount, Integer deposit, Integer giftAmount, Integer cashAmount, Integer prizeAmount,
                     Integer incomeAmount, Integer faceValue, String remarks, Long flagBit, String features) {
		super();
		this.payLogNo = payLogNo;
		this.payType = payType;
		this.payFrom = payFrom;
		this.proccesStatus = proccesStatus;
		this.userId = userId;
		this.account = account;
		this.outOrderType = outOrderType;
		this.outOrderId = outOrderId;
		this.outOrderNo = outOrderNo;
		this.planId = planId;
		this.planNo = planNo;
		this.createTime = createTime;
		this.sellClient = sellClient;
		this.sellChannel = sellChannel;
		this.gameId = gameId;
		this.issueNo = issueNo;
		this.planCreateTime = planCreateTime;
		this.thirdType = thirdType;
		this.amount = amount;
		this.deposit = deposit;
		this.giftAmount = giftAmount;
		this.cashAmount = cashAmount;
		this.prizeAmount = prizeAmount;
		this.incomeAmount = incomeAmount;
		this.faceValue = faceValue;
		this.remarks = remarks;
		this.flagBit = flagBit;
		this.features = features;
	}
	/***
	 * 冻结 -》 解冻  复制共用的基本属性
	 * @param usrPayLog
	 */
	public void setUsrPayLogBase(UsrPayLog usrPayLog) {
		this.payFrom = usrPayLog.getPayFrom();
		this.userId = usrPayLog.getUserId();
		this.account = usrPayLog.getAccount();
		this.outOrderType = usrPayLog.getOutOrderType();
		this.outOrderId = usrPayLog.getOutOrderId();
		this.outOrderNo = usrPayLog.getOutOrderNo();
		this.planId = usrPayLog.getPlanId();
		this.planNo = usrPayLog.getPlanNo();
		
		this.sellClient = usrPayLog.getSellClient();
		this.sellChannel = usrPayLog.getSellChannel();
		this.gameId = usrPayLog.getGameId();
		this.issueNo = usrPayLog.getIssueNo();
		this.planCreateTime = usrPayLog.getPlanCreateTime();
		this.thirdType = usrPayLog.getThirdType();
		this.amount = usrPayLog.getAmount();
		this.faceValue = usrPayLog.getFaceValue();
	}
	public void setUsrPayLogByUsrWalletLog(UsrWalletLog usrWalletLog) {
		this.setDeposit(MathUtil.magnified100(usrWalletLog.getDeposit()) );
		this.setCashAmount(MathUtil.magnified100(usrWalletLog.getCashAmount()) );
		this.setGiftAmount(MathUtil.magnified100(usrWalletLog.getGiftAmount()) );
		this.setPrizeAmount(MathUtil.magnified100(usrWalletLog.getPrizeAmount()) );
		this.setIncomeAmount(MathUtil.magnified100(usrWalletLog.getIncomeAmount()) );
		this.setAmount(MathUtil.magnified100(usrWalletLog.getAmount()));
	}

	public String getPayLogNo() {
		return payLogNo;
	}
	public void setPayLogNo(String payLogNo) {
		this.payLogNo = payLogNo;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public Integer getPayFrom() {
		return payFrom;
	}
	public void setPayFrom(Integer payFrom) {
		this.payFrom = payFrom;
	}
	public Integer getProccesStatus() {
		return proccesStatus;
	}
	public void setProccesStatus(Integer proccesStatus) {
		this.proccesStatus = proccesStatus;
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
	public String getOutOrderNo() {
		return outOrderNo;
	}
	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	public String getPlanNo() {
		return planNo;
	}
	public void setPlanNo(String planNo) {
		this.planNo = planNo;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getSellClient() {
		return sellClient;
	}
	public void setSellClient(Integer sellClient) {
		this.sellClient = sellClient;
	}
	public long getSellChannel() {
		return sellChannel;
	}
	public void setSellChannel(long sellChannel) {
		this.sellChannel = sellChannel;
	}
	public Integer getGameId() {
		return gameId;
	}
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}
	public String getIssueNo() {
		return issueNo;
	}
	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}
	public Date getPlanCreateTime() {
		return planCreateTime;
	}
	public void setPlanCreateTime(Date planCreateTime) {
		this.planCreateTime = planCreateTime;
	}
	public Integer getThirdType() {
		return thirdType;
	}
	public void setThirdType(Integer thirdType) {
		this.thirdType = thirdType;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getDeposit() {
		return deposit;
	}
	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}
	public Integer getGiftAmount() {
		return giftAmount;
	}
	public void setGiftAmount(Integer giftAmount) {
		this.giftAmount = giftAmount;
	}
	public Integer getCashAmount() {
		return cashAmount;
	}
	public void setCashAmount(Integer cashAmount) {
		this.cashAmount = cashAmount;
	}
	public Integer getPrizeAmount() {
		return prizeAmount;
	}
	public void setPrizeAmount(Integer prizeAmount) {
		this.prizeAmount = prizeAmount;
	}
	public Integer getIncomeAmount() {
		return incomeAmount;
	}
	public void setIncomeAmount(Integer incomeAmount) {
		this.incomeAmount = incomeAmount;
	}
	public Integer getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(Integer faceValue) {
		this.faceValue = faceValue;
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
	public String getFeatures() {
		return features;
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
	public void setFlagBit(Long flagBit) {
		this.flagBit = flagBit==null?0:flagBit;
	}
	public void setFeatures(String features) {
		this.features = features==null?"{}":features;
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
	/***
	 * @param usrPayLogConstantKey  例如：UsrPayLogConstant.freezePrizeAmount
	 * @param amount
	 */
	public void setEvaluateAmount(String usrPayLogConstantKey,Integer amount){
		setupFeature(usrPayLogConstantKey,amount);
	}
	/***
	 * 
	 * @param usrPayLogConstantKey  例如：UsrPayLogConstant.freezePrizeAmount
	 * @return
	 */
	public Integer getEvaluateAmount(String usrPayLogConstantKey){
		String t = getFeature(usrPayLogConstantKey);
		if(t!=null && t.length()>0){
			return Integer.valueOf(t);
		}
		return null;
	}
 
}

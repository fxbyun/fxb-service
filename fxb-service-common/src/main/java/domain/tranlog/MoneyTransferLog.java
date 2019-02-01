package domain.tranlog;

import com.alibaba.fastjson.JSONObject;
import domain.ExtensionFeatures;
import domain.ExtensionFlagBit;
import domain.type.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * 转账流水表
 * @author cxp
 */
public class MoneyTransferLog implements Serializable , ExtensionFeatures, ExtensionFlagBit {
    private static final long serialVersionUID = 9221741623548590733L;

    /***features的Key命名*/
    public static String userIpKey="userIp";
    public static String userIdKey="userId";
    public static String userTypeKey="userType";


    private long id;

    /**划转计划ID*/
    private long transferScheduleId;

    /**资金业务来源类型　　*/
    private int amountSourceType = AmountSourceTypeConstant.usrWalletLogConsumer;

    /**资金业务来源ID　　如购彩ORERID，B2b返奖批次ID,b2c订单ID*/
    private long amountSourceId;
    /**
     * 划转响应
     */
    private String transferResponseMsg;

    /***划转帐户类型
     * 1:内部账户转账操作
     * 2:外部账户转账操作
     * */
    private int accountInternalOrOuter = AccountInternalOrOuterConstant.internal_account;

    /**来源帐户类型*/
    private int fromAccountType = AccountTypeConstant.member;

    /**来源账户ID*/
    private String fromAccountId;

    /**接收帐户类型*/
    private int toAccountType = AccountTypeConstant.member;

    /**接收帐户ID*/
    private String toAccountId;

    /***划转金额*/
    private BigDecimal amount;

    /**划转状态*/
    private int transferStatus = TransferStatus.waiting;
    private Calendar transferStatusTime;

    /**和对方关联号*/
    private long uniqueIdToOuter;
    /**
     * 对方给的关联号
     */
    private String uniqueIdFromOuter;
    private Integer relateType;
    private Long relateId;

    private String remark;

    private long flagBit = MoneyTransferLogFlagBitConstant.defualt;
    private String features = "{}";
    private int flagVersion;
    private int featuresVersion;
    private Calendar createTime;
    private Calendar updateTime;
    /**新增四个字段****/
    private Integer parentGameId; // 父彩种
    private Integer gameId; // 彩种
    private String issueNo; // ; //彩期
    private Long maxRaceId;//最大场次ID

    private String checkCode;	// 财务对账编码

    private Date checkTime;

    //新增数据库字段 关联号
    private String tradeRelatedNo;

    public String getTradeRelatedNo() {
        return tradeRelatedNo;
    }

    public void setTradeRelatedNo(String tradeRelatedNo) {
        this.tradeRelatedNo = tradeRelatedNo;
    }

    public Integer getParentGameId() {
        return parentGameId;
    }

    public void setParentGameId(Integer parentGameId) {
        this.parentGameId = parentGameId;
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

    public Long getMaxRaceId() {
        return maxRaceId;
    }

    public void setMaxRaceId(Long maxRaceId) {
        this.maxRaceId = maxRaceId;
    }

    public MoneyTransferLog(){
    }

    public MoneyTransferLog(long transferScheduleId, int amountSourceType,
                            long amountSourceId, int accountInternalOrOuter,
                            int fromAccountType, String fromAccountId, int toAccountType,
                            String toAccountId, BigDecimal amount) {
        super();
        this.transferScheduleId = transferScheduleId;
        this.amountSourceType = amountSourceType;
        this.amountSourceId = amountSourceId;
        this.accountInternalOrOuter = accountInternalOrOuter;
        this.fromAccountType = fromAccountType;
        this.fromAccountId = fromAccountId;
        this.toAccountType = toAccountType;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    public long getTransferScheduleId() {
        return transferScheduleId;
    }

    public void setTransferScheduleId(long transferScheduleId) {
        this.transferScheduleId = transferScheduleId;
    }

    public int getAmountSourceType() {
        return amountSourceType;
    }

    public void setAmountSourceType(int amountSourceType) {
        this.amountSourceType = amountSourceType;
    }

    public long getAmountSourceId() {
        return amountSourceId;
    }

    public void setAmountSourceId(long amountSourceId) {
        this.amountSourceId = amountSourceId;
    }

    public int getAccountInternalOrOuter() {
        return accountInternalOrOuter;
    }

    public void setAccountInternalOrOuter(int accountInternalOrOuter) {
        this.accountInternalOrOuter = accountInternalOrOuter;
    }

    public int getFromAccountType() {
        return fromAccountType;
    }

    public void setFromAccountType(int fromAccountType) {
        this.fromAccountType = fromAccountType;
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public int getToAccountType() {
        return toAccountType;
    }

    public void setToAccountType(int toAccountType) {
        this.toAccountType = toAccountType;
    }

    public String getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(String toAccountId) {
        this.toAccountId = toAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(int transferStatus) {
        this.transferStatus = transferStatus;
    }

    public Calendar getTransferStatusTime() {
        return transferStatusTime;
    }

    public void setTransferStatusTime(Calendar transferStatusTime) {
        this.transferStatusTime = transferStatusTime;
    }

    public long getUniqueIdToOuter() {
        return uniqueIdToOuter;
    }

    public void setUniqueIdToOuter(long uniqueIdToOuter) {
        this.uniqueIdToOuter = uniqueIdToOuter;
    }

    public String getUniqueIdFromOuter() {
        return uniqueIdFromOuter;
    }

    public void setUniqueIdFromOuter(String uniqueIdFromOuter) {
        this.uniqueIdFromOuter = uniqueIdFromOuter;
    }

    public Integer getRelateType() {
        return relateType;
    }

    public void setRelateType(Integer relateType) {
        this.relateType = relateType;
    }

    public Long getRelateId() {
        return relateId;
    }

    public void setRelateId(Long relateId) {
        this.relateId = relateId;
    }

    public long getId() {
        return id;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTransferResponseMsg() {
        return transferResponseMsg;
    }

    public void setTransferResponseMsg(String transferResponseMsg) {
        this.transferResponseMsg = transferResponseMsg;
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

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
    public void setCheckCodeByPre(String checkCodePre) {
        this.checkCode = CheckCodePrefix.buildCheckCode(checkCodePre);
    }


    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
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
    /***
     * 重新支付的交易号：每次重新支付号 追加在后面
     * 格式：100001|10002|10003
     */
    public void setAgainPayUniqueIdFeatures(long newUniqueIdToOuter){
        String againPayUniqueIdKey = "againPayUniqueId";
        String oldUniqueId = this.getFeature(againPayUniqueIdKey);
        if(oldUniqueId!=null && oldUniqueId.length()>300){
            oldUniqueId = oldUniqueId.substring(30, oldUniqueId.length());
        }
        this.setupFeature(againPayUniqueIdKey, oldUniqueId + "|" + newUniqueIdToOuter);
    }

    /***
     * 用户IDFeatures
     */
    public void setUserIdFeatures(long userId){
        this.setupFeature(userIdKey, userId);
    }
    /***
     * 用户类型Features
     */
    public void setUserTypeFeatures(int  userType){
        this.setupFeature(userTypeKey, userType);
    }
    /***
     * 用户IDFeatures
     */
    public Long getUserIdFeatures(){
        String giftId = this.getFeature(userIdKey);
        if(giftId==null){
            return null;
        }
        return Long.parseLong(giftId);
    }
    /***
     * 用户类型Features
     */
    public Integer getUserTypeFeatures(){
        String userType = this.getFeature(userTypeKey);
        if(userType==null){
            return null;
        }
        return Integer.parseInt(userType);
    }

    /***
     * userIp Features
     */
    public void setUserIpFeatures(String userIp){
        this.setupFeature(userIpKey, userIp);
    }
    /***
     * userIp Features
     */
    public String getUserIpFeatures(){
        return this.getFeature(userIpKey);
    }
}

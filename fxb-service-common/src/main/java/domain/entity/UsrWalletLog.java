package domain.entity;

import com.alibaba.fastjson.JSONObject;
import domain.ExtensionFeatures;
import domain.ExtensionFlagBit;
import domain.UsrWallet;
import domain.entity.BaseEntity;
import domain.type.TransType;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * 客户钱包交易流水
 * @author zl
 *
 */
public class UsrWalletLog extends BaseEntity implements ExtensionFeatures, ExtensionFlagBit {
    private static final long serialVersionUID = -7803751702185987452L;

 
    private long attachBit;
    /** 钱包流水编号 */
    private String walletLogNo;
    /** 交易类型 */
    private Integer transType;

    /** 类型对应交易id,如充值对应充值流水id，提款对应提款流水id */
 
    private Long logId;
    
    private String logNo;
    
    /**类型对应的交易时间: 例如方案出票时间、提款成功时间等*/
    private Date logTime;
    
    /** 用户ID */
    private Long userId;
    
    private Integer userType;

 
    private String account;
   
    
    /**
     * 关联的walletOrder的id
     */
    private Long walletOrderId; 
    /**
     * 本次消费的现金
     */
    private BigDecimal cashAmount = BigDecimal.ZERO;
    /** 本次消费的彩金 */
    private BigDecimal giftAmount=BigDecimal.ZERO;
    
    /** 本次消费的奖金 */
    private BigDecimal prizeAmount=BigDecimal.ZERO;
    
    /** 本次消费的收益 */
    private BigDecimal incomeAmount=BigDecimal.ZERO;

    /** 奖金可用余额(期末)*/
    private BigDecimal prizeBalance=BigDecimal.ZERO;
    /**
     *  钱包可用彩金(期末)	
     */
    private BigDecimal giftBalance = BigDecimal.ZERO;
    /**
     *  钱包可用现金(期末)
     */
    private BigDecimal cashBalance = BigDecimal.ZERO;
    /**
     *  钱包可用收益(期末)
     */
    private BigDecimal incomeBalance = BigDecimal.ZERO;
    /**
     *  钱包冻结彩金(期末)	
     */
    private BigDecimal freezeGiftBalance = BigDecimal.ZERO;
    /**
     * 钱包冻结现金(期末)
     */
    private BigDecimal freezeCashBalance = BigDecimal.ZERO;
    /**
     * 奖金冻结（期末）
     */
    private BigDecimal freezePrizeBalance = BigDecimal.ZERO;
    /**
     * 奖金冻结（期末）
     */
    private BigDecimal freezeIncomeBalance = BigDecimal.ZERO;
 
    
    /** 关键信息签名(用户id+交易金额+钱包可用余额(期末)+钱包冻结金额(期末) */
    private String verifyMd5;

    /** 时间 */
    private Calendar createTime = Calendar.getInstance();
    
    /** 本次必须消费金额发生额 */
    private BigDecimal deposit;
    /**必须消费金额(期末) */
    private BigDecimal depositBalance;
    /**必须消费金额冻结(期末)*/
    private BigDecimal freezeDepositBalance;
    
    
    /** 关联交易钱包流水 */
    private Long relateId;
    

    
    /** 彩种 */
    private Integer gameId;

    /** 彩期 */
    private String issueNo;
    
 
    private String planNo;
 
    private Integer sellClient;


    private Calendar beginTime;//交易开始时间

    private Calendar endTime;//交易结束时间
    /**
     * 次要状态合并字段
     */
    private Long flagBit=0L;
    /**
     * 次要属性json格式
     */
    private String features="{}";
    
    private String remark;
    
    /**流水发生后的memberWallet
     * */
    private transient UsrWallet afterUsrWallet;
    /**1在线支付，2离线支付*/
    private Integer onlinePay;
  
    
    public UsrWalletLog() {
    }

    public UsrWalletLog(Long id) {
        this.id = id;
    }

    /**
     * 构造方法
     * @param walletLogNo
     * 	交易编号
     * @param transType
     * 	交易类型
     * @param logId
     * 	交易关联记录ID
     * @param member
     * 	客户
     * @param amount
     * 	交易资金
     * @param ableBalance
     *  钱包可用余额(期末)
     * @param freezeBalance
     *  钱包冻结金额(期末)
     */
    public UsrWalletLog(String walletLogNo, Integer transType, Long logId, Long userId,String account,Integer userType,
    		BigDecimal cashAmount,BigDecimal giftAmount,BigDecimal prizeAmount,BigDecimal incomeAmount,
    		BigDecimal ableCashBalance,BigDecimal ableGiftBalance, BigDecimal ablePrizeBalance, BigDecimal ableIncomeBalance,
    		BigDecimal freezeCahsBalance, BigDecimal freezeGiftBalance,BigDecimal freezePrizeBalance,BigDecimal freezeIncomeBalance) {
        super();
        this.walletLogNo = walletLogNo;
        this.transType = transType;
        this.logId = logId;
        this.userId=userId;
        this.userType = userType;
        this.account = account;
        this.createTime = Calendar.getInstance();
        
        this.giftAmount = giftAmount;
        this.cashAmount=cashAmount;
        this.prizeAmount=prizeAmount;
        this.incomeAmount=incomeAmount;
        
        this.giftBalance = ableGiftBalance;
        this.cashBalance=ableCashBalance;
        this.prizeBalance=ablePrizeBalance;
        this.incomeBalance=ableIncomeBalance;
        
        this.freezeCashBalance=freezeCahsBalance;
        this.freezeGiftBalance=freezeGiftBalance;
        this.freezePrizeBalance=freezePrizeBalance;
        this.freezeIncomeBalance=freezeIncomeBalance;
        
        
    }
    
    public UsrWalletLog(String walletLogNo, Integer transType, Long logId, long userId, String account, Integer userType,
    		BigDecimal cashAmount,BigDecimal giftAmount,BigDecimal prizeAmount,BigDecimal incomeAmount,
    		BigDecimal ableCashBalance,BigDecimal ableGiftBalance, BigDecimal ablePrizeBalance, BigDecimal ableIncomeBalance,
    		BigDecimal freezeCahsBalance, BigDecimal freezeGiftBalance,BigDecimal freezePrizeBalance,BigDecimal freezeIncomeBalance) {
        super();
        this.walletLogNo = walletLogNo;
        this.transType = transType;
        this.logId = logId;
        this.userId = userId;
        this.account = account;
        this.userType = userType;
        this.createTime = Calendar.getInstance();
        
        this.giftAmount = giftAmount;
        this.cashAmount=cashAmount;
        this.prizeAmount=prizeAmount;
        this.incomeAmount=incomeAmount;
        
        this.giftBalance = ableGiftBalance;
        this.cashBalance=ableCashBalance;
        this.prizeBalance=ablePrizeBalance;
        this.incomeBalance=ableIncomeBalance;
        
        this.freezeCashBalance=freezeCahsBalance;
        this.freezeGiftBalance=freezeGiftBalance;
        this.freezePrizeBalance=freezePrizeBalance;
        this.freezeIncomeBalance=freezeIncomeBalance;
    }

    @Override
    protected StringBuilder getOrigendFiled() {
        return new StringBuilder().append(userId).append(this.getAmount().setScale(6).toPlainString())
                .append(this.getAbleBalance().setScale(6).toPlainString()).append(this.getFreezeBalance().setScale(6).toPlainString());
    }

    /** 验证钱包日志相关的对象有没有被篡改 */
    public boolean isNotModify() {
        return StringUtils.endsWith(verifyMd5, encodeFiled());
    }

    public static void main(String[] args) {
        BigDecimal b = BigDecimal.valueOf(2);
        System.out.println(b.toPlainString());
    }
    
 
   
    //返回消费总金额
	public BigDecimal getAmount() {
        return this.cashAmount.add(this.giftAmount).add(this.prizeAmount).add(this.incomeAmount);
    }
	//返回总余额
    public BigDecimal getAbleBalance() {
        return this.cashBalance.add(this.giftBalance).add(this.prizeBalance).add(this.incomeBalance);
    }

    public String getVerifyMd5() {
        return verifyMd5;
    }

    public void setVerifyMd5(String verifyMd5) {
        this.verifyMd5 = verifyMd5;
    }
    
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

	public Long getRelateId() {
		return relateId;
	}

	public void setRelateId(Long relateId) {
		this.relateId = relateId;
	}

	public void setTransType(Integer transType) {
		this.transType = transType;
	}

 
 

    public Long getWalletOrderId() {
		return walletOrderId;
	}

	public void setWalletOrderId(Long walletOrderId) {
		this.walletOrderId = walletOrderId;
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

    public String getWalletLogNo() {
        return walletLogNo;
    }

    
    public Long getLogId() {
        return logId;
    }
 
 
	private void addAttachFlag(long flagBit){
		this.attachBit |= flagBit;
	}

	private void removeAttachFlag(long flagBit) {
		this.attachBit &= flagBit ^ Long.MAX_VALUE;
	}

    public String getAccount() {
        return account;
    }
    //返回冻结总金额
    public BigDecimal getFreezeBalance() {
        return this.freezeCashBalance.add(this.freezeGiftBalance).add(this.freezePrizeBalance).add(this.freezeIncomeBalance);
    }

    public Calendar getCreateTime() {
        return createTime;
    }

    public BigDecimal getGiftAmount() {
    	
        return giftAmount;
    }
    
    public BigDecimal getCashAmount() {
		return cashAmount;
	}
    /***
     * 获取用户新浪钱包需要划转的金额（现金+奖金+收益）
     * @return
     */
    public BigDecimal getSinaWalletTransferAmount() {
		return this.giftAmount.add(this.cashAmount).add(this.prizeAmount).add(this.incomeAmount);
	}

	public void setCashAmount(BigDecimal cashAmount) {
		if(cashAmount==null){
			this.cashAmount=BigDecimal.ZERO;
			return;
		}
		this.cashAmount = cashAmount;
	}

	public BigDecimal getGiftBalance() {
		return giftBalance;
	}

	public void setGiftBalance(BigDecimal giftBalance) {
		if(giftBalance==null){
			this.giftBalance=BigDecimal.ZERO;
			return;
		}
		this.giftBalance = giftBalance;
	}

	public BigDecimal getCashBalance() {
		return cashBalance;
	}

	public void setCashBalance(BigDecimal cashBalance) {
		if(cashBalance==null){
			this.cashBalance=BigDecimal.ZERO;
			return;
		}
		this.cashBalance = cashBalance;
	}

	public BigDecimal getFreezeGiftBalance() {
		return freezeGiftBalance;
	}

	public void setFreezeGiftBalance(BigDecimal freezeGiftBalance) {
		if(freezeGiftBalance==null){
			this.freezeGiftBalance=BigDecimal.ZERO;
			return;
		}
		this.freezeGiftBalance = freezeGiftBalance;
	}

	public BigDecimal getFreezeCashBalance() {
		return freezeCashBalance;
	}

	public void setFreezeCashBalance(BigDecimal freezeCashBalance) {
		if(freezeCashBalance==null){
			this.freezeCashBalance=BigDecimal.ZERO;
			return;
		}
		this.freezeCashBalance = freezeCashBalance;
	}
	public BigDecimal getPrizeAmount() {
		return prizeAmount;
	}
	public void setPrizeAmount(BigDecimal prizeAmount) {
		if(prizeAmount==null){
			this.prizeAmount=BigDecimal.ZERO;
			return;
		}
		this.prizeAmount = prizeAmount;
	}
	public BigDecimal getPrizeBalance() {
		return prizeBalance;
	}

	public void setPrizeBalance(BigDecimal prizeBalance) {
		if(prizeBalance==null){
			this.prizeBalance=BigDecimal.ZERO;
			return;
		}
		this.prizeBalance = prizeBalance;
	}
	public BigDecimal getFreezePrizeBalance() {
		return freezePrizeBalance;
	}

	public void setFreezePrizeBalance(BigDecimal freezePrizeBalance) {
		if(freezePrizeBalance==null){
			this.freezePrizeBalance=BigDecimal.ZERO;
			return;
		}
		this.freezePrizeBalance = freezePrizeBalance;
	}

	
	public BigDecimal getIncomeAmount() {
		return incomeAmount;
	}

	public void setIncomeAmount(BigDecimal incomeAmount) {
		if(incomeAmount==null){
			this.incomeAmount=BigDecimal.ZERO;
			return;
		}
		this.incomeAmount = incomeAmount;
	}

	public BigDecimal getIncomeBalance() {
		return incomeBalance;
	}

	public void setIncomeBalance(BigDecimal incomeBalance) {
		if(incomeBalance==null){
			this.incomeBalance=BigDecimal.ZERO;
			return;
		}
		this.incomeBalance = incomeBalance;
	}

	public BigDecimal getFreezeIncomeBalance() {
		return freezeIncomeBalance;
	}

	public void setFreezeIncomeBalance(BigDecimal freezeIncomeBalance) {
		if(freezeIncomeBalance==null){
			this.freezeIncomeBalance=BigDecimal.ZERO;
			return;
		}
		this.freezeIncomeBalance = freezeIncomeBalance;
	}

 

	public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
    	if(deposit==null){
    		this.deposit=BigDecimal.ZERO;
    		return;
    	}
        this.deposit = deposit;
    }
    public BigDecimal getDepositBalance() {
		return depositBalance;
	}

	public void setDepositBalance(BigDecimal depositBalance) {
		if(depositBalance==null){
			this.depositBalance=BigDecimal.ZERO;
			return;
		}
		this.depositBalance = depositBalance;
	}

	public BigDecimal getFreezeDepositBalance() {
		return freezeDepositBalance;
	}

	public void setFreezeDepositBalance(BigDecimal freezeDepositBalance) {
		if(freezeDepositBalance==null){
			this.freezeDepositBalance=BigDecimal.ZERO;
			return;
		}
		this.freezeDepositBalance = freezeDepositBalance;
	}
	
    public void setGiftAmount(BigDecimal giftAmount) {
    	if(giftAmount==null){
			this.giftAmount=BigDecimal.ZERO;
			return;
		}
        this.giftAmount = giftAmount;
    }

    public Calendar getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Calendar beginTime) {
        this.beginTime = beginTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public void setWalletLogNo(String walletLogNo) {
        this.walletLogNo = walletLogNo;
    }

 

    public Integer getTransType() {
		return transType;
	}

	public void setLogId(Long logId) {
        this.logId = logId;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getSellClient() {
		return sellClient;
	}

	public void setSellClient(Integer sellClient) {
		this.sellClient = sellClient;
	}

	public void setCreateTime(Calendar createTime) {
        this.createTime = createTime;
    }

 
	public String getLogNo() {
        return logNo;
    }

    public void setLogNo(String logNo) {
        this.logNo = logNo;
    }

    public String getPlanNo() {
        return planNo;
    }
    
    @Deprecated
    /**
     * Deprecated是因为建议将planNo退出市场，定义为planId
     */
    public void setPlanNo(String planNo) {
        this.planNo = planNo;
    }
    
	

 

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	public UsrWallet getAfterUsrWallet() {
		return afterUsrWallet;
	}

	public void setAfterUsrWallet(UsrWallet afterUsrWallet) {
		this.afterUsrWallet = afterUsrWallet;
	}

	@Override
	public long getFlagBit() {
		return this.flagBit==null?0:flagBit;
	}
	
	@Override
	public String getFeatures() {
		return this.features;
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
		this.features = this.features.equals("")?"{}":this.features;
		
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Integer getOnlinePay() {
		return onlinePay;
	}

	public void setOnlinePay(Integer onlinePay) {
		this.onlinePay = onlinePay;
	}

	@Override
	public int getFlagVersion() {
		return 0;
	}

	@Override
	public int getFeaturesVersion() {
		return 0;
	}
	
	/***
	 * 返回正负符号
	 * 代表加钱减钱方向
	 * @return “+” 或 “-”
	 */
   	public String getAddSubtractSymbol(){
   		TransType tt =  TransType.findByIndex(this.transType);
   		if(TransType.getIncomeTypeList().contains(  tt   )  ){
   			return "+";
   		}else if(TransType.getOutcomeTypeList().contains(   tt  )){
   			return "-";
   		}
   		return "";
   	}
	
}

package domain;
import com.alibaba.fastjson.JSONObject;
import domain.entity.BaseEntity;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

/**
 * 客户钱包
 *
 * @author yaya
 *
 */
public class UsrWallet extends BaseEntity implements ExtensionFeatures,ExtensionFlagBit{
    private static final long serialVersionUID = -9083773818719361196L;

 
    

    /**
     * 因很容易将"attachBit |= flagBit"写成"attachBit = flagBit"，
     * 所以只推荐用removeAttachFlag()和addAttachFlag()
     * 所以这文件里只允许4处直接用到attachBit, 搜一下就知道是否按规范了
     */
    private long attachBit;

    /** 所属用户  */
    /** 用户ID */
    private Long userId;
    /***
     * 用户类型
     */
    private Integer userType;
    

 
    private String account;
    /** 可用收益余额 */
    private BigDecimal ableIncomeBalance = BigDecimal.ZERO;
    
	/** 可用彩金余额 */
  
    private BigDecimal ableGiftBalance = BigDecimal.ZERO;
    /**
     * 可用现金余额(不包括奖金)
     */
    private BigDecimal ableCashBalance = BigDecimal.ZERO;
    /**
     * 可用奖金余额
     */
    private BigDecimal  ablePrizeBalance = BigDecimal.ZERO;
    /**
     * 冻结彩金余额
     */
    private BigDecimal freezeGiftBalance = BigDecimal.ZERO;
    /**
     * * 冻结现金余额
     */
    private BigDecimal freezeCashBalance = BigDecimal.ZERO;

   /**
    * 冻结奖金余额
    */
    private BigDecimal  freezePrizeBalance = BigDecimal.ZERO;

    /**
     * 冻结收益余额
     */
     private BigDecimal  freezeIncomeBalance = BigDecimal.ZERO;
    /**
     * 必须消费的金额余额
     */
    private BigDecimal deposit = BigDecimal.ZERO;
    /**
     * 冻结的 必须消费的金额余额
     */
    private BigDecimal freezeDepositBalance = BigDecimal.ZERO;
    /**
     * 历史投注额
     * 对于站点：历史返奖总额
     * 
     */
    private BigDecimal heapBalance= BigDecimal.ZERO;
    /**
     * 历史总奖金额度
     */
    private BigDecimal heapPrize= BigDecimal.ZERO;
    /**
     * 历史总彩金
     */
    private BigDecimal heapGift= BigDecimal.ZERO;
    
    /**
     * 历史总收益
     */
    private BigDecimal heapIncome= BigDecimal.ZERO;
        
    /** 校验码:MD5(用户id+可用余额+彩金余额+冻结金额+必须消费最低金额 ) */

    private String verifyMd5;
    /**
     * 次要状态合并字段
     */
	private Long flagBit = 0L;
    /**
     * 次要属性json格式
     */
    private String features="{}";
    private Integer flagVersion=0;
	private Integer featuresVersion=0;
	/**
	 * 控制*Balance的乐观锁,现在还没有用起来
	 */
	private Long transferVersion=0L;
	
    /** 最后一次修改时间 */
//    @Version
 
    private Calendar updateTime;

    public UsrWallet() {
    }
    
    public UsrWallet(Long userId,Integer userType,String account) {
        super();
        this.userType = userType;
        this.userId = userId;
        this.account = account;
        this.updateTime = Calendar.getInstance();
    }

    /**
     * 得到钱包可提款金额
     * @return
     * @create_time 2011-5-5 下午05:31:23
     */
    public BigDecimal getAbleGetMoney() { 
    	BigDecimal ableGetMoney=BigDecimal.ZERO;
    	if(this.deposit.compareTo(BigDecimal.ZERO)<=0 && this.freezeDepositBalance.compareTo(BigDecimal.ZERO)<=0){
    		ableGetMoney=this.ableCashBalance.add(this.ablePrizeBalance).add(this.ableIncomeBalance);
    	}else{
    		ableGetMoney=this.ablePrizeBalance.add(this.ableIncomeBalance);
    	}
    	ableGetMoney=ableGetMoney.compareTo(BigDecimal.ZERO)<0?BigDecimal.ZERO:ableGetMoney;
    	ableGetMoney=ableGetMoney.setScale(2, RoundingMode.DOWN);
        return ableGetMoney;
    }

    
    @Override
    protected StringBuilder getOrigendFiled() {
        //改造前:用户id+可用余额+彩金余额+冻结金额+必须消费最低金额 
    	//改造后:用户id+able_Gift_Balance+able_Cash_Balance+ freeze_Gift_Balance+  freeze_cash_Balance+ deposit
        return new StringBuilder(userId.toString()).append(ableGiftBalance.setScale(6).toPlainString())
                .append(ableCashBalance.setScale(6).toPlainString()).append(freezeGiftBalance.setScale(6).toPlainString())
                .append(freezeCashBalance.setScale(6).toPlainString())
                .append(deposit.setScale(6).toPlainString());
    }
    

    public String getVerifyMd5() {
        return verifyMd5;
    }

    public void setVerifyMd5(String verifyMd5) {
        this.verifyMd5 = verifyMd5;
    }
    
	@Deprecated
    public boolean isNotModify() {
        return StringUtils.endsWith(verifyMd5, encodeFiled());
    }

    public Calendar getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Calendar updateTime) {
        this.updateTime = updateTime;
    }

    
    public Long getUserId() {
		return userId;
	}
 
    public void setUserId(Long userId){
    	this.userId = userId;
    }
    
    public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public void setAccount(String account){
    	this.account = account;
    }

	private void removeAttachFlag(long flagBit) {
		this.attachBit &= flagBit ^ Long.MAX_VALUE;
	}
	
	private void addAttachFlag(long flagBit){
		this.attachBit |= flagBit;
	}

    public String getAccount() {
        return account;
    }

 
	public BigDecimal getAbleIncomeBalance() {
		return ableIncomeBalance;
	}

	public void setAbleIncomeBalance(BigDecimal ableIncomeBalance) {
		this.ableIncomeBalance = ableIncomeBalance;
	}
	/***
	 * 可用余额
	 * @return
	 */
	public BigDecimal getAbleBalance() {
    	BigDecimal money = this.ableCashBalance.add(this.ableGiftBalance).add(this.ablePrizeBalance).add(this.ableIncomeBalance);
        return money.setScale(2, RoundingMode.DOWN);
    }

    public BigDecimal getAbleGiftBalance() {
        return ableGiftBalance;
    }
    /***
     * 冻结金额
     * @return
     */
    public BigDecimal getFreezeAmount() {
        return this.freezeCashBalance.add(this.freezePrizeBalance).add(this.freezeGiftBalance).add(this.freezeIncomeBalance);
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public BigDecimal getHeapBalance() {
        return heapBalance;
    }

    public BigDecimal getHeapPrize() {
        return heapPrize;
    }

    public BigDecimal getHeapGift() {
        return heapGift;
    }

    public void setDeposit(BigDecimal deposit) {
    	if(deposit==null){
    		deposit=BigDecimal.ZERO;
			return;
    	}
        this.deposit = deposit;
    }
    
    public BigDecimal getFreezeDepositBalance() {
		return freezeDepositBalance;
	}

	public void setFreezeDepositBalance(BigDecimal freezeDepositBalance) {
		if(freezeDepositBalance==null){
			freezeDepositBalance=BigDecimal.ZERO;
			return;
		}
		this.freezeDepositBalance = freezeDepositBalance;
	}

	public void setAbleGiftBalance(BigDecimal ableGiftBalance) {
    	if(ableGiftBalance==null){
    		this.ableGiftBalance=BigDecimal.ZERO;
    		
    		return;
    	}
        this.ableGiftBalance = ableGiftBalance;
        
    }
    
    public BigDecimal getAbleCashBalance() {
    	BigDecimal money=ableCashBalance.setScale(2, RoundingMode.DOWN);
		return money;
	}
    
	public void setAbleCashBalance(BigDecimal ableCashBalance) {
		if(ableCashBalance==null){
    		this.ableCashBalance=BigDecimal.ZERO;
    		
    		return;
    	}
		this.ableCashBalance = ableCashBalance;
		
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
	
	public BigDecimal getAblePrizeBalance() {
		return ablePrizeBalance;
	}

	public void setAblePrizeBalance(BigDecimal ablePrizeBalance) {
		if(ablePrizeBalance==null){
    		this.ablePrizeBalance=BigDecimal.ZERO;
    		return;
    	}
		this.ablePrizeBalance = ablePrizeBalance;
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

	public void setHeapBalance(BigDecimal heapBalance) {
        this.heapBalance = heapBalance;
    }

    public void setHeapPrize(BigDecimal heapPrize) {
        this.heapPrize = heapPrize;
    }

    public void setHeapGift(BigDecimal heapGift) {
        this.heapGift = heapGift;
    }

	public BigDecimal getHeapIncome() {
		return heapIncome;
	}
	public void setHeapIncome(BigDecimal heapIncome) {
		this.heapIncome = heapIncome;
	}
	@Override
	public long getFlagBit() {
		return this.flagBit==null?0:flagBit;
	}
	@Override
	public int getFlagVersion() {
		return this.flagVersion==null?0:flagVersion;
	}
	@Override
	public String getFeatures() {
		return this.features;
	}
	@Override
	public int getFeaturesVersion() {
		return this.featuresVersion==null?0:featuresVersion;
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
	public void setFlagVersion(Integer flagVersion) {
		this.flagVersion = flagVersion==null?0:flagVersion;
	}
	public void setFeaturesVersion(Integer featuresVersion) {
		this.featuresVersion = featuresVersion==null?0:featuresVersion;
	}

	public Long getTransferVersion() {
		return transferVersion;
	}

	public void setTransferVersion(Long transferVersion) {
		this.transferVersion = transferVersion;
	}

 
}

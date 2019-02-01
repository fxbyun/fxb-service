package domain.entity;

import domain.UsrWallet;
import domain.exception.WalletErrorTable;
import domain.exception.WalletException;
import domain.type.TransType;
import domain.type.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class UsrWalletHandle {

	private Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * 先用可用（或冻结）彩金，再现金，再收益，最后奖金
	 */
	public static final int subtractGiftFirst=1;
	/**
	 * 先可用（或冻结）奖金，再现金，再收益，最后彩金
	 */
	public static final int subtractPrizeFirst=2;

	
	/**
	 * 先可用（或冻结）现金，再收益，再奖金，最后彩金
	 */
	public static final int subtractCashFirst=3;
	
	/**
	 * 先用可用（或冻结）彩金，再奖金,最后现金，再收益，
	 */
	public static final int subtractGiftFirstAndPrizeSecond=4;
	/**
	 * 为充值构造发生额度vo
	 * @param w
	 * @param localDepositLv
	 * @param handlingCost
	 * @param amount
	 * @return
	 */
	public WalletLogActualVo buildWalletLogActualVoForCharge(BigDecimal localDepositLv,BigDecimal handlingCost,BigDecimal amount){
		handlingCost=handlingCost.setScale(2, RoundingMode.HALF_UP);
		BigDecimal chargeAmount = amount.subtract(handlingCost); // 实际充值金额
		chargeAmount = chargeAmount.setScale(2, RoundingMode.DOWN);
//		BigDecimal localDeposit = amount.multiply(localDepositLv);// 必须消费额
//		localDeposit = localDeposit.subtract(handlingCost);// 最低消费金额要减去手续费
//根据13年7月22日和产品,财务会议精神,现在改为  最低消费金额=到账金额*localDepositLv
		BigDecimal localDeposit = chargeAmount.multiply(localDepositLv);
		if(localDeposit.compareTo(BigDecimal.ZERO) <0){
			localDeposit = BigDecimal.ZERO;
		}
		WalletLogActualVo walletLogActualVo=new WalletLogActualVo();
		walletLogActualVo.setCash(chargeAmount);
		walletLogActualVo.setGift(BigDecimal.ZERO);
		walletLogActualVo.setDeposit(localDeposit);
		
		return walletLogActualVo;
	}
	
    
    /**算出这次扣款 需要用到 彩金多少、现金多少、收益奖金多少
     * 构造发生额Vo(使用可用余额)
	 * WalletLogActualVo 用来记录扣款方式，是从现金先扣，还是奖金先扣，具体到：用户钱包的现金扣多少，奖金扣多少，彩金受益等
	 * WalletLogActualVo 用途：后面用来计算生成一条 walletLog 日志
	 * firstOption 扣款方式：先用可用（或冻结）彩金，再现金，再收益，最后奖金......
     * @return
     */
    public WalletLogActualVo buildLogActualVoForSubtractAbleBalance(int firstOption, UsrTransVo memberTransVo, UsrWallet preWallet){
    	WalletLogActualVo walletLogActualVo=new WalletLogActualVo();
    	Integer transType = memberTransVo.getTransType();
    	BigDecimal amount = memberTransVo.getAmount();
    	//使用可用余额
		//判断 交易类型 是否在可冻结金额里，或者 是可支付类型
		//transType 交易类型：直付充值、会员充值......
    	if(TransType.getFreezeList().contains(transType)||TransType.getDirectePayList().contains(transType) ){
			if (preWallet.getAbleBalance().compareTo(amount) < 0) {
				log.warn("会员[{}]执行交易[{}]时钱包可用余额不足,需要使用[{}]元,钱包[{}],业务id:{}", new Object[] { preWallet.getAccount(),
						transType, amount.toPlainString(), preWallet.getAbleBalance().toPlainString(), memberTransVo.getTransType() });
				throw new WalletException(WalletErrorTable.NOT_SUFFICIENT_FUNDS);
			}
			//判断 扣款方式的先后顺序
			if(firstOption == UsrWalletHandle.subtractGiftFirst){
				//先彩金
				walletLogActualVo = this.buildActualVoForSubtractAbleBalanceAndGiftFirst(preWallet, amount, transType);
			}else if(firstOption == UsrWalletHandle.subtractPrizeFirst){
				//奖金
				walletLogActualVo = this.buildActualVoForSubtractAbleBalanceAndPrizeFirst(preWallet, amount, transType);
			}else if(firstOption == UsrWalletHandle.subtractCashFirst){
				//先现金
				walletLogActualVo = this.buildActualVoForSubtractAbleBalanceAndCashFirst(preWallet, amount, transType);
			}else if(firstOption == UsrWalletHandle.subtractGiftFirstAndPrizeSecond){
				//使用可用余额而且彩金优先
				walletLogActualVo = this.buildActualVoForSubtractAbleBalanceAndGiftFirstPrizeSecond(preWallet, amount, transType);
			}else{
				throw new WalletException(WalletErrorTable.ILLEGAL_First_OPTION);
			}
			return walletLogActualVo;
		}
	
		
		throw new WalletException(WalletErrorTable.ILLEGAL_RELATE_TRANS);
    }
    
    /**
     * 构造发生额Vo(使用冻结余额)
     * 用于解冻 或  冻结转支付
     * @return
     */
    public WalletLogActualVo buildLogActualVoForSubtractFreezeBalance(int firstOption,UsrTransVo memberTransVo,
    		UsrWallet preWallet,UsrWalletLog preWalletLog){
    	WalletLogActualVo walletLogActualVo=new WalletLogActualVo();
    	Integer transType = memberTransVo.getTransType();
  
		//使用冻结
		if(TransType.getUnFreezeList().contains(transType)|| TransType.getTransferPayList().contains(transType)){
//			//因为现在有的用户冻结里面还有负数,暂时允许amount> preWallet.getFreezeAmount()
			if (preWallet.getFreezeAmount().compareTo(memberTransVo.getAmount()) < 0) {
				log.warn("会员[{}]执行交易[{}]时钱包冻结余额不足,需要使用冻结余额[{}]元,钱包[{}],业务id:{}", new Object[] { preWallet.getAccount(),
						transType, memberTransVo.getAmount().toPlainString(), preWallet.getFreezeAmount().toPlainString(), memberTransVo.getTransOrderId()});
				throw new WalletException(WalletErrorTable.NOT_SUFFICIENT_FUNDS);
			}
			if(firstOption == UsrWalletHandle.subtractGiftFirst){
				walletLogActualVo =  this.buildActualVoForSubtractFreezeBalanceAndGiftFirst(preWallet,preWalletLog, memberTransVo);
			}else if(firstOption == UsrWalletHandle.subtractPrizeFirst){
				walletLogActualVo = this.buildActualVoForSubtractFreezeBalanceAndPrizeFirst(preWallet,preWalletLog, memberTransVo);
			}else{
				throw new WalletException(WalletErrorTable.ILLEGAL_First_OPTION);
			}
			
			return walletLogActualVo;
		}
		throw new WalletException(WalletErrorTable.ILLEGAL_RELATE_TRANS);
		
    }
    
 
 
    
    public WalletLogActualVo buildLogActualVoForRefund(UsrTransVo memberTransVo,UsrWallet preWallet,UsrWalletLog preWalletLog){
    	WalletLogActualVo walletLogActualVo=new WalletLogActualVo();
    	Integer transType = memberTransVo.getTransType();
    	BigDecimal amount = memberTransVo.getAmount();
    	//冻结转支付后退款 或 直接支付后退款
		if(TransType.getRefundForTransferPayList().contains(transType) || TransType.getRefundForDirectePayList().contains(transType)){
			if (preWalletLog.getAmount().compareTo(amount) < 0) {
				log.warn("会员[{}]执行交易[{}]时超过已经支付的额度,需要退款[{}]元,已支付的额度[{}],业务id:{}", new Object[] { preWallet.getAccount(),
						transType,amount.toPlainString(), preWalletLog.getAmount().toPlainString(), memberTransVo.getTransOrderId() });
				throw new WalletException(WalletErrorTable.ILLEGAL_TRANS_AMOUNT);
			}
			BigDecimal refundPrize = preWalletLog.getPrizeAmount().compareTo(amount)>0?amount:preWalletLog.getPrizeAmount();
			BigDecimal refundCash = amount.subtract(refundPrize);
			refundCash = refundCash.compareTo(preWalletLog.getCashAmount())>0?preWalletLog.getCashAmount():refundCash;
			//退款收益
			BigDecimal refundIncome = amount.subtract(refundPrize).subtract(refundCash);
			refundIncome = refundIncome.compareTo(preWalletLog.getIncomeAmount())>0?preWalletLog.getIncomeAmount():refundIncome;
			
			BigDecimal refundGift = amount.subtract(refundPrize).subtract(refundCash).subtract(refundIncome);
			//退款Deposit不回退
			BigDecimal useDeposit = BigDecimal.ZERO;
			
			walletLogActualVo = this.buildWalletLogActualVo(refundCash, refundGift, refundPrize,refundIncome, useDeposit, transType);
			
			return walletLogActualVo;
		}
		
		throw new WalletException(WalletErrorTable.ILLEGAL_RELATE_TRANS);
    }
    /**
     * 构造发生额Vo(增加可用余额)
     * @return
     */
    public WalletLogActualVo buildLogActualVoForAddAbleBalance(UsrTransVo memberTransVo){
    	WalletLogActualVo walletLogActualVo=new WalletLogActualVo();
    	Integer transType = memberTransVo.getTransType();
    	BigDecimal amount = memberTransVo.getAmount();
    	
    	if(TransType.getAddPrizeList().contains(transType)){		
			walletLogActualVo = this.buildWalletLogActualVo(BigDecimal.ZERO, BigDecimal.ZERO, amount, BigDecimal.ZERO,BigDecimal.ZERO, transType);
			return walletLogActualVo;
    	}
    	if(TransType.getAddGiftList().contains(transType)){
			walletLogActualVo = this.buildWalletLogActualVo(BigDecimal.ZERO, amount, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,transType);
			return walletLogActualVo;
		}
    	if(TransType.getAddCashList().contains(transType)){
			walletLogActualVo = this.buildWalletLogActualVo(amount, BigDecimal.ZERO, BigDecimal.ZERO,  BigDecimal.ZERO, BigDecimal.ZERO,transType);
			return walletLogActualVo;
		}
    	if(TransType.getAddIncomeList().contains(transType)){
			walletLogActualVo = this.buildWalletLogActualVo(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,  BigDecimal.ZERO,amount,transType);
			return walletLogActualVo;
		}
    	
    	throw new WalletException(WalletErrorTable.ILLEGAL_RELATE_TRANS);
		
    }
    
    public UsrWalletLog buildWalletLogForTransType(UsrWallet preWallet,  WalletLogActualVo actualVo,
    		UsrTransVo memberTransVo, Long relateId,Integer sellClient,String remark){
    	
    	Integer transType = memberTransVo.getTransType();
    	Long logId = memberTransVo.getTransOrderId();
    	String logNo = memberTransVo.getTransOrderNo();
    	Integer gameId =  memberTransVo.getGameId();
    	String issueNo = memberTransVo.getIssueNo();
    	String planNo = memberTransVo.getPlanNo();
    	//用户钱包升级阶段使用
    	actualVo.setTransInfo(memberTransVo.getTransInfo());
    	//充值
    	if(TransType.getChargList().contains(transType)){
    		return this.buildWalletLogForCharge( preWallet, actualVo, transType, logId, logNo, relateId, gameId, issueNo, planNo,sellClient, remark);
    	}
    	//收益
    	if(TransType.getAddIncomeList().contains(transType)){
    		return this.buildWalletLogForIncome( preWallet, actualVo, transType, logId, logNo, relateId, gameId, issueNo, planNo,sellClient, remark);
    	}
    	//add gift
    	if(TransType.getAddGiftList().contains(transType)){
    		return this.buildWalletLogForAddGift(preWallet, actualVo, transType, logId, logNo, relateId, gameId, issueNo, planNo,sellClient, remark);
    	}
    	// add cash
    	if(TransType.getAddCashList().contains(transType)){
    		return this.buildWalletLogForAddCash(preWallet, actualVo, transType, logId, logNo, relateId, gameId, issueNo, planNo,sellClient, remark);
    	}
    	// add prize
    	if(TransType.getAddPrizeList().contains(transType)){
    		UsrWallet afterWallet = this.addPrize(preWallet, actualVo);
    		return this.buildWalletLog( afterWallet, actualVo, transType, logId, logNo, relateId, gameId, issueNo, planNo, null,sellClient, remark);
    	}
    	// subtract ableBalance
    	if(TransType.getDirectePayList().contains(transType)){
    		return this.buildWalletLogForDirectPay(preWallet, actualVo, transType, logId, logNo, relateId, gameId, issueNo, planNo,sellClient, remark);
    	}
    	// subtract ableBalance and add freezeBalance
    	if(TransType.getFreezeList().contains(transType)){
    		return this.buildWalletLogForFreeze(preWallet, actualVo, transType, logId, logNo, relateId, gameId, issueNo, planNo,sellClient, remark);
    	}
    	// subtract freezeBalance 
    	if(TransType.getTransferPayList().contains(transType)){
    		return this.buildWalletLogForTransferPay(preWallet, actualVo, transType, logId, logNo, relateId, gameId, issueNo, planNo,sellClient, remark);
    	}
    	// subtract freezeBalance and add ableBalance
    	if(TransType.getUnFreezeList().contains(transType)){
    		return this.buildWalletLogForUnFreeze(preWallet, actualVo, transType, logId, logNo, relateId, gameId, issueNo, planNo,sellClient, remark);
    	}
    	// refund
    	if(TransType.getRefundForDirectePayList().contains(transType) || TransType.getRefundForTransferPayList().contains(transType)){
    		return this.buildWalletLogForRefound(preWallet, actualVo, transType, logId, logNo, relateId, gameId, issueNo, planNo,sellClient, remark);
    	}
    	
    	throw new WalletException(WalletErrorTable.ILLEGAL_RELATE_TRANS);
    }
    /**
     * 为加现金构造UsrWalletLog
     * @param id
     * @param preWallet
     * @param actualVo
     * @param transType
     * @param logId
     * @param logNo
     * @param relateId
     * @param gameId
     * @param issueNo
     * @param planNo
     * @param chargeOrder
     * @param remark
     * @return
     */
    private UsrWalletLog buildWalletLogForAddCash(UsrWallet preWallet,  WalletLogActualVo actualVo,
    		Integer transType, Long logId, String logNo, Long relateId,Integer gameId, String issueNo, String planNo,Integer sellClient,String remark) {
    	
    	UsrWallet afterWallet=this.addCash(preWallet,actualVo);
    	
    	
    	return this.buildWalletLog( afterWallet, actualVo, transType, logId,logNo,relateId, gameId, issueNo, planNo, null,sellClient,remark);
    }
    
    /**
     * 为加彩金构造UsrWalletLog
     * @param id
     * @param preWallet
     * @param actualVo
     * @param transType
     * @param logId
     * @param logNo
     * @param relateId
     * @param gameId
     * @param issueNo
     * @param planNo
     * @param chargeOrder
     * @param remark
     * @return
     */
    private UsrWalletLog buildWalletLogForAddGift(UsrWallet preWallet,  WalletLogActualVo actualVo,
    		Integer transType, Long logId, String logNo, Long relateId,Integer gameId, String issueNo, String planNo,Integer sellClient,String remark) {
    	
    	UsrWallet afterWallet=preWallet;
    	afterWallet.setAbleGiftBalance(afterWallet.getAbleGiftBalance().add(actualVo.getGift()));
    	afterWallet.setAbleCashBalance(afterWallet.getAbleCashBalance().add(actualVo.getCash()));
    	afterWallet.setHeapGift(afterWallet.getHeapGift().add(actualVo.getHeapGift()));
    	//deposit最大可加值
    	BigDecimal depositMaxAddPart = afterWallet.getAbleCashBalance().subtract(preWallet.getDeposit());
    	//矫正要加的deposit
    	actualVo.setDeposit(actualVo.getDeposit().compareTo(depositMaxAddPart)<0?actualVo.getDeposit():depositMaxAddPart);
    	afterWallet.setDeposit(afterWallet.getDeposit().add(actualVo.getDeposit()));
    	return this.buildWalletLog( afterWallet, actualVo, transType, logId,logNo,relateId, gameId, issueNo, planNo, null,sellClient, remark);
    }
    /**
     * 一般参加了某种活动Deposit发生改变;构造UsrWalletLog
     * @param id
     * @param preWallet
     * @param actualVo
     * @param transType
     * @param logId
     * @param logNo
     * @param relateId
     * @param gameId
     * @param issueNo
     * @param planNo
     * @param chargeOrder
     * @param remark
     * @return
     */
    public UsrWalletLog buildWalletLogForAddDeposit(UsrWallet preWallet,  WalletLogActualVo actualVo,
    		Integer transType, Long logId, String logNo, Long relateId,Integer gameId, String issueNo, String planNo,Integer sellClient,String remark) {
    	
    	UsrWallet afterWallet=preWallet;
    	afterWallet.setDeposit(afterWallet.getDeposit().add(actualVo.getDeposit()));
    	return this.buildWalletLog( afterWallet, actualVo, transType, logId,logNo,relateId, gameId, issueNo, planNo, null,sellClient, remark);
    }
    
    /**
     * 为冻结用户的可用金额构造UsrWalletLog
     * @param id
     * @param preWallet
     * @param actualVo
     * @param transType
     * @param logId
     * @param logNo
     * @param relateId
     * @param gameId
     * @param issueNo
     * @param planNo
     * @param chargeOrder
     * @param remark
     * @return
     */
    private UsrWalletLog buildWalletLogForFreeze(UsrWallet preWallet,WalletLogActualVo actualVo,
    		Integer transType, Long logId, String logNo, Long relateId,Integer gameId, String issueNo, String planNo,Integer sellClient,String remark) {
    	
    	UsrWallet afterWallet=this.freeze(preWallet, actualVo);
    	
    	UsrWalletLog memberWalletLog=this.buildWalletLog( afterWallet, actualVo, transType, logId,logNo,relateId, gameId, issueNo, planNo, null,sellClient, remark);
    	  	
    	return memberWalletLog;
    }
    
    /**
     * 为解冻用户的冻结金额构造UsrWalletLog,同时设定好UsrWallet,UsrWalletOrder的值
     * @param id
     * @param preWallet
     * @param actualVo
     * @param transType
     * @param logId
     * @param logNo
     * @param relateId
     * @param gameId
     * @param issueNo
     * @param planNo
     * @param chargeOrder
     * @param remark
     * @return
     */
    private UsrWalletLog buildWalletLogForUnFreeze(UsrWallet preWallet,WalletLogActualVo actualVo,
    		Integer transType, Long logId, String logNo, Long relateId,Integer gameId, String issueNo, String planNo,Integer sellClient,String remark) {
    	
    	UsrWallet afterWallet=this.unfreeze(preWallet, actualVo);
    	
    	UsrWalletLog memberWalletLog=this.buildWalletLog( afterWallet, actualVo, transType, logId,logNo,relateId, gameId, issueNo, planNo, null,sellClient, remark);
    	
    	return memberWalletLog;
    }
    /**
     * 为解冻用户的冻结金额构造UsrWalletLog,同时设定好UsrWallet,UsrWalletOrder的值
     * @param id
     * @param preWallet
     * @param actualVo
     * @param transType
     * @param logId
     * @param logNo
     * @param relateId
     * @param gameId
     * @param issueNo
     * @param planNo
     * @param chargeOrder
     * @param remark
     * @return
     */
    private UsrWalletLog buildWalletLogForTransferPay(UsrWallet preWallet,WalletLogActualVo actualVo,
    		Integer transType, Long logId, String logNo, Long relateId,Integer gameId, String issueNo, String planNo,Integer sellClient,String remark) {
    	
    	UsrWallet afterWallet=this.transferPay(preWallet, actualVo);
    	
    	UsrWalletLog memberWalletLog=this.buildWalletLog( afterWallet, actualVo, transType, logId,logNo,relateId, gameId, issueNo, planNo, null,sellClient, remark);
    	
    	return memberWalletLog;
    }
    /**
     * 为退款(包括冻结转支付后的退款)构造UsrWalletLog,同时设定好UsrWallet,UsrWalletOrder的值
     * @param id
     * @param preWallet
     * @param actualVo
     * @param transType
     * @param logId
     * @param logNo
     * @param relateId
     * @param gameId
     * @param issueNo
     * @param planNo
     * @param chargeOrder
     * @param remark
     * @return
     */
    private UsrWalletLog buildWalletLogForRefound(UsrWallet preWallet,WalletLogActualVo actualVo,
    		Integer transType, Long logId, String logNo, Long relateId,Integer gameId, String issueNo, String planNo,Integer sellClient,String remark) {
    	
    	UsrWallet afterWallet=this.refound(preWallet, actualVo);
    	
    	UsrWalletLog memberWalletLog=this.buildWalletLog( afterWallet, actualVo, transType, logId,logNo,relateId, gameId, issueNo, planNo, null,sellClient, remark);
    	
    	return memberWalletLog;
    }
    /**
     * 为直接支付构造UsrWalletLog,同时设定好UsrWallet,UsrWalletOrder的值
     * @param id
     * @param preWallet
     * @param actualVo
     * @param transType
     * @param logId
     * @param logNo
     * @param relateId
     * @param gameId
     * @param issueNo
     * @param planNo
     * @param chargeOrder
     * @param remark
     * @return
     */
    private UsrWalletLog buildWalletLogForDirectPay(UsrWallet preWallet,WalletLogActualVo actualVo,
    		Integer transType, Long logId, String logNo, Long relateId,Integer gameId, String issueNo, String planNo,Integer sellClient,String remark) {
    	
    	UsrWallet afterWallet=this.directPay(preWallet, actualVo);
    	
    	UsrWalletLog memberWalletLog=this.buildWalletLog( afterWallet, actualVo, transType, logId,logNo,relateId, gameId, issueNo, planNo, null,sellClient,remark);
    	
    	return memberWalletLog;
    }
    
    /**
     * 为充值构造UsrWalletLog
     * @param id
     * @param preWallet
     * @param actualVo
     * @param member
     * @param transType
     * @param logId
     * @param gameId
     * @param issueNo
     * @param planNo
     * @param remark
     * @return
     */
    private UsrWalletLog buildWalletLogForCharge(UsrWallet preWallet,  WalletLogActualVo actualVo,
    		Integer transType, Long logId, String logNo, Long relateId,Integer gameId, String issueNo, String planNo,Integer sellClient,String remark) {
    	
    	UsrWallet afterWallet=this.charge(preWallet, actualVo);
    	return this.buildWalletLog( afterWallet, actualVo, transType, logId,logNo,relateId, gameId, issueNo, planNo, null,sellClient, remark);
    }
    /**
     * 收益构造
     * @param preWallet
     * @param actualVo
     * @param transType
     * @param logId
     * @param logNo
     * @param relateId
     * @param gameId
     * @param issueNo
     * @param planNo
     * @param sellClient
     * @param remark
     * @return
     */
    private UsrWalletLog buildWalletLogForIncome(UsrWallet preWallet,  WalletLogActualVo actualVo,
    		Integer transType, Long logId, String logNo, Long relateId,
    		Integer gameId, String issueNo, String planNo,Integer sellClient,String remark) {
    	
    	UsrWallet afterWallet=this.income(preWallet, actualVo);
    	return this.buildWalletLog( afterWallet, actualVo, transType, logId,logNo,relateId, gameId, issueNo, planNo, null,sellClient, remark);
    }
    
    private WalletLogActualVo buildWalletLogActualVo(BigDecimal cash,BigDecimal gift,BigDecimal prize,BigDecimal income,
    		BigDecimal deposit,Integer transType){
    	WalletLogActualVo walletLogActualVo=new WalletLogActualVo();
    	walletLogActualVo.setCash(cash);
    	walletLogActualVo.setGift(gift);
    	walletLogActualVo.setPrize(prize);
    	walletLogActualVo.setIncome(income);
    	
    	if(!TransType.getNotNeedDepositList().contains(transType)){//需要处理Deposit的
			walletLogActualVo.setDeposit(deposit);
		}
		if(TransType.getNeedHeapBalanceList().contains(transType)){
			walletLogActualVo.setHeapBalance(cash.add(gift).add(prize));
		}
		if(TransType.getNeedHeapGiftList().contains(transType)){
			walletLogActualVo.setHeapGift(gift);
		}
		if(TransType.getNeedHeapPrizeList().contains(transType)){
			walletLogActualVo.setHeapPrize(prize);
		}
		if(TransType.getNeedHeapIncomeList().contains(transType)){
			walletLogActualVo.setHeapIncome(income);
		}
		return walletLogActualVo;
    }
	
    /**
	 * 使用可用余额而且彩金优先
	 * @return
	 */
	private WalletLogActualVo  buildActualVoForSubtractAbleBalanceAndGiftFirstPrizeSecond(UsrWallet preWallet,
			BigDecimal useAmout,Integer transType){
		//先用彩金
		BigDecimal useGift=preWallet.getAbleGiftBalance().compareTo(useAmout)>=0?useAmout:preWallet.getAbleGiftBalance();
		if(useGift.compareTo(BigDecimal.ZERO)<0){
			useGift=BigDecimal.ZERO;
		}
		useGift = useGift.setScale(2, RoundingMode.DOWN);
		
		BigDecimal userPrize=useAmout.subtract(useGift);//拟用奖金的额度
		userPrize = preWallet.getAblePrizeBalance().compareTo(userPrize)>=0?userPrize:preWallet.getAblePrizeBalance();//实用奖金
		
		BigDecimal useCash = useAmout.subtract(useGift).subtract(userPrize);//用现金的额度
		useCash = preWallet.getAbleCashBalance().compareTo(useCash)>=0?useCash:preWallet.getAbleCashBalance();//实用奖金
		
		//收益金额
		BigDecimal useIncome = useAmout.subtract(useGift).subtract(userPrize).subtract(useCash);//用收益的额度
		if(useIncome.compareTo(BigDecimal.ZERO)<0){
			useIncome = BigDecimal.ZERO;
		}
		
		BigDecimal useDeposit = useCash.add(useIncome);
		
		if(TransType.getDirectePayList().contains(transType)){//直接支付的可以使用  冻结的Deposit
			useDeposit=useDeposit.compareTo(preWallet.getDeposit().add(preWallet.getFreezeDepositBalance()))>0?
					preWallet.getDeposit().add(preWallet.getFreezeDepositBalance()):useDeposit;
		}else{
			useDeposit=useDeposit.compareTo(preWallet.getDeposit())>0?preWallet.getDeposit():useDeposit;
		}
		WalletLogActualVo walletLogActualVo=this.buildWalletLogActualVo(useCash,useGift,userPrize,useIncome,useDeposit,transType);
		return walletLogActualVo;
	}
	
	/**
	 * 使用可用余额而且彩金优先
	 * 彩金 -》 现金 -》 收益 -》 奖金
	 * 算出这次扣款 需要用到 彩金多少、现金多少、收益奖金多少
	 * @return
	 */
	private WalletLogActualVo  buildActualVoForSubtractAbleBalanceAndGiftFirst(UsrWallet preWallet,BigDecimal useAmout,Integer transType){
		
		//先用彩金
		BigDecimal useGift=preWallet.getAbleGiftBalance().compareTo(useAmout)>=0?useAmout:preWallet.getAbleGiftBalance();
		if(useGift.compareTo(BigDecimal.ZERO)<0){
			useGift=BigDecimal.ZERO;
		}
		useGift = useGift.setScale(2, RoundingMode.DOWN);
		//拟用现金
		BigDecimal useCash=useAmout.subtract(useGift);//拟用现金的额度
		//实用现金
		useCash = preWallet.getAbleCashBalance().compareTo(useCash)>=0?useCash:preWallet.getAbleCashBalance();//实用现金
		if(useCash.compareTo(BigDecimal.ZERO)<0){
			useCash = BigDecimal.ZERO;
		}
		useCash = useCash.setScale(2, RoundingMode.DOWN);
		
		//奖金额度
		BigDecimal userPrize = useAmout.subtract(useGift).subtract(useCash);//用奖金的额度
		userPrize=preWallet.getAblePrizeBalance().compareTo(userPrize)>=0?userPrize:preWallet.getAblePrizeBalance();
		if(userPrize.compareTo(BigDecimal.ZERO)<0){
			userPrize = BigDecimal.ZERO;
		}
		userPrize = userPrize.setScale(2, RoundingMode.DOWN);
		
		
		//拟用收益金额
		BigDecimal useIncome = useAmout.subtract(useGift).subtract(useCash).subtract(userPrize);//用收益的额度
		if(useIncome.compareTo(BigDecimal.ZERO)<0){
			useIncome = BigDecimal.ZERO;
		}
		useIncome = useIncome.setScale(2, RoundingMode.DOWN);
 
		
		BigDecimal useDeposit = useCash;	
		
		if(TransType.getDirectePayList().contains(transType)){//直接支付的可以使用  冻结的Deposit
			useDeposit=useDeposit.compareTo(preWallet.getDeposit().add(preWallet.getFreezeDepositBalance()))>0?
					preWallet.getDeposit().add(preWallet.getFreezeDepositBalance()):useDeposit;
		}else{
			useDeposit=useDeposit.compareTo(preWallet.getDeposit())>0?preWallet.getDeposit():useDeposit;
		}

		WalletLogActualVo walletLogActualVo = this.buildWalletLogActualVo(useCash, useGift,userPrize,useIncome,useDeposit,transType);
		
		return walletLogActualVo;
	}
	/**
	 * 使用可用余额而且奖金优先
	 *  奖金 -》  收益 -》 现金 -》 彩金 
	 * @return
	 */
	private WalletLogActualVo  buildActualVoForSubtractAbleBalanceAndPrizeFirst(UsrWallet preWallet,BigDecimal useAmout,Integer transType){
		
		//先用奖金
		BigDecimal usePrize = preWallet.getAblePrizeBalance().compareTo(useAmout)>=0?useAmout:preWallet.getAblePrizeBalance();
		if(usePrize.compareTo(BigDecimal.ZERO)<0){
			usePrize=BigDecimal.ZERO;
		}
		usePrize = usePrize.setScale(2, RoundingMode.DOWN);
	 
		//拟用收益金额
		BigDecimal useIncome =  useAmout.subtract(usePrize);
		useIncome=preWallet.getAbleIncomeBalance().compareTo(useIncome)>=0?useIncome:preWallet.getAbleIncomeBalance();
		if(useIncome.compareTo(BigDecimal.ZERO)<0){
			useIncome = BigDecimal.ZERO;
		}
		useIncome = useIncome.setScale(2, RoundingMode.DOWN);
				
				
		//拟用现金
		BigDecimal useCash = useAmout.subtract(usePrize).subtract(useIncome);//用收益的额度
		//实用现金
		useCash=preWallet.getAbleCashBalance().compareTo(useCash)>=0?useCash:preWallet.getAbleCashBalance();
		useCash = useCash.setScale(2, RoundingMode.DOWN);
		
			
		//彩金额度
		BigDecimal useGift = useAmout.subtract(useCash).subtract(usePrize).subtract(useIncome);

		BigDecimal useDeposit = useCash;
		if(TransType.getDirectePayList().contains(transType)){//直接支付的可以使用  冻结的Deposit
			useDeposit=useDeposit.compareTo(preWallet.getDeposit().add(preWallet.getFreezeDepositBalance()))>0?
					preWallet.getDeposit().add(preWallet.getFreezeDepositBalance()):useDeposit;
		}else{
			useDeposit=useDeposit.compareTo(preWallet.getDeposit())>0?preWallet.getDeposit():useDeposit;
		}
		if (TransType.FREEZE_TK.getIndex() == transType) {
			useDeposit = BigDecimal.ZERO;
		}
		WalletLogActualVo walletLogActualVo=this.buildWalletLogActualVo(useCash, useGift,usePrize,useIncome,useDeposit,transType);
		return walletLogActualVo;
	}
	
	/**
	 * 使用可用余额而且现金优先
	 *   现金 -》 收益 -》奖金 -》 彩金 
	 * @return
	 */
	private WalletLogActualVo  buildActualVoForSubtractAbleBalanceAndCashFirst(UsrWallet preWallet,BigDecimal useAmout,Integer transType){
		
		//先用现金
		BigDecimal useCash = preWallet.getAbleCashBalance().compareTo(useAmout)>=0?useAmout:preWallet.getAbleCashBalance();
		if(useCash.compareTo(BigDecimal.ZERO)<0){
			useCash=BigDecimal.ZERO;
		}
		useCash = useCash.setScale(2, RoundingMode.DOWN);

		//拟用收益金额
		BigDecimal useIncome = useAmout.subtract(useCash);//用收益的额度
		useIncome=preWallet.getAbleIncomeBalance().compareTo(useIncome)>=0?useIncome:preWallet.getAbleIncomeBalance();
		if(useIncome.compareTo(BigDecimal.ZERO)<0){
			useIncome = BigDecimal.ZERO;
		}
		useIncome = useIncome.setScale(2, RoundingMode.DOWN);	

		
		//拟用奖金
		BigDecimal usePrize = useAmout.subtract(useCash).subtract(useIncome) ;
		//实用奖金
		usePrize=preWallet.getAblePrizeBalance().compareTo(usePrize)>=0?usePrize:preWallet.getAblePrizeBalance();
		usePrize = usePrize.setScale(2, RoundingMode.DOWN);
		
		BigDecimal useGift = useAmout.subtract(useCash).subtract(usePrize).subtract(useIncome);
		
		BigDecimal useDeposit = useCash;
		if(TransType.getDirectePayList().contains(transType)){//直接支付的可以使用  冻结的Deposit
			useDeposit=useDeposit.compareTo(preWallet.getDeposit().add(preWallet.getFreezeDepositBalance()))>0?
					preWallet.getDeposit().add(preWallet.getFreezeDepositBalance()):useDeposit;
		}else{
			useDeposit=useDeposit.compareTo(preWallet.getDeposit())>0?preWallet.getDeposit():useDeposit;
		}
		
		WalletLogActualVo walletLogActualVo=this.buildWalletLogActualVo(useCash, useGift,usePrize,useIncome,useDeposit,transType);
		return walletLogActualVo;
	}
	
	/**
	 * 使用冻结余额奖金优先
	 *  奖金 -》现金 -》 收益 -》 彩金 
	 * @return
	 */
	private WalletLogActualVo  buildActualVoForSubtractFreezeBalanceAndPrizeFirst(UsrWallet preWallet,UsrWalletLog preWalletLog,
			UsrTransVo memberTransVo ){
		BigDecimal useAmout = memberTransVo.getAmount();
		Integer transType = memberTransVo.getTransType();
		if (preWalletLog.getAmount().compareTo(useAmout) < 0) {
			log.warn("会员[{}]执行交易[{}]时冻结余额不足,需要使用冻结余额[{}]元,订单剩余冻结余额[{}],业务id:{}", new Object[] { preWallet.getAccount(),
					transType, useAmout.toPlainString(), preWalletLog.getAmount().toPlainString(), memberTransVo.getTransOrderId() });
			throw new WalletException(WalletErrorTable.ILLEGAL_TRANS_AMOUNT);
		}
		//先用奖金
		BigDecimal usePrize=preWalletLog.getPrizeAmount().compareTo(useAmout)>=0?useAmout:preWalletLog.getPrizeAmount();
		if(usePrize.compareTo(BigDecimal.ZERO)<0){
			usePrize=BigDecimal.ZERO;
		}
		usePrize = usePrize.setScale(2, RoundingMode.DOWN);
		//拟用现金
		BigDecimal useCash=useAmout.subtract(usePrize);
		//实用现金
		useCash = preWalletLog.getCashAmount().compareTo(useCash)>=0?useCash: preWalletLog.getCashAmount();
		if(useCash.compareTo(BigDecimal.ZERO)<0){
			useCash=BigDecimal.ZERO;
		}
		useCash = useCash.setScale(2, RoundingMode.DOWN);
		
		//拟用收益金额
		BigDecimal useIncome = useAmout.subtract(useCash).subtract(usePrize);//用收益的额度
		//实用收益金额
		useIncome=preWalletLog.getIncomeAmount().compareTo(useIncome)>=0?useIncome:preWalletLog.getIncomeAmount();
		if(useIncome.compareTo(BigDecimal.ZERO)<0){
			useIncome = BigDecimal.ZERO;
		}
		useIncome = useIncome.setScale(2, RoundingMode.DOWN);	

		//最后用彩金
		BigDecimal useGift = useAmout.subtract(useCash).subtract(usePrize).subtract(useIncome);
		
		//因为上线的时候,上线前的某笔业务可能先把这笔业务的冻结彩金用掉了,只是在钱包流水改造的上线的一段时间个别用户会发生这种情况
		if(useGift.compareTo(preWallet.getFreezeGiftBalance())>0 || useCash.compareTo(preWallet.getFreezeCashBalance())>0 ||
				usePrize.compareTo(preWallet.getFreezePrizeBalance())>0){
			usePrize=preWallet.getFreezePrizeBalance().compareTo(useAmout)>=0?useAmout:preWallet.getFreezePrizeBalance();
			useCash=useAmout.subtract(usePrize);
			useCash=preWallet.getFreezeCashBalance().compareTo(useCash)>=0?useCash:preWallet.getFreezeCashBalance();
			useGift = useAmout.subtract(useCash).subtract(usePrize);
			log.warn("会员[{}][{}]在使用冻结金额时冻结彩金和现金有串单现象,order id [{}]", 
					new Object[] { preWallet.getAccount(),transType,memberTransVo.getTransOrderId()});
		}
		
		BigDecimal useDeposit=useCash;
		if(TransType.getUnFreezeList().contains(transType)){
			useDeposit=useDeposit.compareTo(preWalletLog.getDeposit())>0?preWalletLog.getDeposit():useDeposit;
			//因为代购可以用FreezeDepositBalance, 有可能冻结的FreezeDepositBalance被代购给用了
			useDeposit= useDeposit.compareTo(preWallet.getFreezeDepositBalance())>0?preWallet.getFreezeDepositBalance():useDeposit;
			useDeposit=useDeposit.compareTo(BigDecimal.ZERO)>0?useDeposit:BigDecimal.ZERO;
		}else{//转支付,可以用别的流水冻结的Deposit，转支付还可以用可用的Deposit
			useDeposit= useDeposit.compareTo(preWallet.getFreezeDepositBalance().add(preWallet.getDeposit()))>0?
						preWallet.getFreezeDepositBalance().add(preWallet.getDeposit()):useDeposit;
		}
		
		WalletLogActualVo walletLogActualVo=this.buildWalletLogActualVo(useCash, useGift,usePrize,useIncome,useDeposit, transType);
		return walletLogActualVo;
	}
	
	/**
	 * 使用冻结余额而且彩金优先
	 * 彩金  -》现金 -》 收益  -》   奖金
	 * @return
	 */
	private WalletLogActualVo  buildActualVoForSubtractFreezeBalanceAndGiftFirst(UsrWallet preWallet,
			UsrWalletLog preWalletLog,UsrTransVo memberTransVo){
		BigDecimal useAmout = memberTransVo.getAmount();
		Integer transType = memberTransVo.getTransType();
		if (preWalletLog.getAmount().compareTo(useAmout) < 0) {
			log.warn("会员[{}]执行交易[{}]时冻结余额不足,需要使用冻结余额[{}]元,订单剩余冻结余额[{}],业务id:{}", new Object[] { preWallet.getAccount(),
					transType, useAmout.toPlainString(), preWalletLog.getAmount().toPlainString(),memberTransVo.getTransOrderId() });
			throw new WalletException(WalletErrorTable.ILLEGAL_TRANS_AMOUNT);
		}
		//先用彩金
		BigDecimal useGift=preWalletLog.getGiftAmount().compareTo(useAmout)>=0?useAmout:preWalletLog.getGiftAmount();
		if(useGift.compareTo(BigDecimal.ZERO)<0){
			useGift=BigDecimal.ZERO;
		}
		useGift = useGift.setScale(2, RoundingMode.DOWN);
		//拟用现金
		BigDecimal useCash=useAmout.subtract(useGift);
		//实用现金
		useCash=preWalletLog.getCashAmount().compareTo(useCash)>=0?useCash:preWalletLog.getCashAmount();
		if(useCash.compareTo(BigDecimal.ZERO)<0){
			useCash=BigDecimal.ZERO;
		}
		useCash = useCash.setScale(2, RoundingMode.DOWN);
 
		//拟用收益金额
		BigDecimal useIncome = useAmout.subtract(useGift).subtract(useCash);//用收益的额度
		//实用收益金额
		useIncome=preWalletLog.getIncomeAmount().compareTo(useIncome)>=0?useIncome:preWalletLog.getIncomeAmount();
		if(useIncome.compareTo(BigDecimal.ZERO)<0){
			useIncome = BigDecimal.ZERO;
		}
		useIncome = useIncome.setScale(2, RoundingMode.DOWN);	
 
		// 奖金
		BigDecimal usePrize = useAmout.subtract(useCash).subtract(useGift).subtract(useIncome);
		
		//因为上线的时候,上线前的某笔业务可能先把这笔业务的冻结彩金用掉了,只是在钱包流水改造的上线的一段时间个别用户会发生这种情况
		if(useGift.compareTo(preWallet.getFreezeGiftBalance())>0 || useCash.compareTo(preWallet.getFreezeCashBalance())>0 ||
				usePrize.compareTo(preWallet.getFreezePrizeBalance())>0){
			useGift=preWallet.getFreezeGiftBalance().compareTo(useAmout)>=0?useAmout:preWallet.getFreezeGiftBalance();
			useCash=useAmout.subtract(useGift);
			useCash=preWallet.getFreezeCashBalance().compareTo(useCash)>=0?useCash:preWallet.getFreezeCashBalance();
			usePrize = useAmout.subtract(useCash).subtract(useGift);
			log.warn("会员[{}][{}]在使用冻结金额时冻结彩金和现金有串单现象,log id [{}]", 
					new Object[] { preWallet.getAccount(),transType,memberTransVo.getTransOrderId()});
		}
		
		BigDecimal useDeposit=useCash;
		if(TransType.getUnFreezeList().contains(transType)){
			useDeposit=useDeposit.compareTo(preWalletLog.getDeposit())>0?preWalletLog.getDeposit():useDeposit;
			//因为代购可以用FreezeDepositBalance, 有可能冻结的FreezeDepositBalance被代购给用了
			useDeposit= useDeposit.compareTo(preWallet.getFreezeDepositBalance())>0?preWallet.getFreezeDepositBalance():useDeposit;
			useDeposit=useDeposit.compareTo(BigDecimal.ZERO)>0?useDeposit:BigDecimal.ZERO;
		}else{//转支付,可以用别的流水冻结的Deposit，转支付还可以用可用的Deposit
			useDeposit= useDeposit.compareTo(preWallet.getFreezeDepositBalance().add(preWallet.getDeposit()))>0?
						preWallet.getFreezeDepositBalance().add(preWallet.getDeposit()):useDeposit;
		}
		
		WalletLogActualVo walletLogActualVo=this.buildWalletLogActualVo(useCash, useGift,usePrize,useIncome,useDeposit, transType);
		return walletLogActualVo;
	}
	
    
    /**
     * 构造发生额Vo(使用冻结余额)
     * 用于解冻 或  冻结转支付
     * @return
     */
    public WalletLogActualVo buildLogActualVoForSubtractFreezeBalance(int firstOption,UsrTransVo memberTransVo,
    		UsrWallet preWallet,UsrPayOrderVo usrPayOrderVo){
    	WalletLogActualVo walletLogActualVo=new WalletLogActualVo();
    	Integer transType = memberTransVo.getTransType();
  
		//使用冻结
		if(TransType.getUnFreezeList().contains(transType)|| TransType.getTransferPayList().contains(transType)){
//			//因为现在有的用户冻结里面还有负数,暂时允许amount> preWallet.getFreezeAmount()
			if (preWallet.getFreezeAmount().compareTo(memberTransVo.getAmount()) < 0) {
				log.warn("会员[{}]执行交易[{}]时钱包冻结余额不足,需要使用冻结余额[{}]元,钱包[{}],业务id:{}", new Object[] { preWallet.getAccount(),
						transType, memberTransVo.getAmount().toPlainString(), preWallet.getFreezeAmount().toPlainString(), memberTransVo.getTransOrderId()});
				throw new WalletException(WalletErrorTable.NOT_SUFFICIENT_FUNDS);
			}
			if(firstOption == UsrWalletHandle.subtractGiftFirst){
				walletLogActualVo =  this.buildActualVoForSubtractFreezeBalanceAndGiftFirst(preWallet,memberTransVo.getAmount(), 
						usrPayOrderVo,transType);
			}else if(firstOption == UsrWalletHandle.subtractPrizeFirst){
				walletLogActualVo =  this.buildActualVoForSubtractFreezeBalanceAndPrizeFirst(preWallet,memberTransVo.getAmount(), 
						usrPayOrderVo,transType);
			}else{
				throw new WalletException(WalletErrorTable.ILLEGAL_First_OPTION);
			}
			
			return walletLogActualVo;
		}
		throw new WalletException(WalletErrorTable.ILLEGAL_RELATE_TRANS);
		
    }
	
	/**
	 * 使用冻结余额奖金优先
	 * @return
	 */
	private WalletLogActualVo  buildActualVoForSubtractFreezeBalanceAndPrizeFirst(UsrWallet preWallet,BigDecimal useAmout,
			UsrPayOrderVo preWalletOrder,int transType){
		
		if (preWalletOrder.getFreezeWalletAmount().compareTo(useAmout) < 0) {
			log.warn("会员[{}]执行交易[{}]时冻结余额不足,需要使用冻结余额[{}]元,订单剩余冻结余额[{}],业务id:{}", new Object[] { preWallet.getAccount(),
					transType, useAmout.toPlainString(), preWalletOrder.getFreezeWalletAmount().toPlainString(), preWalletOrder.getOutOrderId() });
			throw new WalletException(WalletErrorTable.ILLEGAL_TRANS_AMOUNT);
		}
 
		//实用收益金额
		BigDecimal useIncome=preWalletOrder.getFreezeIncomeAmount().compareTo(useAmout)>=0?useAmout:preWalletOrder.getFreezeIncomeAmount();
		if(useIncome.compareTo(BigDecimal.ZERO)<0){
			useIncome = BigDecimal.ZERO;
		}
		useIncome = useIncome.setScale(2, RoundingMode.DOWN);
		//拟用彩金
		BigDecimal usePrize=useAmout.subtract(useIncome);
		//先用奖金
		usePrize=preWalletOrder.getFreezePrizeAmount().compareTo(usePrize)>=0?usePrize:preWalletOrder.getFreezePrizeAmount();
		if(usePrize.compareTo(BigDecimal.ZERO)<0){
			usePrize=BigDecimal.ZERO;
		}
		usePrize = usePrize.setScale(2, RoundingMode.DOWN);
		
		//拟用现金
		BigDecimal useCash=useAmout.subtract(usePrize).subtract(useIncome);
		//实用现金
		useCash=preWalletOrder.getFreezeCashAmount().compareTo(useCash)>=0?useCash:preWalletOrder.getFreezeCashAmount();
		if(useCash.compareTo(BigDecimal.ZERO)<0){
			useCash=BigDecimal.ZERO;
		}
		useCash = useCash.setScale(2, RoundingMode.DOWN);
		//最后用彩金11
		BigDecimal useGift = useAmout.subtract(useCash).subtract(usePrize).subtract(useIncome);
		
		
		BigDecimal useDeposit=useCash;
		if(TransType.getUnFreezeList().contains(transType)){
			useDeposit=useDeposit.compareTo(preWalletOrder.getFreezeDeposit())>0?preWalletOrder.getFreezeDeposit():useDeposit;
			//因为代购可以用FreezeDepositBalance, 有可能冻结的FreezeDepositBalance被代购给用了
			useDeposit= useDeposit.compareTo(preWallet.getFreezeDepositBalance())>0?preWallet.getFreezeDepositBalance():useDeposit;
			useDeposit=useDeposit.compareTo(BigDecimal.ZERO)>0?useDeposit:BigDecimal.ZERO;
		}else{//转支付,可以用别的流水冻结的Deposit，转支付还可以用可用的Deposit
			useDeposit= useDeposit.compareTo(preWallet.getFreezeDepositBalance().add(preWallet.getDeposit()))>0?
						preWallet.getFreezeDepositBalance().add(preWallet.getDeposit()):useDeposit;
		}
		WalletLogActualVo walletLogActualVo=this.buildWalletLogActualVo(useCash, useGift,usePrize,useIncome,useDeposit, transType);
		return walletLogActualVo;
	}
	 
	 
	/**
	 * 使用冻结余额而且彩金优先
	 * @return
	 */
	private WalletLogActualVo  buildActualVoForSubtractFreezeBalanceAndGiftFirst(UsrWallet preWallet,BigDecimal useAmout,
			UsrPayOrderVo preWalletOrder,int transType){
		
		if (preWalletOrder.getFreezeWalletAmount().compareTo(useAmout) < 0) {
			log.warn("会员[{}]执行交易[{}]时冻结余额不足,需要使用冻结余额[{}]元,订单剩余冻结余额[{}],业务id:{}", new Object[] { preWallet.getAccount(),
					transType, useAmout.toPlainString(), preWalletOrder.getFreezeWalletAmount().toPlainString(), preWalletOrder.getOutOrderId() });
			throw new WalletException(WalletErrorTable.ILLEGAL_TRANS_AMOUNT);
		}
		//先用彩金
		BigDecimal useGift=preWalletOrder.getFreezeGiftAmount().compareTo(useAmout)>=0?useAmout:preWalletOrder.getFreezeGiftAmount();
		if(useGift.compareTo(BigDecimal.ZERO)<0){
			useGift=BigDecimal.ZERO;
		}
		useGift = useGift.setScale(2, RoundingMode.DOWN);
		
		//拟用现金
		BigDecimal useCash=useAmout.subtract(useGift);
		//实用现金
		useCash=preWalletOrder.getFreezeCashAmount().compareTo(useCash)>=0?useCash:preWalletOrder.getFreezeCashAmount();
		if(useCash.compareTo(BigDecimal.ZERO)<0){
			useCash=BigDecimal.ZERO;
		}
		useCash = useCash.setScale(2, RoundingMode.DOWN);
		BigDecimal useDeposit=useCash;
		
		// 奖金
		BigDecimal usePrize = useAmout.subtract(useCash).subtract(useGift);
		//实用收益金额
		usePrize=preWalletOrder.getFreezePrizeAmount().compareTo(usePrize)>=0?usePrize:preWalletOrder.getFreezePrizeAmount();
		if(usePrize.compareTo(BigDecimal.ZERO)<0){
			usePrize = BigDecimal.ZERO;
		}
		usePrize = usePrize.setScale(2, RoundingMode.DOWN);	
		
		//拟用收益金额
		BigDecimal useIncome = useAmout.subtract(useGift).subtract(useCash).subtract(usePrize);//用收益的额度
		//实用收益金额
		useIncome=preWalletOrder.getFreezeIncomeAmount().compareTo(useIncome)>=0?useIncome:preWalletOrder.getFreezeIncomeAmount();
		if(useIncome.compareTo(BigDecimal.ZERO)<0){
			useIncome = BigDecimal.ZERO;
		}
		useIncome = useIncome.setScale(2, RoundingMode.DOWN);	
		
		
		if(TransType.getUnFreezeList().contains(transType)){
			useDeposit=useDeposit.compareTo(preWalletOrder.getFreezeDeposit())>0?preWalletOrder.getFreezeDeposit():useDeposit;
			//因为代购可以用FreezeDepositBalance, 有可能冻结的FreezeDepositBalance被代购给用了
			useDeposit= useDeposit.compareTo(preWallet.getFreezeDepositBalance())>0?preWallet.getFreezeDepositBalance():useDeposit;
			useDeposit=useDeposit.compareTo(BigDecimal.ZERO)>0?useDeposit:BigDecimal.ZERO;
		}else{//转支付,可以用别的流水冻结的Deposit，转支付还可以用可用的Deposit
			useDeposit= useDeposit.compareTo(preWallet.getFreezeDepositBalance().add(preWallet.getDeposit()))>0?
						preWallet.getFreezeDepositBalance().add(preWallet.getDeposit()):useDeposit;
		}
		
		WalletLogActualVo walletLogActualVo=this.buildWalletLogActualVo(useCash, useGift,usePrize,useIncome,useDeposit,transType);
		return walletLogActualVo;
	}
	
	
	/**
	 * 收益
	 * @param w
	 * @param vo
	 * @return
	 */
	private UsrWallet income(UsrWallet w,WalletLogActualVo vo){
		w.setAbleIncomeBalance(w.getAbleIncomeBalance().add(vo.getIncome()));
		w.setHeapIncome(w.getHeapIncome().add(vo.getIncome()));
		return w;
	}
	
	/**
	 * 充值只是改变现金,和Deposit
	 * @param w
	 * @param vo
	 * @return
	 */
	private UsrWallet charge(UsrWallet w,WalletLogActualVo vo){
		w.setDeposit(w.getDeposit().add(vo.getDeposit())); 
		w.setAbleCashBalance(w.getAbleCashBalance().add(vo.getCash()));
		return w;
	}
	
	/**
     * 只加现金(不要处理deposit,不要处理历史奖金,历史彩金,历史消费金额)
     * @param cash
     * @param gift
     * @create_time 2010-12-3 下午04:06:20
     */
	private UsrWallet addCash(UsrWallet w,WalletLogActualVo vo) {
    	w.setAbleCashBalance(w.getAbleCashBalance().add(vo.getCash()));
    	w.setDeposit(w.getDeposit().add(vo.getDeposit())); //Deposit可能变化
    	w.setHeapPrize(w.getHeapPrize().add(vo.getHeapPrize()));//历史派奖可能变化
    	return  w;
    }
	/**
     * 加奖金(不要处理deposit,要处理历史奖金)
     * @param cash
     * @param gift
     * @create_time 2010-12-3 下午04:06:20
     */
	private UsrWallet addPrize(UsrWallet w,WalletLogActualVo vo) {
    	w.setAblePrizeBalance(w.getAblePrizeBalance().add(vo.getPrize()));
    	w.setHeapPrize(w.getHeapPrize().add(vo.getHeapPrize()));//历史派奖可能变化
    	return  w;
    }
	
	/**
     * 冻结
     * @param cash
     * @param gift
     * @create_time 2010-12-3 下午04:06:20
     */
	private UsrWallet freeze(UsrWallet w,WalletLogActualVo vo) {
    	w.setAbleCashBalance(w.getAbleCashBalance().subtract(vo.getCash()));
    	w.setAbleGiftBalance(w.getAbleGiftBalance().subtract(vo.getGift()));
    	w.setAblePrizeBalance(w.getAblePrizeBalance().subtract(vo.getPrize()));
    	w.setAbleIncomeBalance(w.getAbleIncomeBalance().subtract(vo.getIncome()));
    	
    	w.setFreezeCashBalance(w.getFreezeCashBalance().add(vo.getCash()));
    	w.setFreezeGiftBalance(w.getFreezeGiftBalance().add(vo.getGift()));
    	w.setFreezePrizeBalance(w.getFreezePrizeBalance().add(vo.getPrize()));
    	w.setFreezeIncomeBalance(w.getFreezeIncomeBalance().add(vo.getIncome()));
    	
    	BigDecimal userDeposit =w.getDeposit().compareTo(vo.getDeposit()) <= 0 ? w.getDeposit(): vo.getDeposit(); //钱包里的必须消费金额要减少
    
        w.setDeposit( w.getDeposit().subtract(userDeposit));//
        w.setFreezeDepositBalance(w.getFreezeDepositBalance().add(userDeposit));
        
    	return  w;
    }
    /**
     * 解冻(是freeze的反操作)
     * @param cash
     * @param gift
     * @create_time 2010-12-3 下午04:00:02
     */
    private UsrWallet unfreeze(UsrWallet w,WalletLogActualVo actualVo) {
    	w.setFreezeCashBalance(w.getFreezeCashBalance().subtract(actualVo.getCash()));
    	w.setFreezeGiftBalance(w.getFreezeGiftBalance().subtract(actualVo.getGift()));
    	w.setFreezePrizeBalance(w.getFreezePrizeBalance().subtract(actualVo.getPrize()));
    	w.setFreezeIncomeBalance(w.getFreezeIncomeBalance().subtract(actualVo.getIncome()));
    	
    	w.setAbleCashBalance(w.getAbleCashBalance().add(actualVo.getCash()));
    	w.setAbleGiftBalance(w.getAbleGiftBalance().add(actualVo.getGift()));
    	w.setAblePrizeBalance(w.getAblePrizeBalance().add(actualVo.getPrize()));
    	w.setAbleIncomeBalance(w.getAbleIncomeBalance().add(actualVo.getIncome()));
    	
    	w.setFreezeDepositBalance(w.getFreezeDepositBalance().subtract(actualVo.getDeposit()));
    	BigDecimal deposit = w.getDeposit().add(actualVo.getDeposit()); //钱包里的必须消费金额要+
        w.setDeposit(deposit);
        
        return w;
    }
    
    /**
     * 转支付(冻结转消费,不需要处理deposit)
     * @param cash
     * @param gift
     * @create_time 2010-12-3 下午04:03:47
     */
    private UsrWallet transferPay(UsrWallet w,WalletLogActualVo actualVo) {
    	 w.setFreezeCashBalance(w.getFreezeCashBalance().subtract(actualVo.getCash()));
     	 w.setFreezeGiftBalance(w.getFreezeGiftBalance().subtract(actualVo.getGift()));
     	 w.setFreezePrizeBalance(w.getFreezePrizeBalance().subtract(actualVo.getPrize()));
     	 w.setFreezeIncomeBalance(w.getFreezeIncomeBalance().subtract(actualVo.getIncome()));
     	 
     	BigDecimal useFreezeDeposit=w.getFreezeDepositBalance().compareTo(actualVo.getDeposit())>0?actualVo.getDeposit():w.getFreezeDepositBalance();
     	w.setFreezeDepositBalance(w.getFreezeDepositBalance().subtract(useFreezeDeposit));
     	//转支付还可以用可用的deposit
     	BigDecimal useDeposit=actualVo.getDeposit().subtract(useFreezeDeposit);
     	w.setDeposit(w.getDeposit().subtract(useDeposit));
        w.setHeapBalance(w.getHeapBalance().add(actualVo.getHeapBalance()));
        return w;
    }
    
    
    /**
     * 支付(没有冻结这步)
     * @param cash
     * @param gift
     * @create_time 2010-12-3 下午04:06:20
     */
    private UsrWallet directPay(UsrWallet w,WalletLogActualVo actualVo) {
    	
        w.setAbleCashBalance(w.getAbleCashBalance().subtract(actualVo.getCash()));
    	w.setAbleGiftBalance(w.getAbleGiftBalance().subtract(actualVo.getGift()));
    	w.setAblePrizeBalance(w.getAblePrizeBalance().subtract(actualVo.getPrize()));
    	w.setAbleIncomeBalance(w.getAbleIncomeBalance().subtract(actualVo.getIncome()));
    	
        w.setHeapBalance(w.getHeapBalance().add(actualVo.getHeapBalance()));
        //钱包里的必须消费金额要减少
        BigDecimal userDeposit=w.getDeposit().compareTo(actualVo.getDeposit()) <= 0 ? w.getDeposit():actualVo.getDeposit();
        //直接支付的可以用冻结的Deposit.
        BigDecimal userFreezeDeposit=actualVo.getDeposit().subtract(userDeposit);
        userFreezeDeposit=w.getFreezeDepositBalance().compareTo(userFreezeDeposit)<=0?w.getFreezeDepositBalance():userFreezeDeposit;
        w.setDeposit(w.getDeposit().subtract(userDeposit));
        w.setFreezeDepositBalance(w.getFreezeDepositBalance().subtract(userFreezeDeposit));
        
        //扣回彩金,是一种异常处理,这种扣回不是用户消费,所以不会正规的减掉Deposit;然而减掉Deposit,有可能会造成ableCashBalance比deposit 
        //还少得情况;比如扣回彩金的时候,彩金被用户用掉了,奖金也被异常扣款先扣了,那么就要去要去扣ableCashBalance;
        //这个时候我们要求纠正deposit.
        if( w.getDeposit().compareTo(w.getAbleCashBalance())>0){
        	w.setDeposit(w.getAbleCashBalance());
        }
        return w;
    }
    
    /**
     * 退款(是directPay反操作),或冻结转支付后退款
     * @param amount 退款金额(包括彩金和资金)
     * @param gift
     * @create_time 2011-3-3 下午03:43:17
     */
    private UsrWallet refound(UsrWallet w ,WalletLogActualVo actualVo ) {
       
        w.setAbleCashBalance(w.getAbleCashBalance().add(actualVo.getCash()));
    	w.setAbleGiftBalance(w.getAbleGiftBalance().add(actualVo.getGift()));
    	w.setAblePrizeBalance(w.getAblePrizeBalance().add(actualVo.getPrize()));
    	w.setAbleIncomeBalance(w.getAbleIncomeBalance().add(actualVo.getIncome()));
    	
        w.setHeapBalance(w.getHeapBalance().subtract(actualVo.getHeapBalance()));
        
        w.setDeposit(w.getDeposit().add(actualVo.getDeposit()));
        return w;
    }
    
    
    private UsrWalletLog buildWalletLog(UsrWallet afterWallet,  WalletLogActualVo actualVo,
    		Integer transType, Long logId,String logNo, Long relateId,Integer gameId, String issueNo, String planNo,Long payOrderId,
    		Integer sellClient,String remark) {
    	
		UsrWalletLog walletLog = new UsrWalletLog("", transType, logId, afterWallet.getUserId(), afterWallet.getAccount(),afterWallet.getUserType(),
				actualVo.getCash(),               actualVo.getGift(),                  actualVo.getPrize(),               actualVo.getIncome(),
				afterWallet.getAbleCashBalance(),afterWallet.getAbleGiftBalance(),afterWallet.getAblePrizeBalance(),afterWallet.getAbleIncomeBalance(),
				afterWallet.getFreezeCashBalance(),afterWallet.getFreezeGiftBalance(),afterWallet.getFreezePrizeBalance(),afterWallet.getFreezeIncomeBalance());
		
		if(afterWallet.getAbleCashBalance().compareTo(BigDecimal.ZERO)<0 || 
				afterWallet.getAbleGiftBalance().compareTo(BigDecimal.ZERO)<0||
				afterWallet.getAblePrizeBalance().compareTo(BigDecimal.ZERO)<0||
				afterWallet.getAbleIncomeBalance().compareTo(BigDecimal.ZERO)<0  ){
			throw new WalletException(WalletErrorTable.NOT_SUFFICIENT_FUNDS);
		}
		//NOT_SUFFICIENT_FUNDS
		//walletLog.addFlagBit(UsrWalletLogFlagBitConstants.version1305);//改造后的版本
		walletLog.setSellClient(sellClient);
		walletLog.setFreezeDepositBalance(afterWallet.getFreezeDepositBalance());//发生后的Deposit冻结余额
		walletLog.setDeposit(actualVo.getDeposit());//发生额度
		walletLog.setDepositBalance(afterWallet.getDeposit());//发生后的Deposit
		//walletLog.setId(id); // 手动设置id，同时以id生成业务编号
//		String wno = codeCreator.getWalletLogNo(afterWallet.getUserType());
		//钱包流水编号
//		walletLog.setWalletLogNo(wno);
		walletLog.setGameId(gameId);
		walletLog.setIssueNo(issueNo);
		walletLog.setPlanNo(planNo);
		walletLog.setWalletOrderId(payOrderId);
		walletLog.setRelateId(relateId);
		walletLog.setAfterUsrWallet(afterWallet);
		walletLog.setRemark(remark);
		walletLog.setLogNo(logNo);
		walletLog.setVerifyMd5(walletLog.encodeFiled());
		String transInfo = actualVo.getTransInfo();
		if(transInfo!=null && transInfo.length()>0){
			if(transInfo.length()>100){
				transInfo = transInfo.substring(0, 100);
			}
			walletLog.setupFeature("transInfo", transInfo);
		}
		return walletLog;
	}
    
}

package domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class WalletLogActualVo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private BigDecimal cash=BigDecimal.ZERO;//现金
	private BigDecimal gift=BigDecimal.ZERO;//彩金
	private BigDecimal prize=BigDecimal.ZERO;//奖金
	private BigDecimal income=BigDecimal.ZERO;//收益
	
    /** 必须消费最低金额的发生额 */
    private BigDecimal deposit = BigDecimal.ZERO;
    
    /** 历史总消费金额的发生额 */
    private BigDecimal heapBalance = BigDecimal.ZERO;

    /** 历史总中奖金额 的发生额*/

    private BigDecimal heapPrize = BigDecimal.ZERO;

    /** 历史总彩金 的发生额*/
    private BigDecimal heapGift = BigDecimal.ZERO;
    /** 历史总收益 的发生额*/
    private BigDecimal heapIncome = BigDecimal.ZERO;
    
	/***
	 * true 代表有新浪划转流水
	 * 钱包流水标记是否有新浪划转,参数  
	 */
	private boolean isPreSinaMoneyTransfer=false;
	
	/***
	 * 交易方式等信息，例如（支付宝、微信支付、银行卡1234）
	 */
	private String transInfo;//交易方式等信息
    
    public BigDecimal getAmount(){
    	return cash.add(gift).add(prize).add(income);
    }
    
	public BigDecimal getCash() {
		return cash;
	}

	public void setCash(BigDecimal cash) {
		this.cash = cash;
	}

	public BigDecimal getGift() {
		return gift;
	}

	public void setGift(BigDecimal gift) {
		this.gift = gift;
	}

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public BigDecimal getHeapBalance() {
		return heapBalance;
	}

	public void setHeapBalance(BigDecimal heapBalance) {
		this.heapBalance = heapBalance;
	}

	public BigDecimal getHeapPrize() {
		return heapPrize;
	}

	public void setHeapPrize(BigDecimal heapPrize) {
		this.heapPrize = heapPrize;
	}

	public BigDecimal getHeapGift() {
		return heapGift;
	}

	public void setHeapGift(BigDecimal heapGift) {
		this.heapGift = heapGift;
	}

	public BigDecimal getPrize() {
		return prize;
	}

	public void setPrize(BigDecimal prize) {
		this.prize = prize;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public BigDecimal getHeapIncome() {
		return heapIncome;
	}

	public void setHeapIncome(BigDecimal heapIncome) {
		this.heapIncome = heapIncome;
	}

	public boolean isPreSinaMoneyTransfer() {
		return isPreSinaMoneyTransfer;
	}

	public void setPreSinaMoneyTransfer(boolean isPreSinaMoneyTransfer) {
		this.isPreSinaMoneyTransfer = isPreSinaMoneyTransfer;
	}

	public String getTransInfo() {
		return transInfo;
	}

	public void setTransInfo(String transInfo) {
		this.transInfo = transInfo;
	}
	
	
}

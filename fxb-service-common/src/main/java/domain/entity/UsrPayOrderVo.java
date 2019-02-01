package domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class UsrPayOrderVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 业务类型UsrPayLogOrderType    (out_order_TYPE    , out_order_ID  )建唯一索引              
	 */
	private Integer outOrderType;
	/**
	 *   每笔交易id,如追号则对应追号id
	 */
	private Long outOrderId;
	private String outOrderNo;
 

	/**
	 * 已冻结的奖金
	 */
	private BigDecimal freezePrizeAmount=BigDecimal.ZERO;
	/**
	 * 已冻结的收益
	 */
	private BigDecimal freezeIncomeAmount=BigDecimal.ZERO;
	/**
	 * 已冻结的 deposit
	 */
	private BigDecimal freezeDeposit=BigDecimal.ZERO;
	/**
	 * 冻结彩金
	 */
	private BigDecimal freezeGiftAmount=BigDecimal.ZERO;
	/**
	 * 冻结现金
	 */
	private BigDecimal freezeCashAmount=BigDecimal.ZERO;
	
	
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
	
	
 
	public BigDecimal getFreezePrizeAmount() {
		return freezePrizeAmount;
	}
	public void setFreezePrizeAmount(BigDecimal freezePrizeAmount) {
		this.freezePrizeAmount = freezePrizeAmount;
	}
	public BigDecimal getFreezeIncomeAmount() {
		return freezeIncomeAmount;
	}
	public void setFreezeIncomeAmount(BigDecimal freezeIncomeAmount) {
		this.freezeIncomeAmount = freezeIncomeAmount;
	}
	public BigDecimal getFreezeDeposit() {
		return freezeDeposit;
	}
	public void setFreezeDeposit(BigDecimal freezeDeposit) {
		this.freezeDeposit = freezeDeposit;
	}
	public BigDecimal getFreezeGiftAmount() {
		return freezeGiftAmount;
	}
	public void setFreezeGiftAmount(BigDecimal freezeGiftAmount) {
		this.freezeGiftAmount = freezeGiftAmount;
	}
	public BigDecimal getFreezeCashAmount() {
		return freezeCashAmount;
	}
	public void setFreezeCashAmount(BigDecimal freezeCashAmount) {
		this.freezeCashAmount = freezeCashAmount;
	}

	
	public BigDecimal getFreezeWalletAmount() {
		return freezeCashAmount.add(freezeGiftAmount).add(this.freezePrizeAmount).add(this.freezeIncomeAmount);
	}
	
}

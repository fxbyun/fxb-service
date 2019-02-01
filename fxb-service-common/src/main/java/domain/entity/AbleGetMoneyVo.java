package domain.entity;
import java.io.Serializable;
import java.math.BigDecimal;

public class AbleGetMoneyVo implements Serializable{
	
	private static final long serialVersionUID = 2536476070716784938L;
	/****
	 * 可提款金额
	 */
	private BigDecimal ableGetMoney;
	/***
	 * 剩余彩金
	 */
	private BigDecimal ableGiftAmount;
	
	/***
	 * 转现金金额
	 */
	private BigDecimal conversionOfCash;
	
	/***
	 * 6-14-6-23 累计赠送彩金金额
	 */
	private BigDecimal sjbZsGiftAmount;
	
	
	public BigDecimal getAbleGetMoney() {
		return ableGetMoney;
	}
	public void setAbleGetMoney(BigDecimal ableGetMoney) {
		this.ableGetMoney = ableGetMoney;
	}
	public BigDecimal getAbleGiftAmount() {
		return ableGiftAmount;
	}
	public void setAbleGiftAmount(BigDecimal ableGiftAmount) {
		this.ableGiftAmount = ableGiftAmount;
	}
	public BigDecimal getConversionOfCash() {
		return conversionOfCash;
	}
	public void setConversionOfCash(BigDecimal conversionOfCash) {
		this.conversionOfCash = conversionOfCash;
	}
	public BigDecimal getSjbZsGiftAmount() {
		return sjbZsGiftAmount;
	}
	public void setSjbZsGiftAmount(BigDecimal sjbZsGiftAmount) {
		this.sjbZsGiftAmount = sjbZsGiftAmount;
	}
	
	
}

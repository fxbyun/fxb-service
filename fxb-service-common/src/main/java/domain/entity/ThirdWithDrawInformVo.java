package domain.entity;

import domain.type.PaymentWay;
import domain.type.WithdrawStatus;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 提款结果-异步通知VO
 * @author zl
 *
 */
public class ThirdWithDrawInformVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/***
	 * 代付成功 
	 */
	public static final String SUCCESS = "SUCCESS";
	/***
	 * 代付失败
	 */
	public static final String FAILURE = "FAILURE";
	/**
	 * 代付退款
	 */
	public static final String CANCEL = "CANCELLED";
	
	/***
     * 代付成功 
     */
    public static final String LD_SUCCESS = "4";
    
    /***
     * 代付失败
     */
    public static final String LD_FAILURE = "3";
    
    /***
     * 代付退款
     */
    public static final String LD_CANCEL = "18";	

	/**和对方关联号-（提现交易流水号）*/
	private long uniqueIdToOuter;
	
	/**商户交易号-（(可据此流水号去对方查询相关信息)）*/
	private String businessTradeNo;
	
	/****
	 * 支付结果代码
	 */
	private String resultPay;
	/****
	 * 交易金额
	 */	
	private BigDecimal amount;
	/**
	 * 错误码
	 */
	private String errorCode;
	/**
	 * 错误详情
	 */
	private String errorMsg;
	
	
    public boolean isSuccess(int paymentWay) {
        if((paymentWay == PaymentWay.ld_ys_pay && LD_SUCCESS.equals(resultPay))
                || (paymentWay == PaymentWay.lianlian_pay && SUCCESS.equals(resultPay))
                || (paymentWay == PaymentWay.sina_ph_pay && SUCCESS.equals(resultPay))
                || (paymentWay == PaymentWay.sina_weibo_h5 && SUCCESS.equals(resultPay))
				|| (paymentWay == PaymentWay.helipay_pay && SUCCESS.equals(resultPay))
				|| (paymentWay == PaymentWay.yop_pay_sdk && SUCCESS.equals(resultPay))
                ){
            return true;
        }
        return false;
    } 
    
    public boolean isFail(int paymentWay) {
        if((paymentWay == PaymentWay.ld_ys_pay && LD_FAILURE.equals(resultPay))
                || (paymentWay == PaymentWay.lianlian_pay && FAILURE.equals(resultPay))
                || (paymentWay == PaymentWay.sina_ph_pay && FAILURE.equals(resultPay))
                || (paymentWay == PaymentWay.sina_weibo_h5 && FAILURE.equals(resultPay))
				|| (paymentWay == PaymentWay.helipay_pay && FAILURE.equals(resultPay))
				|| (paymentWay == PaymentWay.yop_pay_sdk && FAILURE.equals(resultPay))
                ){
            return true;
        }
        return false;
    } 
    
    public boolean isCancel(int paymentWay) {
        if((paymentWay == PaymentWay.ld_ys_pay && LD_CANCEL.equals(resultPay))
                || (paymentWay == PaymentWay.lianlian_pay && CANCEL.equals(resultPay))
                || (paymentWay == PaymentWay.sina_ph_pay && CANCEL.equals(resultPay))
				|| (paymentWay == PaymentWay.helipay_pay && CANCEL.equals(resultPay))
				|| (paymentWay == PaymentWay.yop_pay_sdk && CANCEL.equals(resultPay))
				){
            return true;
        }
        return false;
    } 
    
	public String getResultPayDesc() {
		if(LD_SUCCESS.equals(resultPay ) || resultPay == SUCCESS){
			return "提款成功";
		}else if(LD_FAILURE.equals(resultPay) || resultPay == FAILURE){
			return "提款失败";
		}else if(LD_CANCEL.equals(resultPay) || resultPay == CANCEL){
			return "提款退票";
		}
		return resultPay;
	}
	
	public long getUniqueIdToOuter() {
	    return uniqueIdToOuter;
	}
	public void setUniqueIdToOuter(long uniqueIdToOuter) {
	    this.uniqueIdToOuter = uniqueIdToOuter;
	}
	public String getBusinessTradeNo() {
	    return businessTradeNo;
	}
	public void setBusinessTradeNo(String businessTradeNo) {
	    this.businessTradeNo = businessTradeNo;
	}
	
	public String getResultPay() {
		return resultPay;
	}
	public void setResultPay(String resultPay) {
		this.resultPay = resultPay;
	}
	
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorMsgByDBLength() {
		if(errorMsg!=null && errorMsg.length()>200){
			return errorMsg.substring(0, 200);
		}
		return errorMsg;
	}

	public static ThirdWithDrawInformVo valueOf(UsrWithDraw usrWithDraw){
		ThirdWithDrawInformVo thirdWithDrawInformVo = new ThirdWithDrawInformVo();
		thirdWithDrawInformVo.setAmount(usrWithDraw.getAmount());
		thirdWithDrawInformVo.setUniqueIdToOuter(usrWithDraw.getUniqueIdToOuter());
		thirdWithDrawInformVo.setBusinessTradeNo(usrWithDraw.getBusinessTradeNo());

		if(usrWithDraw.getWithdrawStatus() == WithdrawStatus.WD_FAIL.getIndex()){
			thirdWithDrawInformVo.setResultPay(ThirdWithDrawInformVo.FAILURE);
		}
		if(usrWithDraw.getWithdrawStatus() == WithdrawStatus.WD_SUCCESS.getIndex()){
			thirdWithDrawInformVo.setResultPay(ThirdWithDrawInformVo.SUCCESS);
		}
		return thirdWithDrawInformVo;
	}
}

package domain.type;

import com.alibaba.fastjson.JSONObject;
/**
 * 充值提款支付方式
 * @author zl
 *
 */
public class PaymentWay {

	/** 新浪支付 */
	public static int sina_pay  = 1;

	/** 连连支付 */
    public static int lianlian_pay  = 2;

	/** 微信支付-梓微兴-微信SDK支付 */
    public static int wx_pay  = 3;

    /** 微信支付-梓微兴-微信H5支付 */
    public static int wx_h5_pay  = 4;

    /** 微信支付-威富通-微信SDK支付 */
    public static int wx_wft_pay  = 5;

    /** 新浪银联支付 */
    public static int sina_yl_pay  = 6;

    /** 支付宝支付-数通威富通支付宝扫码支付 */
    public static int ali_st_pay  = 7;

    /** 支付宝支付-兴业威富通支付宝扫码支付 */
    public static int ali_xy_pay  = 8;

    /** 联动优势支付  */
    public static int ld_ys_pay  = 9;

    /** 微付客-微信H5支付  */
    public static int wx_wft_h5_pay  = 10;
    
    /** 新浪普惠支付 */
    public static int sina_ph_pay = 11;
    
    /*** 威富通微信H5支付 */
	public static int wft_wx_h5_pay = 12;
	
	/*** 优络-微信H5支付 */
	public static int ulo_weixin_h5 = 13;
	
	/*** 新浪微博H5支付 */
	public static int sina_weibo_h5 = 14;

    /** 番茄-微信H5支付  */
    public static int tomato_ali_h5_pay  = 15;
	/** 合利宝-支付  */
	public static int helipay_pay  = 16;
	/** 优络-微信小程序支付  */
	public static int ulo_weixin_small_app  = 17;
	/**易宝支付-内置sdk  */
	public static int yop_pay_sdk  = 18;
	/** 京东支付 */
	public static int jd_pay = 19 ;

}

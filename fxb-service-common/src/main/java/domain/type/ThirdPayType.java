package domain.type;

import java.util.List;

/**
 * 第三方支付方式
 * @author zl
 *
 */
public class ThirdPayType extends BaseType {

    private static final long serialVersionUID = -604710980286525098L;

    public ThirdPayType(Integer status, String description) {
        super(status, description);
    }
    /**未知*/
    public static ThirdPayType unknown = new ThirdPayType(0, "未知");
    /**梓微兴-微信*/
    public static ThirdPayType weixin = new ThirdPayType(1, "梓微兴微信支付");
    /**威富通-微信 */
    public static ThirdPayType weixin_wft = new ThirdPayType(2, "数通威富通微信支付");
    /**微付客-微信-H5 */
    public static ThirdPayType wfk_weixin_h5 = new ThirdPayType(3, "微付客微信H5支付");
    /**数通-支付宝*/
    public static ThirdPayType alipay_st = new ThirdPayType(4, "数通支付宝支付");
    /**兴业-支付宝*/
    public static ThirdPayType alipay_xy = new ThirdPayType(5, "兴业支付宝支付");
    /**新浪普惠*/
    public static ThirdPayType sina_ph = new ThirdPayType(6, "新浪普惠支付");
    /**威富通-微信-H5 */
    public static ThirdPayType wft_weixin_h5 = new ThirdPayType(7, "威富通微信H5支付");
    /**优络-微信 */
    public static ThirdPayType ulo_weixin = new ThirdPayType(8, "优络微信支付");

    public static ThirdPayType sina_weibo = new ThirdPayType(9, "新浪微博支付");
    /**番茄-支付宝 */
    public static ThirdPayType alipay_tomato = new ThirdPayType(10, "番茄支付宝支付");
    
    public static ThirdPayType jd_pay = new ThirdPayType(11,"京东支付") ;
    public static List<ThirdPayType> getAllList() {
        return getAll(ThirdPayType.class);
    }

    public static ThirdPayType valueOf(Integer index) {
        return valueOf(ThirdPayType.class, index);
    }

    public static boolean isThirdPayType(int thirdPayType){
    	if(thirdPayType==weixin.getIndex()
    			|| thirdPayType==weixin_wft.getIndex()
    			|| thirdPayType==wfk_weixin_h5.getIndex()
    			|| thirdPayType==wft_weixin_h5.getIndex()
    			|| thirdPayType==ulo_weixin.getIndex()
    					|| thirdPayType==sina_weibo.getIndex()
    			|| thirdPayType==alipay_st.getIndex() ||
    			thirdPayType==alipay_xy.getIndex()
    			|| thirdPayType==sina_ph.getIndex()
    			|| thirdPayType==alipay_tomato.getIndex()
    			|| thirdPayType==jd_pay.getIndex()){
    		return true;
    	}
    	return false;
    }
    /***
     * 属于第三方根本查不到单,所以在配置时间下,定时关闭订单作废方案
     * <br>【sina_ph比较特殊,可以查到,是返回ORDER_NOT_EXIST,放在一起处理掉】
     * @param thirdPayType
     * @return
     */
    public static boolean isNeedClosedOrder(int thirdPayType){
    	if(thirdPayType==weixin_wft.getIndex()
    			|| thirdPayType==alipay_st.getIndex()
    			|| thirdPayType==alipay_xy.getIndex()
    					|| thirdPayType==sina_ph.getIndex()
    							|| thirdPayType==wft_weixin_h5.getIndex()
    									|| thirdPayType==wfk_weixin_h5.getIndex()
    											|| thirdPayType==ulo_weixin.getIndex()
    													|| thirdPayType==sina_weibo.getIndex()
    															|| thirdPayType==alipay_tomato.getIndex()
    																	|| thirdPayType==jd_pay.getIndex()
    			){
    		return true;
    	}
    	return false;
    }
}

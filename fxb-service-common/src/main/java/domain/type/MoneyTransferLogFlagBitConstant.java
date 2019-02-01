package domain.type;


/**
 * 新浪转帐计划明细信息标识
 * 
 * @project didi-common
 * @author cxp
 * @date 2015年10月30日
 */
public class MoneyTransferLogFlagBitConstant {
	/** 默认 */
	public static long defualt = 0;
	
	/** 是否达到重做次数上限 1 */
	public static long no_continue = 1;
	
	
	/** 鉴权标记*/
	public static long withholdAuthority = 1<<1;
	
	/** 代表新浪普惠的订单 */
	public static long sina_ph =  1<<2 ;
	
    /**
	 * 类型
	 */
	private Long index;
	/**
	 * 类型名称
	 */
	private String name;
	public MoneyTransferLogFlagBitConstant(Long index, String name) {
		this.index = index;
		this.name = name;
	}
    
	
	/**
	 * 验证  optionFlagbit操作标识是否已经存在userFlagbit 中
	 * @param optionFlagbit
	 * @param userFlagbit
	 * @return
	 */
	public static boolean isExistFlagBit(long optionFlagbit,long userFlagbit) {
		return 	(optionFlagbit & userFlagbit )> 0;
	}
	
	
	public Long getIndex() {
		return index;
	}
	public void setIndex(Long index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
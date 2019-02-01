package domain.type;


/**
 * 用户和门店信息标识
 *
 * @project didi-common
 * @author duannp
 * @date 2015年10月19日
 */
public class UserFlagBitConstant {
	/** 默认 */
	public static long defualt = 0;

	/** 本地用户钱包是否创建1 */
	public static long local_wallet = 1 ;
	/** 新浪托管用户创建 2 */
	public static long sina_create = 1 << 1;
	/** 新浪托管实名认证 4*/
	public static long sina_identity = 1 << 2;
	/** 新浪托管支付密码设置 8*/
	public static long sina_pay_password = 1 << 3;
	/** 新浪托管认证信息绑定 16 */
	public static long sina_valid_info_bind = 1 << 4;
	/** 新浪托管银行卡绑定 32*/
	public static long sina_bank_card_bind = 1 << 5;
	/** 站点用户注册  第二步,用户详细信息是否填写 64*/
	public static long didi_provider_auth = 1 << 6;
	/** 站点用户是否具有自动抢单的资格128 */
	public static long provider_can_autho_rob = 1 << 7;
	/** 站点是否被禁止接单 256 */
	public static long provider_can_rob_ticket = 1 << 8;

	/** 用户是否充值标记 */
	public static long usr_charge_flag = 1 << 9;

	/**
	 * 用户是否修改过昵称
	 */
	public static long usr_update_nick_name = 1 << 10;
	/**
	 * 用户是否修改过头像
	 */
	public static long usr_update_icon = 1 << 11;

	/** 新浪PAS方式实名认证(新版)*/
	public static long sina_pas_identity = 1 << 12;
	/**
	 *  迁移中
	 */
	public static long migration_ing = 1 << 13;
	/**
	 *  迁移成功
	 */
	public static long migration_success = 1 << 14;
	/***
	 * 注册时默认就已升级
	 */
	public static long default_migrationed = 1 << 15;

	/***
	 * 是否开启小额免密支付
	 */
	public static long small_payment = 1 << 16;
	
	/** 新浪普惠银行卡绑定 32*/
	public static long sina_ph_bank_card_bind = 1 << 17;
	
	/** 2018年1月1日0点前用户*/
	public static long CAIPIAO_USER = 1 << 18;
	/** 首次投注(首次出票成功)标记*/
	public static long first_bet = 1 << 19;
	/** 
	 * 优质用户标记
	 * 时间维度：6月1日~6月20日
                 标签A：累计投注金额≥5000的用户*/
	public static long marquee_buyers = 1 << 20;
	
	/** 新浪普惠银行卡绑定初始化 */
	public static long sina_bank_card_init = 1 << 21;
    /**
	 * 类型
	 */
	private Long index;
	/**
	 * 类型名称
	 */
	private String name;
	public UserFlagBitConstant(Long index, String name) {
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
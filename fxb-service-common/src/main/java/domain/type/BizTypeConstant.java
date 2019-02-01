package domain.type;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务类别
 *
 * @author cxp
 *
 */
public class BizTypeConstant {


	/**
	 * c2b 第三方直付(准备金账户到中间账户)
	 */
	final static public int c2b_third_zf = 8;
	/**
	 * c2b 第三方直付回退(中间账户到准备金账户)
	 */
	final  static public int c2b_third_zf_ht = 9;


	/**
	 * c2b 支付
	 */
	final static public int c2b_zf = 10;
	/**
	 * c2b 支付回退
	 */
	final  static public int c2b_zf_ht = 11;

	/**
	 * b2b 支付
	 */
	final static public int b2b_zf = 12;
	// /**
	// * b2b 支付回退
	// */
	// static public int b2b_zf_ht = 13;


	/**
	 * 基本户抵扣券支付
	 */
	static public int rebate_zf = 14;
	/**
	 * 基本户抵扣券 支付回退
	 */
	final static  public int rebate_zf_ht = 15;
	/**
	 * 充值优惠劵-基本户赠送彩金-基本户到中间账户
	 */
	final static   public int c2b_charge_zs_gift_amount = 16;
	/**
	 * 充值优惠劵-基本户赠送彩金-中间账户到活动用户
	 */
	final static  public int b2c_charge_zs_gift_amount = 17;
	/**
	 * 用户活动-基本户赠送彩金-基本户到中间账户
	 */
	final static   public int c2b_usrhd_zs_gift_amount = 18;
	/**
	 * 用户活动-基本户赠送彩金-中间账户到活动用户
	 */
	final static  public int b2c_usrhd_zs_gift_amount = 19;

	/**
	 * 用户活动-基本户赠送彩金-中间账户到基本户(新钱包构造)
	 */
	final static  public int b2c_usrhd_zs_gift_amount_jbh = 191;


	/**
	 * b2b派奖
	 */
	final static  public int b2b_pj = 20;
	// /**
	// * b2b派奖回退
	// */
	// final static  public int b2b_pj_ht = 21;

	/**
	 * b2c派奖
	 */
	final static  public int b2c_pj = 22;
	// /**
	// * b2c派奖回退
	// */
	// final static  public int b2c_pj_ht = 23;



	/**
	 * 第三方充值-准备金账户到中间账户
	 */
	final static  public int c2b_third_charge = 24;
	/**
	 * 第三方充值-中间账户到用户
	 */
	final static  public int b2c_third_charge = 25;
	/**
	 * 第三方提款-用户到中间账户
	 */
	final static  public int c2b_third_getmoney = 26;
	/**
	 * 第三方提款-中间账户到准备金账户
	 */
	final static  public int b2c_third_getmoney = 27;
	/**
	 * 第三方提款-中间账户 回退到 用户
	 */
	final static  public int b2c_third_getmoney_ht = 28;
	/**
	 * 第三方提款退票-用户到中间账户
	 */
	final static  public int c2b_third_getmoney_tp = 29;
	/**
	 * 第三方提款退票-中间账户到准备金账户
	 */
	final static  public int b2c_third_getmoney_tp = 30;

	/**
	 * 准备金兑换充值-准备金账户到中间账户
	 */
	final static  public int c2b_exchange_charge = 31;
	/**
	 * 准备金兑换充值-中间账户到用户
	 */
	final static  public int b2c_exchange_charge = 32;

	/**

	 * c2b 追号计划支付(用户到中间账户)
	 */
	final static public int c2b_zhjh_zf = 33;
	/**
	 * c2b 追号代购支付(基本户到中间账户)
	 */
	final static public int c2b_zhdg_zf = 35;
	/**
	 * c2b 追号代购支付退款(中间账户到用户)
	 */
	final  static public int c2b_zhdg_zf_tk = 36;
	/**
	 * c2b 追号撤销支付(基本户到中间账户)
	 */
	final static public int c2b_zhcx_zf = 37;
	/**
	 * c2b 追号撤销收入(中间账户到用户)
	 */
	final  static public int b2c_zhcx_sr = 38;

	/**
	 * c2b 第三方直付(准备金账户到中间账户)
	 */
	final static public int c2b_zhjh_third_zf = 39;
	/**
	 * b2c 第三方取消支付(中间账户到准备金)
	 */
	final  static public int c2b_zhcx_third_zf = 41;
	/**
	 * b2c 第三方取消收入(中间账户到准备金)
	 */
	final  static public int b2c_zhcx_third_sr = 42;

	/**
	 * b2b部分出票支付(站点 ->中间账户)
	 */
	final  static public int b2b_part_ticket_zf = 46;
	/**
	 * b2c部分出票收入 (中间账户->用户)
	 */
	final  static public int b2c_part_ticket_sr = 47;


	/**
	 * b2c 追号计划收入(中间账户到基本户)
	 */
	final  static public int b2c_zhjh_sr = 48;

	/**
	 * 回购用户->中间账户
	 */
	final static public int c2b_hg_pay = 51;

	/** 中间账户->回购收入用户 */
	final static public int b2c_hg_incom = 52;

	/**
	 * 回购准备金户->中间账户
	 */
	final static public int c2b_hg_pay_zbj = 53;

	/** 中间账户->回购准备金户 */
	final static public int b2c_hg_incom_zbj = 54;


	/**
	 * 财务c为门店b充值
	 */
	public final static  int b2b_charge = 60;
	public final static  int b2c_charge = 61;

	/**
	 * 损益划转
	 */
	public final static  int b2b_loss_profit = 62;
	public final static  int b2c_loss_profit = 63;


	/**
	 * 准备金第三方彩金赠送-准备金到中间账户
	 */
	final static  public int c2b_third_cj_zs = 65;
	/**
	 * 准备金第三方彩金赠送-中间账户到用户
	 */
	final static  public int b2c_third_cj_zs = 66;
	/**
	 * 准备金第三方彩金赠送-中间账户到准备金
	 */
	final static  public int b2c_third_cj_zs_zbj = 67;

	/**
	 * 新浪钱包迁移支付 用户->中间账户
	 */
	final static  public int c2b_third_sina_wallet_up = 68;

	/**
	 * 新浪钱包迁移支付 中间账户 -> 基本户
	 */
	final static  public int b2c_third_sina_wallet_up = 69;


	/**
	 * 充值
	 */
	final static  public int cz = 90;

	/***
	 * 提款
	 */
	final static  public int getmoney = 100;


	/***借款支付**/
	public final static  int loan_pay = 101;
	/***借款收入**/
	public final static  int loan_income = 102;
	/***还款支付**/
	public final static  int repay_pay = 103;
	/***还款收入**/
	public final static  int repay_income = 104;

	/**
	 * 提款代付-基本账户到中间账户
	 */
	final static  public int c2b_getmoney = 105;

	/**
	 * 提款代付-中间账户到用户
	 */
	final static  public int b2c_getmoney = 106;

	/**
	 * 提款代收-用户到中间账户
	 */
	final static  public int c2b_getmoney_ds = 107;

	/**
	 * 提款代收--中间账户到基本户
	 */
	final static  public int b2c_getmoney_ds_sr = 108;


	/**
	 * 赢家分成派奖
	 */
	public final static int gt_income_zf = 109;
	public final static int gt_income_pj = 110;

	/**
	 * 代收款
	 */
	public final static int agent_receive = 111;
	/**
	 * 代付款支付
	 */
	public final static int agent_payout_b2b = 112;
	/**
	 * 代付款收入
	 */
	public final static int agent_payout_b2c = 113;

	/**
	 * 银联充值代收收入-中间账户到基本户
	 */
	final static  public int b2c_charge_ds_sr = 114;

	/**
	 * 准备金/基本户-中间账户
	 */
	final static  public int c2b_trans = 115;

	/**
	 * 中间账户 - 准备金/基本户
	 */
	final static  public int b2c_trans = 116;
	
	
	/**
	 * 用户普惠充值->中间账户
	 */
	final static  public int sinaph_c2b_cz = 117;
	/**
	 * 用户普惠直付->中间账户
	 */
	final static  public int sinaph_c2b_zf = 118;
	/**
	 * 用户普惠 充值中间账户 ->基本户收款
	 */
	final static  public int sinaph_b2b_cz_sk = 119;

	/**
	 * 用户普惠【基本户->充值中间账户】
	 */
	final static  public int sinaph_basic_to_middle = 120;
	/**
	 * 用户普惠【充值中间账户 ->基本户】
	 */
	final static  public int sinaph_middle_to_basic = 121;
 
	/**
	 * 用户普惠【基本户->提款中间账户】
	 */
	final static  public int sinaph_basic_to_middletk = 122;
	/**
	 * 用户普惠【提款中间账户 ->基本户】
	 */
	final static  public int sinaph_middletk_to_basic = 123;
	/**
	 * 用户普惠 直付中间账户 ->基本户收款
	 */
	final static  public int sinaph_b2b_zf_sk = 124;
	
	private Integer index;
	private String desc;

	public BizTypeConstant(Integer index, String desc) {
		super();
		this.index = index;
		this.desc = desc;
	}

	public static List<BizTypeConstant> getBizTypeConstantList() {
		List<BizTypeConstant> list = new ArrayList<>();
		list.add(new BizTypeConstant(BizTypeConstant.c2b_third_zf, "c2b第三方直付"));
		list.add(new BizTypeConstant(BizTypeConstant.c2b_third_zf_ht, "c2b第三方直付回退"));

		list.add(new BizTypeConstant(BizTypeConstant.c2b_zf, "c2b 支付"));
		list.add(new BizTypeConstant(BizTypeConstant.c2b_zf_ht, "c2b 支付回退"));
		list.add(new BizTypeConstant(BizTypeConstant.b2b_zf, "b2b 支付"));
		// list.add(new BizTypeConstant(BizTypeConstant.b2b_zf_ht,"b2b 支付回退"));
		list.add(new BizTypeConstant(BizTypeConstant.rebate_zf, "抵扣券支付"));
		list.add(new BizTypeConstant(BizTypeConstant.rebate_zf_ht, "抵扣券支付回退"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_charge_zs_gift_amount, "b2c充值优惠劵彩金赠送"));
		list.add(new BizTypeConstant(BizTypeConstant.c2b_charge_zs_gift_amount, "c2b充值优惠劵彩金赠送"));

		list.add(new BizTypeConstant(BizTypeConstant.b2c_usrhd_zs_gift_amount, "b2c用户活动彩金赠送"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_usrhd_zs_gift_amount_jbh, "b2c用户活动彩金赠送到基本户"));
		list.add(new BizTypeConstant(BizTypeConstant.c2b_usrhd_zs_gift_amount, "c2b用户活动彩金赠送"));

		list.add(new BizTypeConstant( BizTypeConstant.c2b_getmoney, "c2b提款代付"));
		list.add(new BizTypeConstant( BizTypeConstant.b2c_getmoney, "b2c提款代付"));
		list.add(new BizTypeConstant( BizTypeConstant.c2b_getmoney_ds, "c2b提款代收"));
		list.add(new BizTypeConstant( BizTypeConstant.b2c_getmoney_ds_sr, "b2c提款代收"));
 
		

		list.add(new BizTypeConstant(BizTypeConstant.b2b_pj, "b2b派奖"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_pj, "b2c派奖"));


		list.add(new BizTypeConstant(BizTypeConstant.c2b_exchange_charge, "c2b兑换充值"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_exchange_charge, "b2c兑换充值"));

		list.add(new BizTypeConstant(BizTypeConstant.c2b_third_charge, "c2b第三方充值"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_third_charge, "b2c第三方充值"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_charge_ds_sr, "b2c银联充值代收收入"));

		list.add(new BizTypeConstant(BizTypeConstant.c2b_third_getmoney, "c2b第三方提款"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_third_getmoney, "b2c第三方提款"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_third_getmoney_ht, "b2c第三方提款回退"));

		list.add(new BizTypeConstant(BizTypeConstant.c2b_third_getmoney_tp, "c2b第三方提款退票"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_third_getmoney_tp, "b2c第三方提款退票"));


		list.add(new BizTypeConstant(BizTypeConstant.c2b_zhjh_third_zf, "c2b第三方追号计划支付"));
		list.add(new BizTypeConstant(BizTypeConstant.c2b_zhjh_zf, "c2b追号计划支付"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_zhjh_sr, "c2b追号计划支付收入"));

		list.add(new BizTypeConstant(BizTypeConstant.c2b_zhcx_zf, "c2b追号撤销支付"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_zhcx_sr, "b2c追号撤销收入"));

		list.add(new BizTypeConstant(BizTypeConstant.c2b_zhdg_zf, "c2b追号代购支付"));
		list.add(new BizTypeConstant(BizTypeConstant.c2b_zhdg_zf_tk, "c2b追号代购支付退款"));


		//第三方
		list.add(new BizTypeConstant(BizTypeConstant.c2b_zhcx_third_zf,"c2b第三方追号撤销支付"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_zhcx_third_sr,"c2b第三方追号撤销收入"));

		list.add(new BizTypeConstant(BizTypeConstant.c2b_third_cj_zs, "c2b第三方彩金赠送"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_third_cj_zs, "b2c第三方彩金赠送"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_third_cj_zs_zbj, "b2c第三方彩金赠送到准备金"));

		list.add(new BizTypeConstant(BizTypeConstant.c2b_third_sina_wallet_up, "c2b钱包升级支付"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_third_sina_wallet_up, "b2c钱包升级支付"));



		list.add(new BizTypeConstant(BizTypeConstant.b2b_charge, "b2b彩金派放"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_charge, "b2c彩金派放"));
		list.add(new BizTypeConstant(BizTypeConstant.b2b_loss_profit, "b2b损失资金"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_loss_profit, "b2c损失资金"));

		list.add(new BizTypeConstant(BizTypeConstant.cz, "充值"));
		list.add(new BizTypeConstant(BizTypeConstant.getmoney, "提款"));

		list.add(new BizTypeConstant(BizTypeConstant.loan_pay, "借款支付"));
		list.add(new BizTypeConstant(BizTypeConstant.loan_income, "借款收入"));
		list.add(new BizTypeConstant(BizTypeConstant.repay_pay, "还款支付"));
		list.add(new BizTypeConstant(BizTypeConstant.repay_income, "还款收入"));

		list.add(new BizTypeConstant(BizTypeConstant.c2b_hg_pay, "回购支付"));
		list.add(new BizTypeConstant(BizTypeConstant.c2b_hg_pay_zbj, "回购准备金支付"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_hg_incom, "回购收入"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_hg_incom_zbj, "回购准备金收入"));

		list.add(new BizTypeConstant(BizTypeConstant.gt_income_zf, "赢家分成派奖支付"));
		list.add(new BizTypeConstant(BizTypeConstant.gt_income_pj, "赢家分成派奖收入"));
		list.add(new BizTypeConstant(BizTypeConstant.agent_receive, "代收款"));
		list.add(new BizTypeConstant(BizTypeConstant.agent_payout_b2b, "代付款支付"));
		list.add(new BizTypeConstant(BizTypeConstant.agent_payout_b2c, "代付款收入"));

		//部分出票
		list.add(new BizTypeConstant(BizTypeConstant.b2b_part_ticket_zf,"b2b部分出票支付"));
		list.add(new BizTypeConstant(BizTypeConstant.b2c_part_ticket_sr,"b2c部分出票收入"));


		list.add(new BizTypeConstant(BizTypeConstant.b2c_trans,"b2c划转(准备金_基本户)"));
		list.add(new BizTypeConstant(BizTypeConstant.c2b_trans,"c2b划转(准备金_基本户)"));


		list.add(new BizTypeConstant(BizTypeConstant.sinaph_c2b_cz,"新浪普惠充值"));
		list.add(new BizTypeConstant(BizTypeConstant.sinaph_c2b_zf,"新浪普惠直付"));
		list.add(new BizTypeConstant(BizTypeConstant.sinaph_b2b_zf_sk,"新浪普惠基本户直付收款"));
		list.add(new BizTypeConstant(BizTypeConstant.sinaph_b2b_cz_sk,"新浪普惠基本户充值收款"));

		list.add(new BizTypeConstant(BizTypeConstant.sinaph_basic_to_middle,"新浪普惠基本户到充值中间账户"));
		list.add(new BizTypeConstant(BizTypeConstant.sinaph_middle_to_basic,"新浪普惠充值中间账户到基本户"));
		
		list.add(new BizTypeConstant(BizTypeConstant.sinaph_basic_to_middletk,"新浪普惠基本户到提款中间账户"));
		list.add(new BizTypeConstant(BizTypeConstant.sinaph_middletk_to_basic,"新浪普惠提款中间账户到基本户"));
		return list;
	}

	public static boolean isReTransferSchedule(int bizType) {
		if(getReTransferBizType().contains(bizType)){
			return true;
		}
		return false;
	}
	/***
	 * 可以在后台重新划转的类型列表
	 * 说明：不需要输入支付密码的 代收 代付  都可以进入这个列表
	 * @return
	 */
	public static List<Integer> getReTransferBizType() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(BizTypeConstant.c2b_zf_ht);
		list.add(BizTypeConstant.b2b_zf);
		list.add(BizTypeConstant.b2c_third_sina_wallet_up);
		list.add(BizTypeConstant.b2b_pj);
		list.add(BizTypeConstant.b2c_pj);
		list.add(BizTypeConstant.loan_income);
		list.add(BizTypeConstant.repay_income);

		list.add(BizTypeConstant.rebate_zf);
		list.add(BizTypeConstant.rebate_zf_ht);
		list.add(BizTypeConstant.b2c_charge_zs_gift_amount);
		list.add(BizTypeConstant.c2b_charge_zs_gift_amount);

		list.add(BizTypeConstant.b2c_usrhd_zs_gift_amount);
		list.add(BizTypeConstant.b2c_usrhd_zs_gift_amount_jbh);
		list.add(BizTypeConstant.c2b_usrhd_zs_gift_amount);

		list.add(BizTypeConstant.c2b_exchange_charge);
		list.add(BizTypeConstant.b2c_exchange_charge);

		list.add(BizTypeConstant.c2b_third_charge);
		list.add(BizTypeConstant.b2c_third_charge);

		list.add(BizTypeConstant.b2c_third_getmoney);
		list.add(BizTypeConstant.b2c_third_getmoney_ht);

		list.add(BizTypeConstant.c2b_third_getmoney_tp);
		list.add(BizTypeConstant.b2c_third_getmoney_tp);

		list.add(BizTypeConstant.c2b_third_zf);
		list.add(BizTypeConstant.c2b_third_zf_ht);

		list.add(BizTypeConstant.c2b_hg_pay);
		list.add(BizTypeConstant.c2b_hg_pay_zbj);
		list.add(BizTypeConstant.b2c_hg_incom);
		list.add(BizTypeConstant.b2c_hg_incom_zbj);

		list.add(BizTypeConstant.c2b_third_cj_zs);
		list.add(BizTypeConstant.b2c_third_cj_zs);
		list.add(BizTypeConstant.b2c_third_cj_zs_zbj);

		//追号
		list.add(BizTypeConstant.b2c_zhjh_sr);
		list.add(BizTypeConstant.c2b_zhcx_zf);
		list.add(BizTypeConstant.b2c_zhcx_sr);
		list.add(BizTypeConstant.c2b_zhdg_zf);
		list.add(BizTypeConstant.c2b_zhdg_zf_tk);
		//第三方追号
		list.add(BizTypeConstant.c2b_zhjh_third_zf);
		list.add(BizTypeConstant.c2b_zhcx_third_zf);
		list.add(BizTypeConstant.b2c_zhcx_third_sr);
		list.add(BizTypeConstant.c2b_zhdg_zf_tk);
		//部分出票
		list.add(BizTypeConstant.b2b_part_ticket_zf);
		list.add(BizTypeConstant.b2c_part_ticket_sr);

		list.add(BizTypeConstant.b2c_trans);
		list.add(BizTypeConstant.c2b_trans);
		
		// 升级用户提款代收代付
		list.add(BizTypeConstant.c2b_getmoney);
		list.add(BizTypeConstant.b2c_getmoney);
		list.add(BizTypeConstant.b2c_getmoney_ds_sr);
		list.add(BizTypeConstant.b2c_charge_ds_sr);
 
		list.add(BizTypeConstant.b2c_third_sina_wallet_up);
		
		
		list.add(BizTypeConstant.sinaph_b2b_cz_sk);
		list.add(BizTypeConstant.sinaph_b2b_zf_sk);
  
		return list;
	}
	/***
	 * 自动处理故障的类型
	 * 1、定时器会自动处理该类型 失败的数据
	 * 2、界面上的一键处理故障数据  也是处理这些类型
	 * <p>
	 * 说明： 不需要输入支付密码的 代收 代付的，需要自动处理故障的类型
	 * @return
	 *
	 */
	public static List<Integer> getAutoProcessingStopBizTypeList() {

		List<Integer> list = new ArrayList<Integer>();
		list.add(BizTypeConstant.c2b_zf_ht);
		list.add(BizTypeConstant.b2b_zf);
		list.add(BizTypeConstant.b2c_third_sina_wallet_up);
		list.add(BizTypeConstant.b2c_pj);
		list.add(BizTypeConstant.loan_income);
		list.add(BizTypeConstant.repay_income);

		list.add(BizTypeConstant.rebate_zf);
		list.add(BizTypeConstant.rebate_zf_ht);
		list.add(BizTypeConstant.b2c_charge_zs_gift_amount);
		list.add(BizTypeConstant.c2b_charge_zs_gift_amount);
		list.add(BizTypeConstant.b2c_usrhd_zs_gift_amount);
		list.add(BizTypeConstant.b2c_usrhd_zs_gift_amount_jbh);
		list.add(BizTypeConstant.c2b_usrhd_zs_gift_amount);

		list.add(BizTypeConstant.c2b_exchange_charge);
		list.add(BizTypeConstant.b2c_exchange_charge);

		list.add(BizTypeConstant.c2b_third_charge);
		list.add(BizTypeConstant.b2c_third_charge);


		list.add(BizTypeConstant.b2c_third_getmoney);
		list.add(BizTypeConstant.b2c_third_getmoney_ht);

		list.add(BizTypeConstant.c2b_third_getmoney_tp);
		list.add(BizTypeConstant.b2c_third_getmoney_tp);

		list.add(BizTypeConstant.c2b_third_zf);
		list.add(BizTypeConstant.c2b_third_zf_ht);


		list.add(BizTypeConstant.c2b_hg_pay);
		list.add(BizTypeConstant.c2b_hg_pay_zbj);
		list.add(BizTypeConstant.b2c_hg_incom);
		list.add(BizTypeConstant.b2c_hg_incom_zbj);

		list.add(BizTypeConstant.c2b_third_cj_zs);
		list.add(BizTypeConstant.b2c_third_cj_zs);
		list.add(BizTypeConstant.b2c_third_cj_zs_zbj);

		//追号
		list.add(BizTypeConstant.b2c_zhjh_sr);
		list.add(BizTypeConstant.c2b_zhcx_zf);
		list.add(BizTypeConstant.b2c_zhcx_sr);
		list.add(BizTypeConstant.c2b_zhdg_zf);
		list.add(BizTypeConstant.c2b_zhdg_zf_tk);
		//第三方追号
		list.add(BizTypeConstant.c2b_zhjh_third_zf);
		list.add(BizTypeConstant.c2b_zhcx_third_zf);
		list.add(BizTypeConstant.b2c_zhcx_third_sr);
		list.add(BizTypeConstant.c2b_zhdg_zf_tk);

		//部分出票
		//list.add(BizTypeConstant.b2b_part_ticket_zf);
		list.add(BizTypeConstant.b2c_part_ticket_sr);

		list.add(BizTypeConstant.b2c_trans);
		list.add(BizTypeConstant.c2b_trans);
		
	    // 升级用户提款代收代付
        list.add(BizTypeConstant.c2b_getmoney);
        list.add(BizTypeConstant.b2c_getmoney);
        list.add(BizTypeConstant.b2c_getmoney_ds_sr);

        list.add(BizTypeConstant.b2c_charge_ds_sr);
        
		list.add(BizTypeConstant.sinaph_b2b_cz_sk);
		list.add(BizTypeConstant.sinaph_b2b_zf_sk);
		return list;
	}
	/***
	 *
	 * 主要用于（to中间账户的情况,防止后面业务余额不足）
	 * @return
	 *
	 */
	public static List<Integer> getAutoReTransferList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(BizTypeConstant.rebate_zf);
		list.add(BizTypeConstant.c2b_third_zf);
		return list;
	}

	public static BizTypeConstant getBizTypeConstant(int index) {
		List<BizTypeConstant> list = getBizTypeConstantList();
		for (BizTypeConstant b : list) {
			if (index == b.getIndex().intValue()) {

				return b;
			}
		}

		return null;
	}
	/***
	 * 第三方充值提款活动等-接收通知列表
	 */
	public static List<Integer> getThirdCzTkHdBizTypeList() {
		List<Integer> thirdCzTkBizTypeList = new ArrayList<Integer>();
		thirdCzTkBizTypeList.add(BizTypeConstant.c2b_exchange_charge);
		thirdCzTkBizTypeList.add(BizTypeConstant.b2c_exchange_charge);
		thirdCzTkBizTypeList.add(BizTypeConstant.c2b_third_charge);
		thirdCzTkBizTypeList.add(BizTypeConstant.b2c_third_charge);
		thirdCzTkBizTypeList.add(BizTypeConstant.c2b_third_getmoney);
		thirdCzTkBizTypeList.add(BizTypeConstant.b2c_third_getmoney);
		thirdCzTkBizTypeList.add(BizTypeConstant.b2c_third_getmoney_ht);
		thirdCzTkBizTypeList.add(BizTypeConstant.c2b_third_getmoney_tp);
		thirdCzTkBizTypeList.add(BizTypeConstant.b2c_third_getmoney_tp);

		thirdCzTkBizTypeList.add(BizTypeConstant.b2c_usrhd_zs_gift_amount);
		thirdCzTkBizTypeList.add(BizTypeConstant.b2c_usrhd_zs_gift_amount_jbh);
		thirdCzTkBizTypeList.add(BizTypeConstant.c2b_usrhd_zs_gift_amount);

		thirdCzTkBizTypeList.add(BizTypeConstant.c2b_third_cj_zs);
		thirdCzTkBizTypeList.add(BizTypeConstant.b2c_third_cj_zs);

		thirdCzTkBizTypeList.add(BizTypeConstant.c2b_getmoney);
		thirdCzTkBizTypeList.add(BizTypeConstant.b2c_getmoney);
		thirdCzTkBizTypeList.add(BizTypeConstant.b2c_third_cj_zs_zbj);

		thirdCzTkBizTypeList.add(BizTypeConstant.b2c_charge_ds_sr);

		return thirdCzTkBizTypeList;
	}

	/***
	 * 升级后用户提款活动等-接收通知列表
	 */
	public static List<Integer> getTkBizTypeList() {

		List<Integer> tkBizTypeList = new ArrayList<Integer>();
		tkBizTypeList.add(BizTypeConstant.c2b_getmoney);
		tkBizTypeList.add(BizTypeConstant.b2c_getmoney);
		tkBizTypeList.add(BizTypeConstant.c2b_getmoney_ds);
		tkBizTypeList.add(BizTypeConstant.b2c_getmoney_ds_sr);
		return tkBizTypeList;
	}

	/***
	 * 获取追号相关的等-接收通知列表
	注意：已经追回成功的代购 退款（c2b_zhdg_zf_tk）  不在这里    在普通的代购一起
	 */
	public static List<Integer> getZHBizTypeList() {
		List<Integer> thirdCzTkBizTypeList = new ArrayList<Integer>();


		thirdCzTkBizTypeList.add(BizTypeConstant.c2b_zhjh_zf);
		thirdCzTkBizTypeList.add(BizTypeConstant.c2b_zhjh_third_zf);

		thirdCzTkBizTypeList.add(BizTypeConstant.b2c_zhjh_sr);

		thirdCzTkBizTypeList.add(BizTypeConstant.c2b_zhcx_zf);
		thirdCzTkBizTypeList.add(BizTypeConstant.b2c_zhcx_sr);

		thirdCzTkBizTypeList.add(BizTypeConstant.c2b_zhdg_zf);
		thirdCzTkBizTypeList.add(BizTypeConstant.c2b_zhdg_zf_tk);


		//第三方
		thirdCzTkBizTypeList.add(BizTypeConstant.c2b_zhcx_third_zf);
		thirdCzTkBizTypeList.add(BizTypeConstant.b2c_zhcx_third_sr);


		return thirdCzTkBizTypeList;
	}


	/***
	 * 获取一些基础业务的划转类型
	 */
	public static List<Integer> getBaseBusinessBizTypeList() {
		List<Integer> list = new ArrayList<Integer>();
		//部分出票
		list.add(BizTypeConstant.b2b_part_ticket_zf);
		list.add(BizTypeConstant.b2c_part_ticket_sr);
		return list;
	}
	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}

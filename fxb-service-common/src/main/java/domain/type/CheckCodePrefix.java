package domain.type;


import domain.util.DateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 用户对账标识码-、商品名称
 * @author zl
 *
 */
public class CheckCodePrefix {
	/*** 充值收入 ***/
	public static final String CZSR = "CZSR";
	/*** 充值支付 ***/
	public static final String CZZF = "CZZF";

	/*** 充值银联支付 -》 中间  ***/
	public static final String CZYLZF = "CZYLZF";
	/*** 充值代付收入 中间-》 用户  ***/
	public static final String CZDFSR = "CZDFSR";
	/*** 充值代收收入 中间-》 基本户  ***/
	public static final String CZDSSR = "CZDSSR";

	/*** 提款收入 ***/
	public static final String TKSR = "TKSR";
	/*** 提款支付 ***/
	public static final String TKZF = "TKZF";
	/*** 提款回退 ***/
	public static final String TKHT = "TKHT";
	/*** 提款退票支付 ***/
	public static final String TKTPZF = "TKTPZF";
	/*** 提款退款收入 ***/
	public static final String TKTPSR = "TKTPSR";

	/*** 提款代付支付 基本户-》中间 **/
	public static final String TKDFZF = "TKDFZF";
	/*** 提款代付收入 中间-》 用户 **/
	public static final String TKDFSR = "TKDFSR";
	/*** 提款代收支付  用户-》中间  ***/
	public static final String TKDSZF = "TKDSZF";
	/*** 提款代收收入 中间-》 基本户 ***/
	public static final String TKDSSR = "TKDSSR";


	/*** 赠送彩金收入 ***/
	public static final String CJSR = "CJSR";

	/*** 赠送彩金基本户收入 ***/
	public static final String CJJBHSR = "CJSR";

	/*** 彩金支付 ***/
	public static final String CJZF = "CJZF";

	/*** 抵扣券支付 ***/
	public static final String DKQZF = "DKQZF";
	/*** 抵扣券退款 ***/
	public static final String DKQTK = "DKQTK";

	/*** 回购支付 ***/
	public static final String HGZF = "HGZF";

	/*** 回购准备金支付 ***/
	public static final String HGZBJZF = "HGZBJZF";

	/*** 回购收入 ***/
	public static final String HGSR = "HGSR";

	/*** 回购准备金收入 ***/
	public static final String HGZBJSR = "HGZBJSR";

	/*** 购彩支付 ***/
	public static final String GCZF = "GCZF";

	/*** 钱包升级支付 ***/
	public static final String SJZF = "SJZF";

	/*** 钱包二次迁移支付 ***/
	public static final String QYZF = "QYZF";

	/*** 钱包二次迁移收入 ***/
	public static final String QYSR = "QYSR";

	/*** 钱包升级收入 ***/
	public static final String SJSR = "SJSR";

	/*** 购彩退款 ***/
	public static final String GCTK = "GCTK";
	/***钱包升级-代收购彩退款 ***/
	public static final String DSGCTK = "DSGCTK";
	/*** 票款收入 ***/
	public static final String PKSR = "PKSR";

	/*** 派奖支付 ***/
	public static final String PJZF = "PJZF";
	/*** 派奖收入 ***/
	public static final String PJSR = "PJSR";

	/*** 损益支付 ***/
	public static final String SYZF = "SYZF";
	/*** 损益收入 ***/
	public static final String SYSR = "SYSR";

	/*** 借款支付 ***/
	public static final String JKZF = "JKZF";
	/*** 还款支付 ***/
	public static final String HKZF = "HKZF";

	/*** 借款收入 ***/
	public static final String JKSR = "JKSR";
	/*** 还款收入 ***/
	public static final String HKSR = "HKSR";

	/*** 第三方直付支付 ***/
	public static final String TZFZF = "TZFZF";
	/*** 第三方直付支付 回退 ***/
	public static final String TZFTK = "TZFTK";




	/*** 追号计划支付 ***/
	public static final String ZHJHZF = "ZHJHZF";
	/*** 第三方追号计划支付 ***/
	public static final String TZHJHZF = "TZHJHZF";
	/*** 追号计划支付 ***/
	public static final String ZHJHSR = "ZHJHSR";


	/*** 追号撤销 ***/
	public static final String ZHCXZF = "ZHCXZF";
	/*** 追号撤销 ***/
	public static final String ZHCXSR = "ZHCXSR";
	/*** 升级后-代收追号撤销 ***/
	public static final String DSZHCXSR = "DSZHCXSR";
	/*** 第三方追号撤销 ***/
	public static final String TZHCXZF = "TZHCXZF";
	/*** 第三方追号撤销 ***/
	public static final String TZHCXSR = "TZHCXSR";

	/*** 追号购彩支付 ***/
	public static final String ZHGCZF = "ZHGCZF";
	/*** 追号购彩退款 ***/
	public static final String ZHGCTK = "ZHGCTK";
	/*** 升级后-代收追号购彩退款 ***/
	public static final String DSZHGCTK = "DSZHGCTK";
	/*** 第三方追号购彩支付 ***/
	public static final String TZHGCZF = "TZHGCZF";
	/*** 第三方追号购彩退款 ***/
	public static final String TZHGCTK = "TZHGCTK";


	/*** 第三方赠送彩金收入 ***/
	public static final String TCJSR = "TCJSR";
	/*** 第三方赠送彩金准备金收入 ***/
	public static final String TCJZBJSR = "TCJZBJSR";
	/*** 第三方赠送彩金支付 ***/
	public static final String TCJZF = "TCJZF";

	/*** 部分出票收入 ***/
	public static final String BFCPSR = "BFCPSR";
	/*** 部分出票支付 ***/
	public static final String BFCPZF = "BFCPZF";

	/** 代收款收入 */
	public static final String DSKSR = "DSKSR";
	/** 代付款支付 */
	public static final String DFKZF = "DFKZF";
	/** 代付款收入 */
	public static final String DFKSR = "DFKSR";

	/** 准备金_基本户划转收入 */
	public static final String BHZSR = "BHZSR";

	/** 准备金_基本户划转支付 */
	public static final String BHZZF = "BHZZF";
	
	
	/** 新浪普惠充值*/
	public static final String SPHCZ = "SPHCZ";
	/** 新浪普惠直付*/
	public static final String SPHZF = "SPHZF";
	/** 新浪普惠收款*/
	public static final String SPHSK = "SPHSK";
	
	/** 新浪普惠基本户到中间账户*/
	public static final String SPHBTM = "SPHBTM";
	/** 新浪普惠中间账户到基本户*/
	public static final String SPHMTB = "SPHMTB";
	/** 新浪普惠基本户到提款中间账户*/
	public static final String SPHBTM2 = "SPHBTM2";
	/** 新浪普惠提款中间账户到基本户*/
	public static final String SPHM2TB = "SPHM2TB";
	public static Map<String,String> codeNameMap = new HashMap<String,String>();
	static{
		codeNameMap.put(ZHJHSR, "追号方案收入");
		codeNameMap.put(ZHJHZF, "追号方案支付");
		codeNameMap.put(TZHJHZF, "第三方追号方案支付");
		codeNameMap.put(ZHCXZF, "追号撤销支付");
		codeNameMap.put(ZHCXSR, "追号撤销收入");
		codeNameMap.put(DSZHCXSR, "代收追号撤销收入");
		codeNameMap.put(TZHCXSR, "第三方追号撤销收入");

		codeNameMap.put(ZHGCZF, "追号代购支付");
		codeNameMap.put(TZHGCZF, "第三方追号代购支付");
		codeNameMap.put(ZHGCTK, "追号代购退款");
		codeNameMap.put(DSZHGCTK, "代收追号代购退款");
		codeNameMap.put(TZHGCTK, "第三方追号代购退款");

		codeNameMap.put(CZSR, "充值收入");
		codeNameMap.put(CZZF, "充值支付");

		codeNameMap.put(CZYLZF, "银联在线充值");
		codeNameMap.put(CZDFSR, "充值代付收入");
		codeNameMap.put(CZDSSR, "充值代收收入");

		codeNameMap.put(TKZF, "提款支付");
		codeNameMap.put(TKHT, "提款回退");
		codeNameMap.put(TKSR, "提款收入");

		codeNameMap.put(TKTPSR, "提款退票收入");
		codeNameMap.put(TKTPZF, "提款退票支付");

		codeNameMap.put(TKDFZF, "提款代付支付");
		codeNameMap.put(TKDFSR, "提款代付收入");
		codeNameMap.put(TKDSZF, "取消提款");
		codeNameMap.put(TKDSSR, "提款代收收入");

		codeNameMap.put(CJSR, "彩金收入");
		codeNameMap.put(CJJBHSR, "彩金基本户收入");
		codeNameMap.put(CJZF, "彩金支付");
		codeNameMap.put(DKQZF, "抵扣卷支付");
		codeNameMap.put(DKQTK, "抵扣卷退款");


		codeNameMap.put(TZFZF, "第三方直付");
		codeNameMap.put(TZFTK, "第三方直付退款");

		codeNameMap.put(GCZF, "购彩支付");
		codeNameMap.put(SJZF, "钱包升级支付");
		codeNameMap.put(SJSR, "钱包升级收入");

		codeNameMap.put(QYZF, "钱包二次迁移支付");
		codeNameMap.put(QYSR, "钱包二次迁移收入");


		codeNameMap.put(GCTK, "购彩退款");
		codeNameMap.put(DSGCTK, "代收购彩退款");
		codeNameMap.put(PKSR, "票款收入");

		codeNameMap.put(PJZF, "派奖支付");
		codeNameMap.put(PJSR, "派奖收入");

		codeNameMap.put(SYZF, "损益支付");
		codeNameMap.put(SYSR, "损益收入");

		codeNameMap.put(JKZF, "借款支付");
		codeNameMap.put(HKZF, "还款支付");
		codeNameMap.put(JKSR, "借款收入");
		codeNameMap.put(HKSR, "还款收入");
		codeNameMap.put(HGZF, "回购支付");
		codeNameMap.put(HGZBJZF, "回购准备金支付");
		codeNameMap.put(HGSR, "回购收入");
		codeNameMap.put(HGZBJSR, "回购准备金收入");

		codeNameMap.put(TCJZF, "第三方赠送支付");
		codeNameMap.put(TCJSR, "第三方赠送收入");
		codeNameMap.put(TCJZBJSR, "第三方赠送准备金收入");

		codeNameMap.put(BFCPZF, "部分出票支付");
		codeNameMap.put(BFCPSR, "部分出票收入");

		codeNameMap.put(DSKSR, "代收款收入");
		codeNameMap.put(DFKZF, "代付款支付");
		codeNameMap.put(DFKSR, "代付款收入");

		codeNameMap.put(BHZSR, "准备金_基本户划转收入");
		codeNameMap.put(BHZZF, "准备金_基本户划转支付");
		
		codeNameMap.put(SPHCZ, "新浪普惠充值");
		codeNameMap.put(SPHZF, "新浪普惠直付");
		codeNameMap.put(SPHSK, "新浪普惠收款");
		
		codeNameMap.put(SPHBTM, "新浪普惠基本户到充值中间账户");
		codeNameMap.put(SPHMTB, "新浪普惠充值中间账户到基本户");
		
		codeNameMap.put(SPHBTM2, "新浪普惠基本户到提款中间账户");
		codeNameMap.put(SPHM2TB, "新浪普惠提款中间账户到基本户");
	}
	/**
	 * 构建商品名称: 例如：购彩支付-GCZF20151120
	 * @param fullCheckCode  GCZF20151120
	 * @return
	 */
	public static String buildCommodityName(String checkCode){
		if(checkCode==null || checkCode.length() < 9){
			return DateUtil.getDateString3(new Date());
		}
		String checkCodePre = checkCode.substring(0, checkCode.length()-8);
		//例如：购彩支付-GCZF20151120
		return codeNameMap.get(checkCodePre)+"-"+checkCode;
	}
	/***
	 * 获取完整标识码 ：  例如：GCZF20151120
	 * @param checkCode
	 * @return
	 */
	public static String buildCheckCode(String checkCodePre){
		//例如：GCZF20151120
		return checkCodePre+DateUtil.getDateString3(new Date());
	}


    public static String zwxCheckCodeParamName="op_term_no";
	public static String wftCheckCodeParamName="attach";
	public static String wftRefundCheckCodeParamName="op_user_id";//device_info



}

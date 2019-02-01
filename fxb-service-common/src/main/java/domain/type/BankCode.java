package domain.type;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 银行代码
 *
 * @project didi-common
 * @author duannp
 * @date 2015年10月22日
 */
public class BankCode {

	public static String getBankNameByCode(String bankCode){
		return bankCodeMap.get(bankCode);
	}
	public static String getBankCodeByName(String bankName){
		for (Entry<String, String> bank : bankCodeMap.entrySet()) {
			if (bank.getValue().equals(bankName)) {
				return bank.getKey();
			}
		}
		return "";
	}
	/**联动优势使用的*/
	public static String getUmpayBankCodeByName(String bankName){
		for (Entry<String, String> bank : umpayBankCodeMap.entrySet()) {
			if (bank.getValue().equals(bankName)) {
				return bank.getKey();
			}
		}
		return getBankCodeByName(bankName);
	}
	
	public static Map<String,String> getBankCodeMap(){
		return bankCodeMap;
	}

	private static Map<String, String> bankCodeMap = new HashMap<String, String>();
	static {
		bankCodeMap.put("ABC", "农业银行");
		bankCodeMap.put("BCCB", "北京银行");
		bankCodeMap.put("BJRCB", "北京农商行");
		bankCodeMap.put("BOC", "中国银行");
		bankCodeMap.put("BOS", "上海银行");
		bankCodeMap.put("CBHB", "渤海银行");
		bankCodeMap.put("CCB", "建设银行");
		bankCodeMap.put("CCQTGB", "重庆三峡银行");
		bankCodeMap.put("CEB", "光大银行");
		bankCodeMap.put("CIB", "兴业银行");
		bankCodeMap.put("CITIC", "中信银行");
		bankCodeMap.put("CMB", "招商银行");
		bankCodeMap.put("CMBC", "民生银行");
		bankCodeMap.put("COMM", "交通银行");
		bankCodeMap.put("CSCB", "长沙银行");
		bankCodeMap.put("CZB", "浙商银行");
		bankCodeMap.put("CZCB", "浙江稠州商业银行");
		bankCodeMap.put("GDB", "广东发展银行");
		bankCodeMap.put("GNXS", "广州市农信社");
		bankCodeMap.put("GZCB", "广州市商业银行");
		bankCodeMap.put("HCCB", "杭州银行");
		bankCodeMap.put("HKBCHINA", "汉口银行");
		bankCodeMap.put("HSBANK", "徽商银行");
		bankCodeMap.put("HXB", "华夏银行");
		bankCodeMap.put("ICBC", "工商银行");
		bankCodeMap.put("NBCB", "宁波银行");
		bankCodeMap.put("NJCB", "南京银行");
		bankCodeMap.put("PSBC", "中国邮储银行");
		bankCodeMap.put("SHRCB", "上海农村商业银行");
		bankCodeMap.put("SNXS", "深圳农村商业银行");
		bankCodeMap.put("SPDB", "浦东发展银行");
		bankCodeMap.put("SXJS", "晋城市商业银行");
		bankCodeMap.put("SZPAB", "平安银行");
		bankCodeMap.put("UPOP", "银联在线支付");
		bankCodeMap.put("WZCB", "温州市商业银行");
	}

	private static Map<String, String> umpayBankCodeMap = new HashMap<String, String>();
	static {
		umpayBankCodeMap.put("ABC", "中国农业银行");
		umpayBankCodeMap.put("BJB", "北京银行");
		umpayBankCodeMap.put("BJRCB", "北京农商行");
		umpayBankCodeMap.put("BOC", "中国银行");
		umpayBankCodeMap.put("SHB", "上海银行");
		umpayBankCodeMap.put("CBHB", "渤海银行");
		umpayBankCodeMap.put("CCB", "中国建设银行");
		umpayBankCodeMap.put("CCQTGB", "重庆三峡银行");
		umpayBankCodeMap.put("CEB", "光大银行");
		umpayBankCodeMap.put("CIB", "兴业银行");
		umpayBankCodeMap.put("CITIC", "中信银行");
		umpayBankCodeMap.put("CMB", "招商银行");
		umpayBankCodeMap.put("CMBC", "中国民生银行");
		umpayBankCodeMap.put("COMM", "交通银行");
		umpayBankCodeMap.put("CSCB", "长沙银行");
		umpayBankCodeMap.put("CZB", "浙商银行");
		umpayBankCodeMap.put("CZCB", "浙江稠州商业银行");
		umpayBankCodeMap.put("GDB", "广发银行");
		umpayBankCodeMap.put("GNXS", "广州市农信社");
		umpayBankCodeMap.put("GZCB", "广州市商业银行");
		umpayBankCodeMap.put("HCCB", "杭州银行");
		umpayBankCodeMap.put("HKBC", "汉口银行");
		umpayBankCodeMap.put("HSB", "徽商银行");
		umpayBankCodeMap.put("HXB", "华夏银行");
		umpayBankCodeMap.put("ICBC", "中国工商银行");
		umpayBankCodeMap.put("NBB", "宁波银行");
		umpayBankCodeMap.put("NJCB", "南京银行");
		umpayBankCodeMap.put("PSBC", "中国邮政储蓄银行");
		umpayBankCodeMap.put("SHRCB", "上海农村商业银行");
		umpayBankCodeMap.put("SNXS", "深圳农村商业银行");
		umpayBankCodeMap.put("SPDB", "浦东发展银行");
		umpayBankCodeMap.put("SXJS", "晋城市商业银行");
		umpayBankCodeMap.put("SPAB", "平安银行");
		umpayBankCodeMap.put("UPOP", "银联在线支付");
		umpayBankCodeMap.put("WZCB", "温州市商业银行");
	}

}

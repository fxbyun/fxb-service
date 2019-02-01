package domain.type;

import java.util.ArrayList;
import java.util.List;

public class AccountTypeConstant {
	/** 1：资金托管户下的会员户-站点 */
	public static int provider = 1;

	/** 2：资金托管户下的会员户 */
	public static int member = 2;
	
	/**3：中间账号*/
	public static int sysjoin = 3;
	
	/**4：中间账号2（提款中间账户）*/
	public static int sysjoin2 = 4;
	
	/**5:新浪代充,区别金额来源*/
	public static int sina_agent_charge = 5;
	
	/**6:新浪提款,区别金额来源*/
	public static int sina_getmoney = 6;
	
	
	/**7:企业户-基本户*/
	public static int enterprise = 7;
	/**8:企业户-准备金账户*/
	public static int enterprise_reserve= 8;
	
	private Integer index;
	
	private String desc;

	public AccountTypeConstant(Integer index, String desc) {
		super();
		this.index = index;
		this.desc = desc;
	}
	
	public static List<AccountTypeConstant> getAccountTypeConstantList(){
		List<AccountTypeConstant> list = new ArrayList<>();
		list.add(new AccountTypeConstant(AccountTypeConstant.provider,"站点"));
		list.add(new AccountTypeConstant(AccountTypeConstant.member,"会员户"));
		list.add(new AccountTypeConstant(AccountTypeConstant.sysjoin,"中间账号"));
		list.add(new AccountTypeConstant(AccountTypeConstant.sina_agent_charge,"新浪代充"));
		list.add(new AccountTypeConstant(AccountTypeConstant.sina_getmoney,"新浪提款"));
		list.add(new AccountTypeConstant(AccountTypeConstant.enterprise,"企业户-基本户"));
		list.add(new AccountTypeConstant(AccountTypeConstant.enterprise_reserve,"企业户-准备金账户"));
		list.add(new AccountTypeConstant(AccountTypeConstant.sysjoin2,"提款中间账号"));
		
		
		return list;
	}
	
	public static AccountTypeConstant getAccountTypeConstant(int index){
		List<AccountTypeConstant> list = getAccountTypeConstantList();
		for(AccountTypeConstant a:list){
			if(index==a.getIndex().intValue()){
				return a;
			}
		}
		return null;
	}
	/***
	 * 根据用户（普通会员、站点用户）类型返回账户类型
	 * @param userType
	 * @return
	 */
	public static Integer getAccountTypeByUserType(int userType){
		if(userType==UserType.buyer.getIndex()){
			return AccountTypeConstant.member;
		}else if(userType==UserType.seller.getIndex()){
			return AccountTypeConstant.provider;
		}
		return null;
	}
	/**
	 * 是否是企业账户类型
	 * @param accountType
	 * @return
	 */
	public static boolean isEnterpriseAccount(int accountType){
		if(AccountTypeConstant.enterprise==accountType || 
				AccountTypeConstant.enterprise_reserve == accountType){
			return true;
		}
		return false;
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

package domain.type;

import java.util.List;

/**
 * 用户类型-区分购彩，门店
 * 
 * @project didi-common
 * @author duannp
 * @date 2015年10月19日
 */
public class UserType extends BaseType {
	private static final long serialVersionUID = -4381322126225374226L;

	public UserType(Integer status, String description){
		super(status, description);
	}
	
	/** 彩票消费用户 */
    public static UserType buyer  = new UserType(1, "彩票消费用户");

    /** 彩票销售店主 */
    public static UserType seller = new UserType(2, "彩票销售店主");


    public static List<UserType> getAllList() {
		return getAll(UserType.class);
	}
    
	public static UserType valueOf(Integer index){
		return valueOf(UserType.class, index);
	}
	/***
	 * 根据新浪Id 得到账户类型 （站点\普通用户）
	 * @param sinaUserId
	 * @return
	 */
	public static Integer getUserTypeBySinaUserId(String sinaUserId){
		if(sinaUserId.startsWith("C")){
			return UserType.buyer.getIndex();
		}else if(sinaUserId.startsWith("P")){
			return UserType.seller.getIndex();
		}
		return null;
	}
}

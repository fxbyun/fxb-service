package domain.entity;

import java.io.Serializable;
import java.util.Calendar;

/**
 * 用户钱包查询参数
 *
 */
public class UsrWalletLogQueryOption implements Serializable {

	private static final long serialVersionUID = -5797949294525941729L;

	//用户类型  1:普通用户 2:出票点用户
	private Integer userType;
	
	// 用户ID
    private Long userId;

	//交易类型
	private Integer transType;
	
	private Integer[] transTypeList;

	//销售端
	private Integer sellClient;
	
	//交易开始时间
	private Calendar beginTime;

	//交易结束时间
    private Calendar endTime;
	
    // 彩种 
    private Integer gameId;

    // 彩期 
    private String issueNo;
    
    //方案编号
    private String planNo;
    
    //钱包流水编号
    private String walletLogNo;
    
    //用户帐号
    private String account ;
    
    /**父彩种*/
    private Integer parentGameId;
    
    //是否升级 0：未升级，1：已升级
    private Integer isUpdate;
    
    /**是否需要未统计,为null表示不需要*/
    private Integer isNotCount;
    
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getWalletLogNo() {
		return walletLogNo;
	}

	public void setWalletLogNo(String walletLogNo) {
		this.walletLogNo = walletLogNo;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getTransType() {
		return transType;
	}

	public void setTransType(Integer transType) {
		this.transType = transType;
	}

	public Integer getSellClient() {
		return sellClient;
	}

	public void setSellClient(Integer sellClient) {
		this.sellClient = sellClient;
	}

	public Calendar getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Calendar beginTime) {
		this.beginTime = beginTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public String getPlanNo() {
		return planNo;
	}

	public void setPlanNo(String planNo) {
		this.planNo = planNo;
	}

	public Integer getParentGameId() {
		return parentGameId;
	}

	public void setParentGameId(Integer parentGameId) {
		this.parentGameId = parentGameId;
	}

	public Integer getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Integer isUpdate) {
		this.isUpdate = isUpdate;
	}

	public Integer getIsNotCount() {
		return isNotCount;
	}

	public void setIsNotCount(Integer isNotCount) {
		this.isNotCount = isNotCount;
	}

	public Integer[] getTransTypeList() {
		return transTypeList;
	}

	public void setTransTypeList(Integer[] transTypeList) {
		this.transTypeList = transTypeList;
	}

}

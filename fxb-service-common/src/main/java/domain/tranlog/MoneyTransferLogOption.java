package domain.tranlog;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 钱划转记录
 * 
 * @author cxp
 *
 */
public class MoneyTransferLogOption implements Serializable {
	private static final long serialVersionUID = -3952257785635422097L;

	private Long id;
	
	/**划转计划ID*/
	private Long transferScheduleId;
	private Integer bizType;
	private List<Integer> bizTypes;
	private Integer bizTypeModel;//给admin用于区分1代收还是2代付的
	/**资金来源类型*/
	private Integer amountSourceType ;
	
	/**资金来源ID*/
	private String amountSourceId;
	
	/**
     * 划转响应
     */
    private String transferResponseMsg;
	
	/***划转帐户类型
	 * 1:内部账户转账操作
	 * 2:外部账户转账操作
	 * */
	private Integer accountInternalOrOuter ;
	
	/**来源帐户类型*/
	private Integer fromAccountType;
	private Integer accountType;
	/**来源账户ID*/
	private String fromAccountId;
	
	/**接收帐户类型*/
	private Integer toAccountType ;
	
	/**接收帐户ID*/
	private String toAccountId;
	
	/***划转金额*/
	private BigDecimal amount;
	
	/**划转状态*/
	private Integer transferStatus ;
	
	/**和对方关联号*/
	private Long uniqueIdToOuter;
	
	private Date beginCreateTime;
	
	private Date endCreateTime;
	
	private Date transferStatusBeginTime;
	private Date transferStatusEndTime;
	private String issueNo; // ; //彩期
	private String reIssueNo; //选填期数
	
	private String maxRaceId;
	
	public Date getTransferStatusBeginTime() {
		return transferStatusBeginTime;
	}
	public void setTransferStatusBeginTime(Date transferStatusBeginTime) {
		this.transferStatusBeginTime = transferStatusBeginTime;
	}
	public Date getTransferStatusEndTime() {
		return transferStatusEndTime;
	}
	public void setTransferStatusEndTime(Date transferStatusEndTime) {
		this.transferStatusEndTime = transferStatusEndTime;
	}
	public String getReIssueNo() {
		return reIssueNo;
	}
	public void setReIssueNo(String reIssueNo) {
		this.reIssueNo = reIssueNo;
	}
	public String getIssueNo() {
		return issueNo;
	}
	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}
	
	public String getMaxRaceId() {
		return maxRaceId;
	}
	public void setMaxRaceId(String maxRaceId) {
		this.maxRaceId = maxRaceId;
	}
	public Date getBeginCreateTime() {
		return beginCreateTime;
	}

	public void setBeginCreateTime(Date beginCreateTime) {
		this.beginCreateTime = beginCreateTime;
	}

	public Date getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(Date endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

	public Integer getBizType() {
		return bizType;
	}

	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public MoneyTransferLogOption(){
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTransferScheduleId() {
		return transferScheduleId;
	}

	public void setTransferScheduleId(Long transferScheduleId) {
		this.transferScheduleId = transferScheduleId;
	}

	public Integer getAmountSourceType() {
		return amountSourceType;
	}

	public void setAmountSourceType(Integer amountSourceType) {
		this.amountSourceType = amountSourceType;
	}


	public String getTransferResponseMsg() {
		return transferResponseMsg;
	}

	public void setTransferResponseMsg(String transferResponseMsg) {
		this.transferResponseMsg = transferResponseMsg;
	}

	public Integer getAccountInternalOrOuter() {
		return accountInternalOrOuter;
	}

	public void setAccountInternalOrOuter(Integer accountInternalOrOuter) {
		this.accountInternalOrOuter = accountInternalOrOuter;
	}

	public Integer getFromAccountType() {
		return fromAccountType;
	}

	public void setFromAccountType(Integer fromAccountType) {
		this.fromAccountType = fromAccountType;
	}

	public String getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public Integer getToAccountType() {
		return toAccountType;
	}

	public void setToAccountType(Integer toAccountType) {
		this.toAccountType = toAccountType;
	}

	public String getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(Integer transferStatus) {
		this.transferStatus = transferStatus;
	}

	public Long getUniqueIdToOuter() {
		return uniqueIdToOuter;
	}

	public void setUniqueIdToOuter(Long uniqueIdToOuter) {
		this.uniqueIdToOuter = uniqueIdToOuter;
	}
	public String getAmountSourceId() {
		return amountSourceId;
	}
	public void setAmountSourceId(String amountSourceId) {
		this.amountSourceId = amountSourceId;
	}
	public List<Integer> getBizTypes() {
		return bizTypes;
	}
	public void setBizTypes(List<Integer> bizTypes) {
		this.bizTypes = bizTypes;
	}
	public Integer getBizTypeModel() {
		return bizTypeModel;
	}
	public void setBizTypeModel(Integer bizTypeModel) {
		this.bizTypeModel = bizTypeModel;
	}
	
	
}

package domain.tranlog;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * 钱划转计划
 * 
 * @author cxp
 *
 */
public class MoneyTransferScheduleOption implements  Serializable{
	private static final long serialVersionUID = 4710196359268803928L;
	private Long id;
	/**
	 * 业务类型
	 */
	private Integer bizType ;
	/**
	 * 业务单类型
	 */
    private Integer  sourceBizorderType ;
    /**
     * 业务单id
     */
    private String sourceBizorderId;
    
    /**
     * 向外划转的模式
     * 1：先扣会员内部余额再扣外部余额
     * 2：先加会员外部余额再加内部余额
     * 3：与会员账户无关
     * */
    private Integer internalOuterMode ;
    /**
     * 内部划转状态
     * 0：刚创建/未进行
     * 1：进行中
     * 2：完成
     * 3：未明故障需人员介入
     * */
    private Integer internalTransferStatus ;
    private Integer oldInternalTransferStatus ;
    
    /**
     * 外部划转状态
     * 0：刚创建/未进行
     * 1：进行中
     * 2：完成
     * 3：未明故障需人员介入
     * */
    private Integer outerTransferStatus ;
    private Integer oldOuterTransferStatus ;
    
    /**
     * 划转日志状态
     * 0：刚创建,未分解transfer_log
     * 1：分解transfer_log 中
     * 2：分解transfer_log完成
     * 3：刚创建但不用预先分解transfer_log
     * */
    private Integer status ;
    private Integer oldStatus ;
	
	private Calendar createTime;
	private Calendar updateTime;
	
	private Date beginCreateTime;
	private Date endCreateTime;
	
	
	public Integer getOldInternalTransferStatus() {
		return oldInternalTransferStatus;
	}
	public void setOldInternalTransferStatus(Integer oldInternalTransferStatus) {
		this.oldInternalTransferStatus = oldInternalTransferStatus;
	}
	public Integer getOldOuterTransferStatus() {
		return oldOuterTransferStatus;
	}
	public void setOldOuterTransferStatus(Integer oldOuterTransferStatus) {
		this.oldOuterTransferStatus = oldOuterTransferStatus;
	}
	public Integer getOldStatus() {
		return oldStatus;
	}
	public void setOldStatus(Integer oldStatus) {
		this.oldStatus = oldStatus;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getBizType() {
		return bizType;
	}
	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}
	public Integer getSourceBizorderType() {
		return sourceBizorderType;
	}
	public void setSourceBizorderType(Integer sourceBizorderType) {
		this.sourceBizorderType = sourceBizorderType;
	}
	
	public String getSourceBizorderId() {
		return sourceBizorderId;
	}
	public void setSourceBizorderId(String sourceBizorderId) {
		this.sourceBizorderId = sourceBizorderId;
	}
	public Integer getInternalOuterMode() {
		return internalOuterMode;
	}
	public void setInternalOuterMode(Integer internalOuterMode) {
		this.internalOuterMode = internalOuterMode;
	}
	public Integer getInternalTransferStatus() {
		return internalTransferStatus;
	}
	public void setInternalTransferStatus(Integer internalTransferStatus) {
		this.internalTransferStatus = internalTransferStatus;
	}
	public Integer getOuterTransferStatus() {
		return outerTransferStatus;
	}
	public void setOuterTransferStatus(Integer outerTransferStatus) {
		this.outerTransferStatus = outerTransferStatus;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	public Calendar getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Calendar updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
}

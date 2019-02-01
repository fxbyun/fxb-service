package domain.entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class UsrOperationParam implements Serializable{
	private static final long serialVersionUID = 3048141209219716109L;

	/** ip地址 */
    private String operIp;

    /** app ip 即调用系统的ip */
    private String ipInfo;

    /** 客户端 */
    private int sellClient;

    /** 市场渠道 */
    private Long sellChannel;

	/**
	 * 操作备注
	 */
	private String opRemark="";
	/**是否是重派奖*/
	private boolean redo = false;

    /**
     * 客户端版本号
     */
    private String sellClientVersion="";

    /**操作平台：0：前台用户跟单，1:admin跟单 2:core后台跟单*/
    private int operPlatform = 0;
    /**
     * 是否能允许延后操作,false 不允许,true 允许
     */
    private boolean isCanDelayedOp=false;




    /**重复提交的token*/
    private long token = 0;


    /**
     *  广告行为串 key=statCodes
     */
    private Map<String, Object> dataChangeOpaque = new HashMap<String,Object>();

    /**
     * 由前端传入的machineId
     */
    private String machineId;

    /**
     * 由前端传入的clickStream
     */
    private String clickStreamId;


	/**输入支付密码 后返回页面地址**/
	private String payPwdReturnUrl;

	//绑卡管理-解绑：是否绕过余额的判断 ，默认0，需要判断，如果是1：绕过
	private Integer isValidBalance = 0;

	/***
	 * H5微信支付-要求要传递wap网址  和  网址名称
	 * 如果是app那么wapName代表应用名称
	 */
	private String wapName;
	/***
	 * H5微信支付-要求要传递wap网址  和  网址名称
	 * 如果是app那么wapUrl代表应用包路径
	 */
	private String wapUrl;

	/**
	 * 针对微信公众号支付的用户openId
	 */
	private String memberOpenId;

	/**是否在微信客户端内部发起*/
	private boolean isWXClient;
	/***
	 * 手机客户端型号
	 */
	private String clientModel;
	
	/** 第三方类型 */
    private Integer thirdType;
    
    /** 银行卡卡号 后四位*/
    private String bankAccountNo;
	
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	public Integer getIsValidBalance() {
		return isValidBalance;
	}
	public void setIsValidBalance(Integer isValidBalance) {
		this.isValidBalance = isValidBalance;
	}
	public UsrOperationParam() {
    }
	public UsrOperationParam(String opRemark) {
        this.opRemark = opRemark;
    }

    /**
     * 构造，用户界面操作时
     * @param operIp 用户ip
     * @param ipInfo 调用的系统ip
     * @param sellClient
     * @param sellChannel
     */
    public UsrOperationParam(String operIp, String ipInfo, int sellClient, Long sellChannel) {
        this.operIp = operIp;
        this.ipInfo = ipInfo;
        this.sellClient = sellClient;
        this.sellChannel = sellChannel;
    }
	/**
	 * 构造，用户界面操作时
	 * @param operIp
	 *            用户ip
	 * @param sellClient
	 * @param sellChannel
	 */
	public UsrOperationParam(String operIp, int sellClient, Long sellChannel) {
		this.operIp = operIp;
		this.sellClient = sellClient;
		this.sellChannel = sellChannel;
	}

    public UsrOperationParam(String operIp, int sellClient, Long sellChannel,
                             String sellClientVersion) {
		super();
		this.operIp = operIp;
		this.sellClient = sellClient;
		this.sellChannel = sellChannel;
		this.sellClientVersion = sellClientVersion;
	}
	public String getOperIp() {
        return operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    public String getIpInfo() {
        return ipInfo;
    }

    public void setIpInfo(String ipInfo) {
        this.ipInfo = ipInfo;
    }



    public String getOpRemark() {
		return opRemark;
	}
	public void setOpRemark(String opRemark) {
		this.opRemark = opRemark;
	}
	public boolean isRedo() {
		return redo;
	}
	public void setRedo(boolean redo) {
		this.redo = redo;
	}
	public Long getSellChannel() {
        return sellChannel;
    }



    public void setSellChannel(Long sellChannel) {
        this.sellChannel = sellChannel;
    }


    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

	public int getOperPlatform() {
		return operPlatform;
	}

	public void setOperPlatform(int operPlatform) {
		this.operPlatform = operPlatform;
	}



	public String getSellClientVersion() {
		return sellClientVersion;
	}

	public void setSellClientVersion(String sellClientVersion) {
		this.sellClientVersion = sellClientVersion;
	}



	public long getToken() {
		return token;
	}

	public void setToken(long token) {
		this.token = token;
	}



	public boolean isCanDelayedOp() {
		return isCanDelayedOp;
	}

	public void setCanDelayedOp(boolean isCanDelayedOp) {
		this.isCanDelayedOp = isCanDelayedOp;
	}





    public Map<String, Object> getDataChangeOpaque() {
    	if(dataChangeOpaque == null){
    		return new HashMap<String,Object>();
    	}
        return dataChangeOpaque;
    }

    public void setDataChangeOpaque(Map<String, Object> dataChangeOpaque) {
        this.dataChangeOpaque = dataChangeOpaque;
    }

	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}

	public String getClickStreamId() {
		return clickStreamId;
	}

	public void setClickStreamId(String clickStreamId) {
		this.clickStreamId = clickStreamId;
	}
	public int getSellClient() {
		return sellClient;
	}
	public void setSellClient(int sellClient) {
		this.sellClient = sellClient;
	}
	public String getPayPwdReturnUrl() {
		return payPwdReturnUrl;
	}
	public void setPayPwdReturnUrl(String payPwdReturnUrl) {
		this.payPwdReturnUrl = payPwdReturnUrl;
	}
	public void setPayPwdReturnUrlAddOrderId(long orderId){
		if(payPwdReturnUrl!=null ){
			if(payPwdReturnUrl.indexOf("?")==-1){
				payPwdReturnUrl = payPwdReturnUrl+"?oid="+orderId;
			}else{
				payPwdReturnUrl = payPwdReturnUrl+"&oid="+orderId;
			}
		}
	}
	public String getWapUrl() {
		return wapUrl;
	}
	public void setWapUrl(String wapUrl) {
		this.wapUrl = wapUrl;
	}
	public String getWapName() {
		return wapName;
	}
	public void setWapName(String wapName) {
		this.wapName = wapName;
	}
	public String getMemberOpenId() {
		return memberOpenId;
	}
	public void setMemberOpenId(String memberOpenId) {
		this.memberOpenId = memberOpenId;
	}
	public boolean isWXClient() {
		return isWXClient;
	}
	public void setWXClient(boolean isWXClient) {
		this.isWXClient = isWXClient;
	}
	public String getClientModel() {
		return clientModel;
	}
	public void setClientModel(String clientModel) {
		this.clientModel = clientModel;
	}
	public Integer getThirdType() {
		return thirdType;
	}
	public void setThirdType(Integer thirdType) {
		this.thirdType = thirdType;
	}

}

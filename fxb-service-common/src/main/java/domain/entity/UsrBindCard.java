package domain.entity;

import com.woqutz.didi.constants.*;
import domain.type.*;

import java.util.Date;

/**
 * 用户绑定银行卡
 * 
 */
public class UsrBindCard extends BaseEntity {
    private static final long serialVersionUID = -4963309338048803463L;

    /**用户类型：1购彩用户；2 站点用户*/
    private Integer userType = UserType.buyer.getIndex();

    /**用户或者站长ID*/
    private Long userId;

    /**钱包系统卡ID，绑卡返回的ID*/
    private String sinaCardId;

    /**银行名称，如中国工商银行*/
    private String bankName;

    /**银行卡号*/
    private String bankAccountNo;

    /**银行开户名*/
    private String accountName;

    /**卡类型*/
    private String cardType = CardType.debit;

    /**是否用户的默认卡：0 不是默认；1 是默认*/
    private Integer isDefault = 0;

    /**状态：0 未绑定；1 已绑定；2 绑定失败*/
    private Integer bindStatus = UsrBindCardStatus.not_bind;

    /**绑卡或者解绑备注*/
    private String remarks;

    /**绑卡成功时间(收到回调后更新这个字段)*/
    private Date bindTime;

    /**解绑成功时间(收到回调后更新这个字段)*/
    private Date unbindTime;

    /**创建时间*/
    private Date createTime;
    
    /** 最近充值成功时间 */
    private Date chargeTime;
    
    /** 最近提款成功时间 */
    private Date withDrawTime;
    
    /** 绑定银行卡支付方式,1:新浪，2:连连  {@link PaymentWay}*/
    private Integer paymentWay = 1;
    
    /** 银行编码 */
    private String bankCode;
 
    /** 开户行所在省编码 */
    private Integer provinceCode;
    
    /** 开户行所在市编码 */
    private Integer cityCode;
    
    /** 开户支行名称 */
    private String partBank;
    /**
     * 用户银行卡预留手机号
     * @return
     */
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /** 绑卡类型, 0:充值卡 1:提款卡  {@link BindCardType}*/
    private Integer bindCardType = BindCardType.charge;

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

    public String getSinaCardId() {
        return sinaCardId;
    }

    public void setSinaCardId(String sinaCardId) {
        this.sinaCardId = sinaCardId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getBindStatus() {
        return bindStatus;
    }

    public void setBindStatus(Integer bindStatus) {
        this.bindStatus = bindStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public Date getUnbindTime() {
        return unbindTime;
    }

    public void setUnbindTime(Date unbindTime) {
        this.unbindTime = unbindTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String getBankCodeSina(){
    	return BankCode.getBankCodeByName(bankName);
    }

    public Date getChargeTime() {
		return chargeTime;
	}

	public void setChargeTime(Date chargeTime) {
		this.chargeTime = chargeTime;
	}

	public Date getWithDrawTime() {
		return withDrawTime;
	}

	public void setWithDrawTime(Date withDrawTime) {
		this.withDrawTime = withDrawTime;
	}

	public Integer getPaymentWay() {
		return paymentWay;
	}

	public void setPaymentWay(Integer paymentWay) {
		this.paymentWay = paymentWay;
	}

	public Integer getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(Integer provinceCode) {
		this.provinceCode = provinceCode;
	}

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public String getPartBank() {
		return partBank;
	}

	public void setPartBank(String partBank) {
		this.partBank = partBank;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankCode() {
		return bankCode;
	}
	
	public Integer getBindCardType() {
		return bindCardType;
	}

	public void setBindCardType(Integer bindCardType) {
		this.bindCardType = bindCardType;
	}

	@Override
    public String toString() {
        return "UsrBindCard [userType=" + userType + ", userId=" + userId + ", sinaCardId=" + sinaCardId
                + ", bankName=" + bankName + ", bankAccountNo=" + bankAccountNo + ", accountName=" + accountName
                + ", cardType=" + cardType + ", isDefault=" + isDefault + ", bindStatus=" + bindStatus + ", remarks="
                + remarks + ", bindTime=" + bindTime + ", unbindTime=" + unbindTime + ", createTime=" + createTime
                + ", chargeTime=" + chargeTime + ", withDrawTime=" + withDrawTime + ", paymentWay=" + paymentWay
                + ", provinceCode=" + provinceCode + ", cityCode=" + cityCode + ", partBank=" + partBank + ", bindCardType=" + bindCardType
                + "]";
    }

}

package domain.entity;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import domain.entity.BaseEntity;
import domain.entity.UsrPay;
import domain.type.UserFlagBitConstant;
import domain.util.DateTools;

public class UsrConsumer extends BaseEntity {

    private static final long serialVersionUID = 3989163740541887191L;

    /** 账号 */
    private String account;

    /** 昵称 */
    private String nickname;

    /** 第三方用户昵称,比如微博昵称 */
    private String thirdNickName;

    /** 密码 */
    private String password;

    /** 联系电话 */
    private String phone;

    /** 电邮地址 */
    private String email;

    /** 用户状态 (0-正常,1-关闭)  UsrConsumerStatus*/
    private Integer status = 0;

    /** 注册时间 */
    private Date registerTime;

    /** 证件号码 */
    private String certNo;

    /** 最后登录时间*/
    private Date lastLoginTime;

    /** 真实姓名*/
    private String trueName;

    /** 实名认证状态  0没认证 1认证通过 （已作废） 状态走flagBit */
    private Integer authStatus;

    /** 用户支付信息 */
    private List<UsrPay> userPays;

    /**标记*/
    private Long flagBit = UserFlagBitConstant.defualt;

    /**对应flagBit标记版本*/
    private Integer flagVersion = 0;

    /** 微博关联账号的信息_性别 */
    private String gender;

    /** 微博关联账号的信息_省 */
    private String provinceName;

    /** 微博关联账号的信息_市区 */
    private String cityName;




    /***
     * 市场渠道
     */
    private long sellChannel;

    private Integer sellClient;// 客户端,0 WEB 1 WAP

    private String icon;		// 头像
    private Integer fansCount;	// 粉丝数
    private Integer followCount; // 关注数
    private String features="{}";	// json扩展
    private Integer featuresVersion;	// 扩展版本
    private String intro;	// 个人简介

    /** 手机的唯一标识码 */
    private String imei;
    /** 支付密码 */
    private String payPassword;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastLoginTime() {
        return DateTools.valid1970Return(lastLoginTime);
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public Integer getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(Integer authStatus) {
        this.authStatus = authStatus;
    }

    public List<UsrPay> getUserPays() {
        return userPays;
    }

    public void setUserPays(List<UsrPay> userPays) {
        this.userPays = userPays;
    }

    public String getSinaPayUserId() {
        return "C" + id;
    }

    public long getFlagBit() {
        return flagBit == null ? 0 : flagBit;
    }

    public void setFlagBit(Long flagBit) {
        this.flagBit = flagBit;
    }

    public int getFlagVersion() {
        return flagVersion == null ? 0 : flagVersion;
    }

    public void setFlagVersion(Integer flagVersion) {
        this.flagVersion = flagVersion;
    }

    public void addFlagBit(Long flagBit) {
        this.flagBit |= flagBit.longValue();
    }

    /**
     * 是否实名认证
     * @return
     */
    public boolean isIdentityVerify() {
        return UserFlagBitConstant.isExistFlagBit(UserFlagBitConstant.sina_identity, flagBit);
    }
    /***
     * 是否设置支付密码
     * @return
     */
    public boolean isSinaPayPassword() {
        return UserFlagBitConstant.isExistFlagBit(UserFlagBitConstant.sina_pay_password, flagBit);
    }


    public long getSellChannel() {
        return sellChannel;
    }

    public void setSellChannel(long sellChannel) {
        this.sellChannel = sellChannel;
    }

    public Integer getSellClient() {
        return sellClient;
    }

    public void setSellClient(Integer sellClient) {
        this.sellClient = sellClient;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getFansCount() {
        return fansCount;
    }

    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }

    public Integer getFollowCount() {
        return followCount;
    }

    public void setFollowCount(Integer followCount) {
        this.followCount = followCount;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features==null?"{}":features;
    }

    public Integer getFeaturesVersion() {
        return featuresVersion;
    }

    public void setFeaturesVersion(Integer featuresVersion) {
        this.featuresVersion = featuresVersion==null?0:featuresVersion;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public String getThirdNickName() {
        return thirdNickName;
    }

    public void setThirdNickName(String thirdNickName) {
        this.thirdNickName = thirdNickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setupFeature(String columnName, String value) {
        JSONObject jsonO=JSONObject.parseObject(features);
        jsonO.put(columnName, value);
        features=jsonO.toJSONString();
    }
    public void setupFeature(String columnName, Object value) {
        JSONObject jsonO=JSONObject.parseObject(features);
        jsonO.put(columnName, value);
        features=jsonO.toJSONString();
    }
    public void removeFeature(String columnName) {
        JSONObject jsonO=JSONObject.parseObject(features);
        jsonO.remove(columnName);
        features=jsonO.toJSONString();
    }
    public String getFeature(String columnName) {
        JSONObject jsonO=JSONObject.parseObject(features);
        return jsonO.getString(columnName);
    }
    @SuppressWarnings("unchecked")
    public <T> T getFeature(String columnName, Class<T> clz) {
        JSONObject jsonO=JSONObject.parseObject(features);
        return (T)jsonO.get(columnName);
    }
    /**
     * 是否迁移中
     * @return true 是迁移中  false 不是
     */
    public boolean isMigrationing() {
        return UserFlagBitConstant.isExistFlagBit(UserFlagBitConstant.migration_ing, flagBit);
    }
    /**
     * 是否迁移成功
     * @return true已迁移成功  false未迁移
     */
    public boolean isMigrationed() {
        return UserFlagBitConstant.isExistFlagBit(UserFlagBitConstant.migration_success, flagBit);
    }
    /**
     * 是否已执行迁移,已执行了迁移  就代表是新用户
     * @return true已执行迁移  false未执行迁移
     */
    public boolean isExecMigrationed() {
        if(UserFlagBitConstant.isExistFlagBit(UserFlagBitConstant.migration_ing, flagBit)
                || UserFlagBitConstant.isExistFlagBit(UserFlagBitConstant.migration_success, flagBit)){
            return true;
        }
        return false;
    }
}

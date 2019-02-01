package domain.entity;

import java.io.Serializable;
import java.util.Date;

/***
 * 用户钱包 备用扩展参数
 * @author zl
 *
 */
public class UsrWalletExpandParam implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static UsrWalletExpandParam defaultInstance=new UsrWalletExpandParam();
	
    /**类型对应的交易时间: 例如方案出票时间、提款成功时间等*/
    private Date logTime;
	
	
	public Date getLogTime() {
		return logTime;
	}


	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}


	public static UsrWalletExpandParam getDefaultInstance(){
		return defaultInstance;
	}
	
}

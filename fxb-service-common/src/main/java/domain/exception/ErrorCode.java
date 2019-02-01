package domain.exception;

import java.io.Serializable;

/**
 * 错误代码类
 */
public class ErrorCode implements Serializable {

    private static final long serialVersionUID = -2892956957010575101L;

    /**错误代码**/
    public String code;

    /**错误代码对应消息**/
    public String msg;
     
    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    
	public ErrorCode(String code, String msg) {
        this.msg = msg;
        this.code = code;
    }

}

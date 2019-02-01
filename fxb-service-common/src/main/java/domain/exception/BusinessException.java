package domain.exception;


/**
 * 核心平台统一的业务异常超类
 */
public class BusinessException extends RuntimeException {
    /**系统缺省编码*/
    public static final String BUSINESS_COMMON_ERROR = "business.common.error";

    private static final long serialVersionUID = -7673793242894704838L;
    protected ErrorCode code;

    public BusinessException(String message) {
        super(message);
        this.code = new ErrorCode(BusinessException.BUSINESS_COMMON_ERROR, message);

    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.code = new ErrorCode(BusinessException.BUSINESS_COMMON_ERROR, message);

    }

    public BusinessException(ErrorCode code) {
        super(code.getMsg());
        this.code = code;

    }

    public BusinessException(ErrorCode code, Throwable cause) {
        super(code.getMsg(), cause);
        this.code = code;

    }

    public BusinessException(String code, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.code = new ErrorCode(code, errorMsg);
    }

    public BusinessException(String code, String errorMsg) {
        super(errorMsg);
        this.code = new ErrorCode(code, errorMsg);
    }

    /**因为有不同的ErrorCode来区别不同的异常，所以不必用不同的BusinessException 来区别
     * 根据一个异常编码来获取异常描述
     * @return
     */
    public ErrorCode getErrorCode() {
        return code;
    }

    public String gerErorMsg() {
        return code.getMsg();
    }

    public String getCode() {
        return code.getCode();
    }
}

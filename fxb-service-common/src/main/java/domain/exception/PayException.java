package domain.exception;

public class PayException extends BusinessException {

    private static final long serialVersionUID = 8789377998325116782L;

    public PayException(String message) {
        super(message); 
    }
    
    public PayException(ErrorCode code) {
        super(code);
        this.code = code;
    }

    

	public PayException(String code, String errorMsg) {
		super(code, errorMsg);
	}

	@Override
    public ErrorCode getErrorCode() {
        return code;
    }

}

package domain.exception;

/**
 * 钱包异类
 * 
 * @project commonsTiger
 * @author alanpeng
 * @date Nov 24, 2010
 * Copyright (C) 2010-2012 www.2caipiao.com Inc. All rights reserved.
 */
public class WalletException extends BusinessException {

    private static final long serialVersionUID = 8789377998325116782L;

    public WalletException(String message) {
        super(message); 
    }
    
    public WalletException(ErrorCode code) {
        super(code);
        this.code = code;
    }
    public WalletException(ErrorCode code, Throwable cause) {
        super(code,cause);
    }
    @Override
    public ErrorCode getErrorCode() {
        return code;
    }

}

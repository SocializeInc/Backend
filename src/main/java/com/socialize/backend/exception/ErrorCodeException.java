package com.socialize.backend.exception;

import com.socialize.backend.util.ErrorCode;

import java.io.IOException;

public class ErrorCodeException extends IOException {

    private static final long serialVersionUID = 1L;
    private final ErrorCode errorCode;

    public ErrorCodeException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String toString() {
        return "ErrorCodeException{" +
                "errorCode=" + errorCode +
                '}';
    }
}

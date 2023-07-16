package com.socialize.backend.controller.dto.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.socialize.backend.util.ErrorCode;

import java.util.Arrays;
import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseAccountResponse implements ErrorCodeResponse {

    private int result = ErrorCode.OK.getCode();

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public void addErrorCode(ErrorCode errorCode) {
        setResult(errorCode.getCode());
    }

    private static ErrorCode getFirstErrorCode(Collection<ErrorCode> errorCodes) {
        ErrorCode firstErrorCode = null;

        if (errorCodes != null && errorCodes.size() > 0) {
            firstErrorCode = errorCodes.iterator().next();
        }

        return firstErrorCode;
    }
}

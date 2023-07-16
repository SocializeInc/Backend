package com.socialize.backend.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum ErrorCode {
    OK(0),
    NOK(999),
    GENERAL_ERROR(5000),
    INVALID_USER_PRINCIPAL(4);
    
    private static ConcurrentHashMap<Integer, ErrorCode> cache;
    private int code;

    private static Map<Integer, ErrorCode> getCache() {
        Class var0 = ErrorCode.class;
        synchronized (ErrorCode.class) {
            if (cache == null) {
                cache = new ConcurrentHashMap();
            }
        }

        return cache;
    }

    private static void addToCache(ErrorCode ec) {
        getCache().put(ec.getCode(), ec);
    }

    private ErrorCode(int code) {
        this.code = code;
        addToCache(this);
    }

    @JsonValue
    public int getCode() {
        return this.code;
    }

    @JsonCreator
    public static ErrorCode value(int code) {
        return (ErrorCode)cache.get(code);
    }
}

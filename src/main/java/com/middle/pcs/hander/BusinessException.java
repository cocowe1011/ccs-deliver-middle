package com.middle.pcs.hander;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;

public class BusinessException extends RuntimeException {
    private static final Logger log = LoggerFactory.getLogger(BusinessException.class);
    private String code;
    private String prefix;
    private static final String REPLACE_STR = "$";

    public static BusinessException build(IErrorCode errorCode, String... params) {
        return new BusinessException(errorCode.prefix(), errorCode.getCode(), executeMsg(errorCode.getMsg(), params), params);
    }

    public static BusinessException build(String prefix, String code, String message, String... params) {
        return new BusinessException(prefix, code, message, params);
    }

    private static String executeMsg(String msg, String... params) {
        try {
            if (msg.contains("$") && params != null && params.length > 0) {
                for(int i = 0; i < params.length; ++i) {
                    String param = params[i];
                    if (param != null) {
                        msg = msg.replaceAll("\\$" + (i + 1), Matcher.quoteReplacement(param));
                    }
                }
            }

            return msg;
        } catch (Exception var4) {
            log.error("invoke executeMsg error", var4);
            return msg;
        }
    }

    protected BusinessException(String prefix, String code, String message, String[] params) {
        super(executeMsg(message, (String[])null));
        this.prefix = prefix;
        this.code = code;
    }

    protected BusinessException(IErrorCode errorCode) {
        super(executeMsg(errorCode.getMsg(), (String[])null));
        this.prefix = errorCode.prefix();
        this.code = errorCode.getCode();
    }

    protected BusinessException(IErrorCode errorCode, String... params) {
        super(executeMsg(errorCode.getMsg(), params));
        this.prefix = errorCode.prefix();
        this.code = errorCode.getCode();
    }

    public static void main(String[] args) {
        String msg = "test,$1";
        String abc = executeMsg(msg, Matcher.quoteReplacement(""));
        System.out.println(abc);
    }

    public String getCode() {
        return this.code;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setPrefix(final String prefix) {
        this.prefix = prefix;
    }
}

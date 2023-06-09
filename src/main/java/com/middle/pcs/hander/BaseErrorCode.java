package com.middle.pcs.hander;

public enum BaseErrorCode implements IErrorCode {
    SUCCESS("0000", "成功"),
    FALLBACK("system@9998", "系统错误,$1"),
    SYSTEM_ERROR("system@9999", "系统繁忙");

    private String code;
    private String msg;

    public String prefix() {
        return "";
    }

    private BaseErrorCode(final String code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
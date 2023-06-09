package com.middle.pcs.hander;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessMsg implements IErrorCode {
    /**
     * 自定义成功
     */
    CCS_SUCCESS("0000","成功！");

    @Override
    public String prefix() {
        return "ccs";
    }

    private final String code;
    private final String msg;
}

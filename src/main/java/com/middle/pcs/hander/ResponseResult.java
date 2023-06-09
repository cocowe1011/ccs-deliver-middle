package com.middle.pcs.hander;


import com.alibaba.fastjson.JSON;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class ResponseResult<T> implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(ResponseResult.class);
    private static final long serialVersionUID = -5858147992383769655L;
    /**
     * 标记是否成功
     */
    private boolean success;
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 业务对象，继承自BaseEntity
     */
    private T data;

    private static <T> ResponseResult build(IErrorCode code, T data, String[] params) {
        return build(code, (String)null, ResponseLevelEnum.INFO, data, params);
    }

    private static <T> ResponseResult build(IErrorCode code, String service, ResponseLevelEnum level, T data, String[] params) {
        ResponseResult result = new ResponseResult();
        result.setSuccess(code.getCode().equals(BaseErrorCode.SUCCESS.getCode()) ? Boolean.TRUE : Boolean.FALSE);
        if (StringUtils.isEmpty(code.prefix())) {
            result.setCode(code.getCode());
        } else {
            result.setCode(code.prefix() + "@" + code.getCode());
        }

        String msg = code.getMsg();
        if (msg.contains("$") && params != null && params.length > 0) {
            for(int i = 0; i < params.length; ++i) {
                String param = params[i];
                msg = msg.replaceAll("\\$" + (i + 1), param);
            }
        }
        result.setMessage(msg);
        result.setData(data);
        return result;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

    public static <T> ResponseResult<T> success(T data) {
        return build(BaseErrorCode.SUCCESS, data, (String[])null);
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setData(final T data) {
        this.data = data;
    }
}


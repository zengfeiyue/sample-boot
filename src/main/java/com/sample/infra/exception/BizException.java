package com.sample.infra.exception;


import com.sample.infra.enums.BaseResponse;

/**
 * 自定义业务异常
 *
 * @author zengfeiyue
 **/
public class BizException extends RuntimeException implements BaseResponse {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected Integer code;
    /**
     * 错误信息
     */
    protected String msg;
    /**
     * 提示数据
     */
    protected Object data;

    public BizException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException(Integer code, String msg, Object data) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public Object getData() {
        return code;
    }
}

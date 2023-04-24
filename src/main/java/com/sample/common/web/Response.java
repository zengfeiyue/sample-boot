package com.sample.common.web;
import com.sample.common.enums.BaseResponse;
import com.sample.common.enums.ResponseEnum;
import java.io.Serializable;

/**
 * 通用返回实体
 *
 * @author laiqiao
 */
public class Response<T> implements BaseResponse,Serializable {
    /**
     * 响应代码
     */
    private Integer code;

    /**
     * 响应提示信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;

    public Response(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Response error() {
        return new Response(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getMsg());
    }

    public static Response warn(BaseResponse responseEnum) {
        return new Response(responseEnum.getCode(), responseEnum.getMsg());
    }

    public static Response success(Object result) {
        return new Response(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(), result);
    }

    public static Response errorFormat(BaseResponse exception, Object... params) {
        return new Response(exception.getCode(), String.format(exception.getMsg(), params));
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

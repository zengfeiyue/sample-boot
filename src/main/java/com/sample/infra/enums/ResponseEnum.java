package com.sample.infra.enums;

/**
 * 系统代码枚举
 *
 * @author zengfeiyue
 */

public enum ResponseEnum implements BaseResponse {
    /**
     * Parameter传参，请求参数缺失异常
     */
    MISSING_SERVLET_REQUEST_PARAMETER(460, "请求参数缺失异常，参数名：%s，类型为：%s"),

    /**
     * 请求数据经过httpMessageConverter出错
     */
    HTTP_MESSAGE_CONVERTER_ERROR(461, "请求Json数据格式错误或Json字段格式转化问题"),

    /**
     * 无法映射枚举类型
     */
    ENUM_CONVERTER_ERROR(461, "%s 超出枚举的限定范围"),

    /**
     * 参数校验失败
     * <p>
     * 拦截@Valid和@Validated校验失败返回的错误提示
     */
    VALIDATED_RESULT_ERROR(462, "参数校验失败，请检查参数的传值是否正确，具体信息：%s"),

    /**
     * 不受支持的媒体类型
     */
    HTTP_MEDIA_TYPE_NOT_SUPPORT(415, "请求的http media type不合法"),

    /**
     * 不受支持的http请求方法
     */
    HTTP_METHOD_NOT_SUPPORT(405, "当前接口不支持%s方式请求"),

    /**
     * 成功
     */
    SUCCESS(200, "处理成功"),

    /**
     * 失败
     */
    ERROR(500, "系统异常"),;

    /**
     * 错误编码
     */
    private final Integer code;

    /**
     * 提示用户信息
     */
    private final String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }


    @Override
    public Object getData() {
        return null;
    }
}

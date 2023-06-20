package com.sample.infra.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.sample.infra.enums.ResponseEnum;
import com.sample.infra.common.web.Response;
import com.sample.infra.enums.BaseResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;

/**
 * 全局统一异常处理类
 *
 * @author zengfeiyue
 *
 **/
@RestControllerAdvice
public class GlobalExceptionAdvice {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionAdvice.class);

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(value = Throwable.class)
    public Response handleException(Throwable e) {
        logger.error("系统异常：", e);
        return Response.error();
    }

    /**
     * 统一捕获业务异常
     *
     * @param e 自定义业务异常对象
     * @return 中台统一响应体
     */
    @ExceptionHandler({BizException.class})
    public Response handleBizException(BizException e) {
        return Response.warn(e);
    }

    /**
     * 请求参数缺失异常
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Response missingParam(MissingServletRequestParameterException exception) {
        String parameterName = exception.getParameterName();
        String parameterType = exception.getParameterType();
        logger.error("Parameter传参，请求参数缺失异常，参数名：" + parameterName + "，参数类型：" + parameterType);
        return renderResponse(ResponseEnum.MISSING_SERVLET_REQUEST_PARAMETER, parameterName, parameterType);
    }

    /**
     * HttpMessageConverter转化异常，一般为json解析异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response httpMessageNotReadable(HttpMessageNotReadableException exception) {
        //检查是否属于枚举类型转换错误，并给出响应的提示信息
        Response checkResult = this.checkEnumConverter(exception);
        if (checkResult != null) {
            return checkResult;
        }
        logger.error("参数格式传递异常，具体信息为：{}", exception.getMessage());
        return renderResponse(ResponseEnum.HTTP_MESSAGE_CONVERTER_ERROR);
    }

    /**
     * 检查是否属于枚举类型转换错误
     */
    private Response checkEnumConverter(HttpMessageNotReadableException exception) {
        Throwable cause = exception.getCause();
        if (cause instanceof InvalidFormatException) {
            InvalidFormatException e = (InvalidFormatException) cause;
            Class<?> targetType = e.getTargetType();
            if (targetType.isEnum()) {
                List<JsonMappingException.Reference> path = e.getPath();
                String fieldName = path.get(0).getFieldName();
                logger.error("枚举类型映射错误，具体信息为：{}", exception.getMessage());
                return renderResponse(ResponseEnum.ENUM_CONVERTER_ERROR, fieldName);
            }
        }
        return null;
    }

    /**
     * 拦截不支持媒体类型异常
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Response httpMediaTypeNotSupport(HttpMediaTypeNotSupportedException exception) {
        logger.error("请求的http media type不合法：{}", exception.getMessage());
        return renderResponse(ResponseEnum.HTTP_MEDIA_TYPE_NOT_SUPPORT);
    }

    /**
     * 不受支持的http method
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response methodNotSupport(HttpServletRequest request) {
        String httpMethod = request.getMethod().toUpperCase();
        return renderResponse(ResponseEnum.HTTP_METHOD_NOT_SUPPORT, httpMethod);
    }

    /**
     * 请求参数校验失败，拦截 @Valid 校验失败的情况
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response methodArgumentNotValidException(MethodArgumentNotValidException e) {
        String bindingResult = this.getArgNotValidMessage(e.getBindingResult());
        logger.error("数据校验失败：{}", bindingResult);
        return renderResponse(ResponseEnum.VALIDATED_RESULT_ERROR, bindingResult);
    }

    /**
     * 请求参数校验失败，拦截 @Validated 校验失败的情况
     * <p>
     * 两个注解 @Valid 和 @Validated 区别是后者可以加分组校验，前者没有分组校验
     */
    @ExceptionHandler(BindException.class)
    public Response bindException(BindException e) {
        String bindingResult = this.getArgNotValidMessage(e.getBindingResult());
        logger.error("数据校验失败：{}", bindingResult);
        return renderResponse(ResponseEnum.VALIDATED_RESULT_ERROR, bindingResult);
    }

    /**
     * 获取请求参数不正确的提示信息
     * <p>
     * 多个信息，拼接成用逗号分隔的形式
     */
    private String getArgNotValidMessage(BindingResult bindingResult) {
        if (bindingResult == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        //多个错误用逗号分隔
        List<ObjectError> allErrorInfoList = bindingResult.getAllErrors();
        for (ObjectError error : allErrorInfoList) {
            stringBuilder.append(";").append(error.getDefaultMessage());
        }
        //最终把首部的分号去掉
        return stringBuilder.toString();
    }

    private Response renderResponse(BaseResponse responseEnum) {
        return Response.warn(responseEnum);
    }

    private Response renderResponse(BaseResponse exception, Object... params) {
        return Response.errorFormat(exception,params);
    }

}

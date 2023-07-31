package com.sample.infra.web;

import com.sample.infra.annotation.IgnoreResponseBodyAdvice;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一对象返回
 *
 * @author zengfeiyue
 *
 **/
@ControllerAdvice
public class CommonResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter parameter, Class<? extends HttpMessageConverter<?>> clazz) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object result, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (result instanceof Response<?>) {
            return result;
        }

        //若类或方法上存在跳过注解，则跳过
        Class<?> declaringClass = methodParameter.getDeclaringClass();
        boolean clazzHasAnnotation = declaringClass.isAnnotationPresent(IgnoreResponseBodyAdvice.class);
        boolean methodHasAnnotation = methodParameter.hasMethodAnnotation(IgnoreResponseBodyAdvice.class);
        if (clazzHasAnnotation || methodHasAnnotation) {
            return result;
        }

        return Response.success(result);
    }
}

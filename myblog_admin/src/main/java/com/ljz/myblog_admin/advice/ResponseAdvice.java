package com.ljz.myblog_admin.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljz.myblog_admin.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @ClassName : ResponseAdvice
 * @Description : 统一处理返回值/响应体，一般用来统一返回格式
 * @Author : ljz
 * @Date: 2022/7/3  16:27
 */

// 改类会拦截所有带 @RestController 注解的类 swagger的 ApiResourceController 类被拦截

@RestControllerAdvice(basePackages = "com.ljz.myblog_admin.controller")
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }


    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof String) {
            try {
                return objectMapper.writeValueAsString(ResultData.success(o));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        if (o instanceof ResultData) {
            return o;
        }
        return ResultData.success(o);
    }
}
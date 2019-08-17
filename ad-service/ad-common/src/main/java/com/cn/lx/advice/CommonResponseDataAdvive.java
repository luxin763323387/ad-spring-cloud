package com.cn.lx.advice;

import com.cn.lx.annotation.IgnoreResponseAdvice;
import com.cn.lx.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * 响应的同一拦截
 * @author StevenLu
 * @date 2019/7/20
 */
@RestControllerAdvice
public class CommonResponseDataAdvive implements ResponseBodyAdvice<Object> {

    /**
     * <h2>判断是否需要响应处理</h2>
     * @param methodParameter
     * @param aClass
     * @return false 不需要处理 true 需要处理
     */
    @Override
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        if(methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }
        if(Objects.requireNonNull(methodParameter.getMethod()).isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }

        return true;
    }

    /**
     * <h2>响应返回之前的处理</h2>
     * @param o 响应对象
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

        CommonResponse<Object> response = new CommonResponse<>(0,"");

        if (null == o){
            return response;
        }else if(o instanceof CommonResponse){
            response  = (CommonResponse<Object>) o;
        }else {
            response.setData(o);
        }
        return response;
    }
}

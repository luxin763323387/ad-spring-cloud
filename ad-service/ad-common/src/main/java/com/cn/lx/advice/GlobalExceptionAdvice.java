package com.cn.lx.advice;

import com.cn.lx.exception.AdException;
import com.cn.lx.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author StevenLu
 * @date 2019/7/20
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 对指定的异常进行拦截
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handlerAdException(HttpServletRequest request, AdException ex){
        CommonResponse<String> commonResponse = new CommonResponse<>(-1,"business error");
        commonResponse.setData(ex.getMessage());
        return commonResponse;
    }
}

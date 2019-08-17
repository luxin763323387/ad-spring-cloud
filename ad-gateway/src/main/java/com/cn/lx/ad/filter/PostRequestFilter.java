package com.cn.lx.ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author StevenLu
 * @date 2019/7/20
 */
@Slf4j
@Component
public class PostRequestFilter  extends ZuulFilter {
    /**
     * 定义filter类型
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    /**
     * filter顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER-1;
    }

    /**
     * 是否执行过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * filter执行的具体操作
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();
        Long startTime = (Long) requestContext.get("startTime");
        Long result =  System.currentTimeMillis() - startTime;
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        String requestURI = httpServletRequest.getRequestURI();

        log.info("uri:" + requestURI + ",result" + result/100 + "ms");

        return null;
    }
}

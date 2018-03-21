package com.czd.serviceZuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * 过滤器
 *
 * @author: czd
 * @create: 2018/3/21 16:14
 */
@Component
public class MyFilter extends ZuulFilter {
    private static Logger log= org.slf4j.LoggerFactory.getLogger(MyFilter.class);

    /**
     * 过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤周期
     * 1 pre :路由之前 routing :路由之时 post:路由之后 error:发生错误时
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 是否需要过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤的具体规则
     * @return
     */
    @Override
    public Object run() {
        //判断是否传入token参数
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        log.info(String.format("%s >>> %s",request.getMethod(),request.getRequestURL().toString()));
        Object accessToken=request.getParameter("token");
        if(accessToken == null){
            log.warn("token id empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("ok");
        return null;
    }
}

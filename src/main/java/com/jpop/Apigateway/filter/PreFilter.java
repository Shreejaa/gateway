package com.jpop.Apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import javax.servlet.http.HttpServletRequest;


public class PreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }
    @Override
    public int filterOrder() {
        return 1;
    }
    @Override
    public boolean shouldFilter() {
        return true;
    }
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        ctx.addZuulRequestHeader("Authorization",
                request.getHeader("Authorization"));
       System.out.println(String.format("%s request to %s", request.getMethod(),
                request.getRequestURL().toString()));
        return null;
    }
}
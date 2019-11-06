package com.mzyupc.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author mzyupc@163.com
 * @date 2019/11/6 14:41:21
 */
@Component
public class MyFilter1 extends ZuulFilter {

    /**
     * 类型包含 pre, post, route, error
     * pre: 代表在路由代理之前执行
     * route: 代表代理的时候执行
     * error: 代表出现错误的时候执行
     * post: 代表在route或者是error执行完成后执行
     *
     * @return
     */
    @Override
    public String filterType() {
        // 路由代理之前执行(前置过滤器)
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 优先级: 数字越大, 优先级越低
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否执行该过滤器, true 代表需要过滤
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("过滤器 MyFilter1");
        // 模拟拦截
//        RequestContext currentContext = RequestContext.getCurrentContext();
//        HttpServletRequest request = currentContext.getRequest();
//        String token = request.getParameter("token");
//        if(StringUtils.isEmpty(token)){
//            currentContext.setSendZuulResponse(false);
//            currentContext.setResponseStatusCode(401);
//            try {
//                currentContext.getResponse().getWriter().println("token error");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        return null;
    }
}

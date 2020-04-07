package com.mly.mango.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author wyn
 * @Description 自定义filter
 * @date 2020-04-07 19:20
 * 逻辑：
 * 创建一个MyFilter，继承ZuulFilter类，覆写run()方法逻辑，
 * 在转发请求前进行token认证，如果请求没有携带token，
 * 返回"there is no requesttoken"提示。
 */

@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        /**
         * PRE：这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等。
         * ROUTING：这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用Apache HttpClient或Netfilx Ribbon请求微服务。
         * POST：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的HTTPHeader、收集统计信息和指标、将响应从微服务发送给客户端等。
         * ERROR：在其他阶段发生错误时执行该过滤器。
         */
        return "pre"; //定义filter的类型，有pre,route,post,error四种
    }

    @Override
    public int filterOrder() {
        return 0; //定义filter的顺序，数字越小，表示顺序越高，越先执行
    }

    @Override
    public boolean shouldFilter() {
        return true; //表示是否需要执行该filte，true表示执行，false表示不执行
    }

    @Override
    public Object run() throws ZuulException {
        //filter需要执行的具体操作
        //获取上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        //拿到token
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        System.out.println("token:"+token);
        if(token==null){

            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {

                ctx.getResponse().getWriter().write("there is no request token");
            }catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        return null;
    }
}

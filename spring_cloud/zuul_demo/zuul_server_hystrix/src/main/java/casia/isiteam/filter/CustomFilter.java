package casia.isiteam.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: CustomFilter
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2022/4/11
 * Email: zhiyou_wang@qq.com
 */

/**
 * 网关过滤器
 */
@Component
public class CustomFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        System.out.println("customFilter...method="+request.getMethod()+", url="+request.getRequestURI().toString());
        return null;
    }
}

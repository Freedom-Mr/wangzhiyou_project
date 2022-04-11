package casia.isiteam.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: AccessFilter
 * Description: 权限验证过滤器
 * <p>
 * Created by casia.wzy on 2022/4/11
 * Email: zhiyou_wang@qq.com
 */

/**
 * 权限验证过滤器
 */
@Component
public class AccessFilter extends ZuulFilter {
    private static final Logger logger =  LoggerFactory.getLogger(AccessFilter.class);
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
        // 获取表单中的 token
        String token = request.getParameter("token");
        // 业务逻辑处理
        if( null == token ){
            logger.warn("token is null ...");
            // 请求结果，不在继续往下请求
            rc.setSendZuulResponse(false);
            // 响应状态码，HTTP 401错误代表用户没有访问权限
            rc.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            // 响应类型
            rc.getResponse().setContentType("application/json; charset=utf-8");
            PrintWriter writer = null;
            try {
                writer = rc.getResponse().getWriter();
                // 响应内容
                writer.print("{\"message\":\""+HttpStatus.UNAUTHORIZED.getReasonPhrase()+"\"}");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (null!= writer){
                    writer.close();
                }
            }
        }else {
            // 身份验证
            logger.info("token is ok");
        }
        return null;
    }
}

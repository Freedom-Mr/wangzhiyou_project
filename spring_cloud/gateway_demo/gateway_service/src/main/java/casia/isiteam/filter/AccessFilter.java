package casia.isiteam.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * @ClassName: AccessFilter
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/12
 * Email: zhiyou_wang@foxmail.com
 */

/**
 * 全局鉴权过滤器
 */
@Component
public class AccessFilter implements GlobalFilter, Ordered {
    private final static Logger log = LoggerFactory.getLogger(AccessFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
       /* //获取请求参数
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        // 业务逻辑处理
        if (null == token){
            log.warn("token is null");
            ServerHttpResponse response = exchange.getResponse();
            // 响应类型
            response.getHeaders().add("Content-Type","application/json; charset=UTF-8");
            // 响应状态码, HTTP 401 错误代表用户没有权限访问
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            // 响应内容
            String message = "message:"+HttpStatus.UNAUTHORIZED.getReasonPhrase();
            DataBuffer buffer = response.bufferFactory().wrap(message.getBytes());
            // 请求结果
            return response.writeWith(Mono.just(buffer));
        }
        log.info("token is ok");*/
        return chain.filter(exchange);//向下执行
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

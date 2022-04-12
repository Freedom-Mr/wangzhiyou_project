package casia.isiteam.config;

import casia.isiteam.filter.CustomGatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: GatewayRoutesConfiguration
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/12
 * Email: zhiyou_wang@foxmail.com
 */
@Configuration
public class GatewayRoutesConfiguration {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes().route(r-> r
                // 断言 （判断条件）
                .path("prodcut/**")
                // 目标 URI ，路由到微服务的地址
                .uri("lb://serviceGatewayProvider")
                // 注册自定义网关过滤器
                .filter(new CustomGatewayFilter())
                // 路由ID，唯一
                .id("serviceGatewayProvider1"))
                .build();
    }
}

# netflix zuul 路由网关规则
==================================

## 请先启动 eureka_demo 项目中的服务注册中心
1. eureka_demo -> eureka_server
2. eureka_demo -> eureka02_server
3. sentinel_demo -> service_sentinel_provider

## zuul 配置路由规则
- zuul_server
1. URL 地址路由
2. 服务名称路由
   > 加入 spring-cloud-starter-netflix-eureka-client
            
- 简化路由配置
    > 注释配置 zuul:routes: xxx
## 路由排除
- zuul_server
1. url路由排除
    > 增加配置 zuul:ignored-patterns:
2. 服务名称排除
    > 增加配置 zuul:ignored-services

## 路由前缀
- zuul_server
- 增加配置 zuul:prefix: 

## 网关过滤器
- zuul_server_filter
1. pre: 请求被路由到源服务器之前执行的过滤器
- 身份认证
- 选路由
- 请求日志
2. routing: 处理将请求发送到源服务器的过滤器
3. post: 响应从源服务器返回时执行的过滤器
- 对响应增加HTTP头
- 收集统计和度量指标
- 将响应以流的方式发送回客户端
4. error: 上述阶段中出现错误时执行的过滤器

## zuul 与 hystrix 整合
- zuul_server_hystrix
1. 网关监控
2. 网关熔断
3. 网关限流
   - 计数器算法
   - 漏桶算法
   - 令牌桶算法

## zuul 与 Sentinel 整合


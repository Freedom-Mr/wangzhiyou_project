# netflix zuul 路由网关规则
==================================

## 请先启动 eureka_demo 项目中的服务注册中心
1. eureka_demo -> eureka_server
2. eureka_demo -> eureka02_server

3. gateway_demo -> gateway_prodcut_service

## Gateway 实现API 网关
- gateway_demo -> gateway_service

1. 核心概念
 - 路由
 - 断言
 - 过滤器

2. 工作原理

3. 路由规则
 - Path
 - Query
 - Method
 - Datetime
 - RemoteAddr
 - Header

4. 动态路由
 - 加入 spring-cloud-starter-netflix-eureka-client 包
 - 动态获取URL   配置 uri: lb//服务名
 - 服务名称转发   配置 discovery: locator: **

5. 过滤器
 - 配置文件，配置 spring:cloud:gateway:routes:routes:filters 参数
 - Path 路径过滤器
    > RewritePath 方式
   
    > PrefixPath 方式
   
    > StripPrefix 方式
   
    > SetPath 方式
 
 - Parameter 参数过滤器
 - status 状态过滤器

6. 自定义网关过滤器
 - CustomGatewayFilter.class
7. 自定义全局过滤器
 - CustomGlobalFilter.class
8. 自定义全局权限过滤器
 - AccessFilter.class


## 请求
 - http://localhost:9000/product/1
 - http://localhost:9000/serviceGatewayProvider/product/1
 - http://localhost:9000/api-gateway/product/1
#  服务注册 demo
1. eureka_demo：netflix eureka 服务注册
2. consul_demo：consul 服务注册
3. zookeeper_demo：apache zookeeper 服务注册
4. Nacos_demo：阿里 nacos 服务注册

## 负载均衡demo
1. eureka_demo -> service_consumer： netflix ribbon 负载均衡
2. feign_demo -> service_feign_consumer： netflix feign (内置ribbon) 负载均衡

## 服务管理，熔断、降级
1. hystrix_demo： netflix hystrix 已停止维护
2. sentinel_demo： 阿里巴巴研发，是一款高性能且轻量级的流量控制、熔断降级的可替代方案。

## 网关
1. zuul_demo: netflix zuul 网关
2. gateway_demo: springCloud gateway 网关


## 高可用集群
- 集群部署
- 负载均衡  nginx
- 健康检查
- 节点自动重启
- 熔断
- 服务降级
- 接口重试
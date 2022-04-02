#  服务注册 demo
1. eureka_demo：netflix eureka 服务注册
2. consul_demo：consul 服务注册
3. zookeeper_demo：apache zookeeper 服务注册
4. Nacos_demo：阿里 nacos 服务注册

## 负载均衡demo
1. eureka_demo -> service_consumer： netflix ribbon 负载均衡
2. feign_demo -> service_feign_consumer： netflix feign (内置ribbon) 负载均衡

## 服务管理，熔断、降级
1. hystrix_demo -> 
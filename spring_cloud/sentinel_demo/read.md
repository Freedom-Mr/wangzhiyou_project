# 阿里 sentinel 服务管理
==================================

## 请先启动 eureka_demo 项目中的服务注册中心
1. eureka_demo -> eureka_server
2. eureka_demo -> eureka02_server

## 启动 sentinel 控制台
- 执行 software 文件下的 run.bat 脚本

## 定义规则
- service_sentinel_consumer
- 需要注释 RestTemplate 的 @SentinelRestTemplate 注解
1. 流量控制规则
2. 熔断降级规则
3. 动态规则扩展
  > flowRule.json 文件

## RestTemplate 注解
- service_sentinel_consumer
- 需要注释定义规则中的 @SentinelResource 注解

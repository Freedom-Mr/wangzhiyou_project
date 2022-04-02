# netflix feign (内置ribbon) 负载均衡

## 请先启动 eureka_demo 项目中的服务注册中心和生产者
1. eureka_demo -> eureka_server
2. eureka_demo -> eureka02_server
3. eureka_demo -> service_provider
4. feign_demo -> service_feign_provider
5. feign_demo -> service_feign_provider2
6. feign_demo -> service_feign_consumer

## 负载模式
1. 全局模式
在启动类里面注入bean，如下面代码是随机策略
`@Bean
public RandomRule randomRule(){
    return new RandomRule();
}`

2. 局部模式
在application.yml里配置对应服务的负载策略
`serviceProvider:
    ribbon:
        NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule #随机策略`**_

##请求
http://localhost:9080/order/list
http://localhost:9080/order/1
http://localhost:9080/order/casia.isiteam.pojo?id=1&productName=耳机&productNum=1&productPrice=288

##性能调优
1. gzip压缩

①局部方式：在 application.yml 里配置 feign gzip 压缩
feign:
    compression:
        request:

②全局方式：
server:
    compression:
        enabled: true #是否开启压缩
        mime-types: application/json,application/xml,text/html,text/xml,text/plain

2. HTTP连接池

* 引入 feign-httpclient 包
> 普通 HTTP 连接需要3次握手、4次挥手开销很大，采用 HTTP 连接池可以节约大量的握手和挥手，大大提升吞吐量。
> * Feign 的 HTTP 客户端支持3种框架：HttpURLConnection、HttpClient、OkHttp，默认是 HttpURLConnection

①传统 HttpURLConnection 是JDK自带，不支持连接池。

②HttpClient

在application.yml里配置
`feign:
    httpclient:
        enabled: true #开启 httpclient`

3. 日志

4. 请求超时
①全局模式

②局部模式
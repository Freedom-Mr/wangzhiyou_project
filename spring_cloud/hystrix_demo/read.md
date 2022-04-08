# netflix hystrix 服务管理
==================================
hystrix已停止维护，可选择阿里的sentinel

## 请先启动 eureka_demo 项目中的服务注册中心
1. eureka_demo -> eureka_server
2. eureka_demo -> eureka02_server

## 雪崩效应
并发导致雪崩效应
- service_hystrix_consumer 启动后用jMeter测试

## 解决方案
1. 请求缓存
- service_hystrix_consumer
- 这里使用redis作为缓存载体

2. 请求合并
- service_hystrix_consumer_merge
- 优点：减少单独HTTP调用，减少资源调度
- 缺点：单个请求本来5ms，为了合并一起请求，可能需要15ms

3. 服务隔离
- service_hystrix_consumer_isolation
- 请求后，查看输出日志线程名即可区分隔离。
- 请求并发大，耗时长（计算大，或操作关系型数据库）。采用线程隔离策略。
- 请求并发大，耗时短（计算小，或操作缓存），采用信号量隔离策略。
- （1）线程池隔离
    > 没有线程池隔离的项目所有接口都运行在一个ThreadPool 中，当某一个接口压力过大或者出现故障时，会导致资源耗尽从而影响到其它接口调用而引发服务雪崩效应。
    
    > 通过每次都开启一个单独线程运行，它的隔离是通过线程池，即每个隔离粒度都是个线程池，互相不干扰。线程池隔离方式，等于多了一层的保护措施，可以通过 hytrix 直接设置超时，超时后直接返回。
    
    > （隔离原理）每个服务单独用线程池，支持超时，支持熔断，支持同步或异步，资源消耗大                                                                                                      
   
- （2）信号量隔离
    > 每次调用线程，当前请求通过计数信号量进行限制，当信号量大于了最大请求数 maxConcurrentRequests 时，进行限制，调用 fallback 接口快速会返回。信号量的调用是同步的，也就是说，每次调用都是阻塞调用方法的线程，直到返回结果。这样就导致了无法对访问做超时（只能依靠调用协议超时，无法主动释放）。

    > （隔离原理）通过信号量的计数器，不支持超时，支持熔断，支持同步不支持异步，资源消耗小   
4. 服务熔断
- service_hystrix_consumer_circuit_breaker

5. 服务降级
- service_hystrix_consumer_circuit_breaker
- 触发条件
  1. 方法抛出非 HystrixBadRequestException 异常;
  2. 方法调用超时
  3. 熔断器开启拦截
  4. 线程池/队列/信号量跑满

6. Feign 雪崩处理
- service_hystrix_consumer_merge
  1. ProductServiceFallbackFactory 日志捕获类

## Hystrix 服务监控
1. actuator 组件(单服务监控)
- service_hystrix_consumer_actuator
- 请求连接
  > http://localhost:5011/actuator
  > http://localhost:5011/actuator/hystrix.stream
  > http://localhost:5011/hystrix
  > http://localhost:5011/order/1/product

2. turbine 组件（多服务聚合监控）
- service_hystrix_consumer_turbine
- 请求连接
  > http://localhost:5012/turbine.stream
  > http://localhost:5012/hystrix
  > 填入 http://localhost:5012/turbine.stream
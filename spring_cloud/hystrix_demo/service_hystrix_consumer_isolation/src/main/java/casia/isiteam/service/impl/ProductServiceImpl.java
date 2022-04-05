package casia.isiteam.service.impl;

import casia.isiteam.pojo.Product;
import casia.isiteam.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

/**
 * ClassName: ProdcutServiceImpl
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2022/4/3
 * Email: zhiyou_wang@qq.com
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private RestTemplate restTemplate;

    // 声明需要的服务容错方法
    // 1. 线程池隔离
    /*@HystrixCommand(groupKey = "service-consumer", //服务名称，相同名称使用同一个线程池
            commandKey = "selectProductList",//接口名称，默认为方法名
            threadPoolKey = "order-productServices-listPool",//线程池名称，相同名称使用用一个线程
            commandProperties = {
                    // 超时时间，默认 1000ms
                    @HystrixProperty( name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000" ),
            },
            threadPoolProperties = {
                    //线程池大小
                    @HystrixProperty(name = "coreSize",value = "6"),
                    //队列等待阈值（最大队列长度，默认 -1）
                    @HystrixProperty(name = "maxQueueSize", value = "100"),
                    //线程存活时间，默认1分钟
                    @HystrixProperty(name = "keepAliveTimeMinutes",value = "2"),
                    // 超出队列等待阈值执行拒绝策略
                    @HystrixProperty(name = "queueSizeRejectionThreshold",value = "100")
            },fallbackMethod = "selectProductListFallback"
    )*/

    //2. 信号量隔离
    @HystrixCommand(commandProperties = {
            // 超时时间，默认1000ms
            @HystrixProperty( name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000" ),
            // 信号量隔离
            @HystrixProperty( name = HystrixPropertiesManager.EXECUTION_ISOLATION_STRATEGY, value = "SEMAPHORE"),
            //信号量最大并发，调小一些方便模拟高并发
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS,value = "6")
    },fallbackMethod = "selectProductListFallback")
    @Override
    public List<Product> selectProductList() {
        System.out.println(Thread.currentThread().getName()+"------ selectProductList ----------");
        System.out.println();
        // ResponseEntity: 封装了返回数据
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                "http://serviceHystrixProvider/product/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {});
        return response.getBody();
    }

    @Override
    public List<Product> selectProductListByIds(List<Integer> ids) {
        System.out.println(Thread.currentThread().getName()+"---serviceHystrixProvider------selectProductListByIds----");
        StringBuffer sb = new StringBuffer();
        ids.forEach( id -> sb.append("id="+id+"&") );
        // ResponseEntity: 封装了返回数据
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                "http://serviceHystrixProvider/product/listByIds?"+sb,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {});
        return response.getBody();
    }

    @Override
    public Product selectProductById(Integer id) {
        System.out.println(Thread.currentThread().getName()+"---serviceHystrixProvider------selectProductById----");
        return restTemplate.getForObject("http://serviceHystrixProvider/product/"+id,Product.class);
    }

    /**
     * 托底数据方法
     * @return
     */
    public List<Product> selectProductListFallback(){
        System.out.println("托底开始");
        return Arrays.asList(
                new Product(1,"托底数据-华为手机",3,5999D),
                new Product(2,"托底数据-三星手机",1,5999D),
                new Product(3,"托底数据-小米手机",2,5999D)
        );
    }
}

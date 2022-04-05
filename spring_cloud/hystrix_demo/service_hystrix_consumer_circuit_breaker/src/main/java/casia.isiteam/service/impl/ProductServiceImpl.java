package casia.isiteam.service.impl;

import casia.isiteam.pojo.Product;
import casia.isiteam.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

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

    // 声明需要服务容错的方法
    // 服务熔断
    @HystrixCommand(commandProperties = {
            // 10s 内请求大于10个就启动熔断器，当请求符合熔断条件触发 fallbackMethod 默认 20 个
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,value = "10"),
            // 请求值错误率大于 50% 就启动熔断器，然后for 循环发起重试请求，当请求符合熔断条件触发 fallbackMethod
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,value = "50"),
            // 熔断多少秒去重新请求，默认5s
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,value = "5000")
    }, fallbackMethod = "selectProductByIdFallback")
    @Override
    public Product selectProductById(Integer id) {
        System.out.println(Thread.currentThread().getName()+"---serviceHystrixProvider------selectProductById----"+
                LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return restTemplate.getForObject("http://serviceHystrixProvider/product/"+id,Product.class);
    }

    /**
     * 托底数据方法
     * @return
     */
    public Product selectProductByIdFallback(){
        System.out.println("托底开始");
        return new Product(1,"托底数据-华为手机",3,5999D);
    }
}

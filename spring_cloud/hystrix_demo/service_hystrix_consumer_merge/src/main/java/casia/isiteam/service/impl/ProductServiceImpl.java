package casia.isiteam.service.impl;

import casia.isiteam.pojo.Product;
import casia.isiteam.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Override
    public List<Product> selectProductList() {
        // ResponseEntity: 封装了返回数据
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                "http://serviceHystrixProvider/product/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {});
        return response.getBody();
    }

    @Override
    // 声明需要服务容错的方法
    @HystrixCommand
    public List<Product> selectProductListByIds(List<Integer> ids) {
        System.out.println("---serviceHystrixProvider------selectProductListByIds----");
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
    // 处理请求合并的方法一定要支持异步，返回值必须是 Future<T>
    // 合并请求
    @HystrixCollapser(batchMethod = "selectProductListByIds", //合并的方法
            scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,//请求方式
            collapserProperties = {
                    // 间隔多久的请求会进行合并，默认 10ms
                    @HystrixProperty( name = "timerDelayInMilliseconds", value = "20" ),
                    // 批处理之前，批处理中允许的最大请求数
                    @HystrixProperty( name = "maxRequestsInBatch", value = "200")
            })
    public Future<Product> selectProductById(Integer id) {
        System.out.println("---serviceHystrixProvider------selectProductById----");
        return null;
//        return restTemplate.getForObject("http://serviceHystrixProvider/product/"+id,Product.class);
    }
}

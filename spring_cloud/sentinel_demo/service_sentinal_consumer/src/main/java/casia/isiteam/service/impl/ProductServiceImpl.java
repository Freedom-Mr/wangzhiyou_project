package casia.isiteam.service.impl;

import casia.isiteam.pojo.Product;
import casia.isiteam.service.ProductService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Product> selectProductListByIds(List<Integer> ids) {
        System.out.println("---serviceHystrixProvider------selectProductListByIds----");
        StringBuffer sb = new StringBuffer();
        ids.forEach( id -> sb.append("id="+id+"&") );
        // ResponseEntity: 封装了返回数据
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                "http://serviceSentinelProvider/product/listByIds?"+sb,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {});
        return response.getBody();
    }


    // sentinel 测试, RestTemplate 注解情况下需要注释
//    @SentinelResource(value = "selectProductById",blockHandler = "selectProductByIdBlockHandler",fallback = "selectProductByIdFallback")
    @Override
    public Product selectProductById(Integer id) {
        System.out.println("---serviceHystrixProvider------selectProductById----");
        if( id == 2 ){
            throw new RuntimeException("查询主键为2的商品异常信息");
        }
        return restTemplate.getForObject("http://serviceSentinelProvider/product/"+id,Product.class);
    }

    // 服务流量控制处理，参数最后一个 BlockException, 其余与原函数一致
    public Product selectProductByIdBlockHandler(Integer id, BlockException ex){
        ex.printStackTrace();
        return new Product(id,"服务流量控制处理-托底数据",1,2333D);
    }
    // 服务熔断降级处理，函数签名与原函数一致或加一个 Throwable 类型的参数
    public Product selectProductByIdFallback(Integer id,Throwable throwable){
        System.out.println("product-service 服务的 selectProductById 方法出现异常，异常信息如下："+throwable);
        return new Product(id,"服务熔断降级处理-托底数据",1,2333D);
    }
}

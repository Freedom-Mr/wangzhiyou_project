package casia.isiteam.service.impl;

import casia.isiteam.pojo.Product;
import casia.isiteam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Cacheable(cacheNames = "orderService:product:list")//请求缓存
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

    @Cacheable(cacheNames = "orderService:product:single",key = "#id")//请求缓存
    @Override
    public Product selectProductById(Integer id) {
        return restTemplate.getForObject("http://serviceHystrixProvider/product/"+id,Product.class);
    }
}

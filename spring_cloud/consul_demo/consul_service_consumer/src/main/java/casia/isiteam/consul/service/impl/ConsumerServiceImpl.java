package casia.isiteam.consul.service.impl;


import casia.isiteam.consul.pojo.Order;
import casia.isiteam.consul.pojo.Product;
import casia.isiteam.consul.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @ClassName: ConsumerService
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/30
 * Email: zhiyou_wang@foxmail.com
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private RestTemplate restTemplate;



    @Override
    public Order selectOrderById(Integer id) {
        // LoadBalanced 负载均衡器注解
        return new Order(id,"order-001","中国",32212D,selectProductListByDiscoveryClient3());
    }


    /**
     * 方式三
     * @LoadBalanced 负载均衡器注解
     * 在启动类初始化 RestTemplate 注解
     */
    private List<Product> selectProductListByDiscoveryClient3(){

        // ResponseEntity: 封装了返回数据
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                "http://consulServiceProvider/product/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {});
        System.out.println(response.getHeaders().getLocation());
        return response.getBody();
    }
}

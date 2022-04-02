package casia.isiteam.service.impl;

import casia.isiteam.pojo.Order;
import casia.isiteam.pojo.Product;
import casia.isiteam.service.ConsumerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
        //方式一 discoveryClient 方式, 记得注释方式三 启动类注释
//        return new Order(id,"order-001","中国",32212D,selectProductListByDiscoveryClient());
//        方式二 使用 Ribbon 负载均衡器， 记得注释方式三 启动类注释
        return new Order(id,"order-001","中国",32212D,selectProductListByDiscoveryClient2());
        //方式三 使用 LoadBalanced 负载均衡器注解
//        return new Order(id,"order-001","中国",32212D,selectProductListByDiscoveryClient3());
    }


    /**
     * 方式一： discoveryClient 方式
     * @return
     */
    @Autowired
    private DiscoveryClient discoveryClient;
    private List<Product> selectProductListByDiscoveryClient(){
        StringBuffer sb = null;

        //获取服务列表
        List<String> serviceIds = discoveryClient.getServices();
        if(CollectionUtils.isEmpty(serviceIds)){
            return null;
        }

        // 根据服务器名称获取服务
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("serviceProvider");
        if(CollectionUtils.isEmpty(serviceInstances)){
            return null;
        }

        ServiceInstance s1 = serviceInstances.get(0);
        sb = new StringBuffer();
        sb.append("http://"+s1.getHost()+":"+s1.getPort()+"/product/list");
        System.out.println(sb);

        // ResponseEntity: 封装了返回数据
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {});

        return response.getBody();
    }

    /**
     * 方式二 Ribbon 负载均衡器
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient; //Ribbon 负载均衡器
    private List<Product> selectProductListByDiscoveryClient2(){
        StringBuffer sb = null;

        //根据服务名称获取服务
        ServiceInstance s1 = loadBalancerClient.choose("serviceProvider");
        if( null == s1 ){
            return null;
        }
        sb = new StringBuffer();
        sb.append("http://"+s1.getHost()+":"+s1.getPort()+"/product/list");
        System.out.println(sb.toString());

        // ResponseEntity: 封装了返回数据
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {});

        return response.getBody();
    }

    /**
     * 方式三
     * @LoadBalanced 负载均衡器注解
     * 在启动类初始化 RestTemplate 注解
     */
    private List<Product> selectProductListByDiscoveryClient3(){

        // ResponseEntity: 封装了返回数据
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                "http://serviceProvider/product/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {});
        System.out.println(response.getHeaders().getLocation());
        return response.getBody();
    }
}

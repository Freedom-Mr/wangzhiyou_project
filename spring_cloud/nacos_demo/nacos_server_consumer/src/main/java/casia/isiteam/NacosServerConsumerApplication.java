package casia.isiteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: NacosServerProvider
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/14
 * Email: zhiyou_wang@foxmail.com
 */
@SpringBootApplication
// 开启服务注册与发现
@EnableDiscoveryClient
//开启Feign
@EnableFeignClients
public class NacosServerConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosServerConsumerApplication.class);
    }
}

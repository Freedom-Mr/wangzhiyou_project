package casia.isiteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: ServiceHystrixConsumerFeignApplication
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/7
 * Email: zhiyou_wang@foxmail.com
 */
@SpringBootApplication
//开启Feign
@EnableFeignClients
public class ServiceHystrixConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHystrixConsumerFeignApplication.class);
    }
}

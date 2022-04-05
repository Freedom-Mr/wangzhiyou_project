package casia.isiteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: ServiceFeignConsumerApplication
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/1
 * Email: zhiyou_wang@foxmail.com
 */
@SpringBootApplication
//开启Feign
//@EnableFeignClients
//开启熔断器注解 2 选1 ，@EnableHystrix 封装了 @EnableCircuitBreaker
//@EnableHystrix
@EnableCircuitBreaker
public class ServiceHystrixConsumerCircuitBreakerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    };

    public static void main(String[] args) {
        SpringApplication.run(ServiceHystrixConsumerCircuitBreakerApplication.class);
    }

}

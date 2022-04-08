package casia.isiteam;

import casia.isiteam.exception.ExceptionUtil;
import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
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
@EnableFeignClients
public class ServiceSentinelConsumerApplication {

    @Bean
    @LoadBalanced
    @SentinelRestTemplate(blockHandler = "handleException",blockHandlerClass = ExceptionUtil.class,fallback = "fallback",fallbackClass = ExceptionUtil.class)
    public RestTemplate restTemplate(){
        return new RestTemplate();
    };

    public static void main(String[] args) {
        SpringApplication.run(ServiceSentinelConsumerApplication.class);
    }

}

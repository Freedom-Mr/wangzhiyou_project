package casia.isiteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

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
public class ServiceSentinelConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSentinelConsumerFeignApplication.class);
    }
}

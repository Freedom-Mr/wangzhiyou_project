package casia.isiteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

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
public class ServiceHystrixConsumerApplication {


    public static void main(String[] args) {
        SpringApplication.run(ServiceHystrixConsumerApplication.class);
    }

}

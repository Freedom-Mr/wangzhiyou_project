package casia.isiteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: ServiceProviderApplication
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/30
 * Email: zhiyou_wang@foxmail.com
 */
@SpringBootApplication
// 开启EurekaClient 注解，目前版本如果配置了 Eureka 注册中心，默认会开启该注解
//@EnableEurekaClient
public class ServiceFeignProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignProviderApplication.class);
    }
}

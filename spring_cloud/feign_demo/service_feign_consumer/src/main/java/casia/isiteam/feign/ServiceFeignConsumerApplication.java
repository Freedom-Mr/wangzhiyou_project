package casia.isiteam.feign;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

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
public class ServiceFeignConsumerApplication {


    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignConsumerApplication.class);
    }


    //RandomRule	随机策略	随机选择server
    /*@Bean
    public RandomRule randomRule(){
        return new RandomRule();
    }*/
}

package casia.isiteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
public class NacosServerProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosServerProviderApplication.class);
    }
}

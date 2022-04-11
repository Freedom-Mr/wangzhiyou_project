package casia.isiteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * ClassName: ZuulServerApplication
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2022/4/11
 * Email: zhiyou_wang@qq.com
 */
@SpringBootApplication
@EnableZuulProxy
@EnableHystrixDashboard
public class ZuulServerHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServerHystrixApplication.class,args);
    }
}

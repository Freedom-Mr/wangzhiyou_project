package casia.isiteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class ZuulServerFilterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServerFilterApplication.class,args);
    }
}

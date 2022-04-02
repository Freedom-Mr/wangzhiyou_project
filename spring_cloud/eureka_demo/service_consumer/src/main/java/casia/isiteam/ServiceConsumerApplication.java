package casia.isiteam;

import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: ServiceConsumerApplication
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/30
 * Email: zhiyou_wang@foxmail.com
 */
@SpringBootApplication
public class ServiceConsumerApplication {

    @Bean
//    @LoadBalanced //方式三：负载均衡器注解
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApplication.class);
    }


    //ribbon 负载均衡策略-全局方式。  如果使用局部方式在application.yml文件配置
    //RandomRule	随机策略	随机选择server
    //RoundRobinRule	轮询策略	轮询选择， 轮询index，选择index对应位置的Server；
    //RetryRule	重试策略	对选定的负载均衡策略机上重试机制，在一个配置时间段内当选择Server不成功，则一直尝试使用subRule的方式选择一个可用的server；
    //BestAvailableRule	最低并发策略	逐个考察server，如果server断路器打开，则忽略，再选择其中并发链接最低的server
    //AvailabilityFilteringRule	可用过滤策略	过滤掉一直失败并被标记为circuit tripped的server，过滤掉那些高并发链接的server（active connections超过配置的阈值）或者使用一个AvailabilityPredicate来包含过滤server的逻辑，其实就就是检查status里记录的各个Server的运行状态；
    //ResponseTimeWeightedRule	响应时间加权重策略	根据server的响应时间分配权重，响应时间越长，权重越低，被选择到的概率也就越低。响应时间越短，权重越高，被选中的概率越高，这个策略很贴切，综合了各种因素，比如：网络，磁盘，io等，都直接影响响应时间
    //ZoneAvoidanceRule	区域权重策略	综合判断server所在区域的性能，和server的可用性，轮询选择server并且判断一个AWS Zone的运行性能是否可用，剔除不可用的Zone中的所有server
    /*@Bean
    public RandomRule randomRule(){
        return new RandomRule();
    }*/
}

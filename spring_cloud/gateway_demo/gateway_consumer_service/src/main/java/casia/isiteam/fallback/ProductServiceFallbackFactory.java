package casia.isiteam.fallback;

import casia.isiteam.pojo.Product;
import casia.isiteam.service.ProductService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: ProductServiceFallbackFactory
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/7
 * Email: zhiyou_wang@foxmail.com
 */
// 服务熔断降级处理可以捕获异常
@Component
public class ProductServiceFallbackFactory implements FallbackFactory<ProductService> {
    Logger logger = LoggerFactory.getLogger(ProductServiceFallbackFactory.class);


    @Override
    public ProductService create(Throwable throwable) {

        return new ProductService() {

            @Override
            public Product selectProductListById(Integer id) {
                logger.error("serviceSentinelProvider 服务的 selectProductById 方法出现异常，异常信息如下："+throwable);
                return new Product(id,"托底数据-冰箱",2,5888D);
            }
        };
    }
}

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
            public List<Product> selectProductList() {
                logger.error("serviceHystrixProvider 服务的 selectProductList 方法出现异常，异常信息如下："+throwable);
                return Arrays.asList(
                        new Product(1,"托底数据-华为手机-7070",2,5888D),
                        new Product(2,"托底数据-小米手机",1,4888D),
                        new Product(3,"托底数据-苹果手机",4,6888D)
                );
            }

            @Override
            public List<Product> selectProductListByIds(List<Integer> ids) {
                logger.error("serviceHystrixProvider 服务的 selectProductListByIds 方法出现异常，异常信息如下："+throwable);
                List<Product> products = new ArrayList<>();
                ids.forEach(id-> products.add(new Product(id,"托底数据-电视剧"+id,1,2002D)));
                return products;
            }

            @Override
            public Product selectProductById(Integer id) {
                logger.error("serviceHystrixProvider 服务的 selectProductById 方法出现异常，异常信息如下："+throwable);
                return new Product(id,"托底数据-冰箱",2,5888D);
            }
        };
    }
}

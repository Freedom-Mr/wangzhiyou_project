package casia.isiteam.service;

import casia.isiteam.fallback.ProductServiceFallbackFactory;
import casia.isiteam.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ProductService
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/1
 * Email: zhiyou_wang@foxmail.com
 */
//声明需要调用的函数
@FeignClient(value = "serviceGatewayProvider",fallbackFactory = ProductServiceFallbackFactory.class)
public interface ProductService {
    /**
     * 查询商品列表
     * @return
     */
    @GetMapping("/product/{id}")
    Product selectProductListById(@PathVariable("id") Integer id);

}

package casia.isiteam.service;

import casia.isiteam.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName: ProductService
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/1
 * Email: zhiyou_wang@foxmail.com
 */
// 声明需要调用的服务
@FeignClient(name  = "service-provider")
public interface ProductService {
    /**
     * 查询商品列表
     * @return
     */
    @GetMapping("/product/list")
    List<Product> selectProductList();
    /**
     * 查询商品列表
     * @return
     */
    @GetMapping("/product/listByids")
    List<Product> selectProductListByIds (@RequestParam("id") List<Integer> ids);

    /**
     * 查询商品列表
     * @return
     */
    @GetMapping("/product/{id}")
    Product selectProductById(@PathVariable("id") Integer id);


}

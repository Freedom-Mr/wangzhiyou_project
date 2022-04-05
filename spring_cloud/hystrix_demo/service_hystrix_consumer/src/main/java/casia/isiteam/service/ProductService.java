package casia.isiteam.service;

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

public interface ProductService {
    /**
     * 查询商品列表
     * @return
     */
    List<Product> selectProductList();
    /**
     * 查询商品列表
     * @return
     */
    List<Product> selectProductListByIds (List<Integer> ids);

    Product selectProductById(Integer id);


}

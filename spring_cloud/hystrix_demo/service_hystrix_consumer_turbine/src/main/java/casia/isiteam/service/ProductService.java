package casia.isiteam.service;

import casia.isiteam.pojo.Product;

import java.util.List;

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

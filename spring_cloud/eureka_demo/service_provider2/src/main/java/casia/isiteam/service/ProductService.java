package casia.isiteam.service;

import casia.isiteam.pojo.Product;

import java.util.List;

/**
 * @ClassName: ProductService
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/30
 * Email: zhiyou_wang@foxmail.com
 */
public interface ProductService {
    public List<Product> selectProductList();
}

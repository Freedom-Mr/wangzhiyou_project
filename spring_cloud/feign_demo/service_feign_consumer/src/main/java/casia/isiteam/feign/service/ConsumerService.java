package casia.isiteam.feign.service;


import casia.isiteam.feign.pojo.Order;
import casia.isiteam.feign.pojo.Product;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ConsumerService
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/30
 * Email: zhiyou_wang@foxmail.com
 */
public interface ConsumerService {
    Order selectOrderList();
    Order selectOrderById(Integer id);
    Map<Object, Object> createProduct(Product product);
    Product selectProductByPojo(Product product);
}

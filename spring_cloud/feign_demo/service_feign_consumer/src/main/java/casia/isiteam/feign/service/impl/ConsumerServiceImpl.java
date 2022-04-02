package casia.isiteam.feign.service.impl;

import casia.isiteam.feign.pojo.Order;
import casia.isiteam.feign.pojo.Product;
import casia.isiteam.feign.service.ConsumerService;
import casia.isiteam.feign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ConsumerServiceImpl
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/1
 * Email: zhiyou_wang@foxmail.com
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private ProductService productService;

    @Override
    public Order selectOrderList() {
        return new Order(3,"order-001","中国",32212D,productService.selectProductList());
    }

    @Override
    public Order selectOrderById(Integer id) {

//        return new Order(id,"order-001","中国",32212D,productService.selectProductList());
        return new Order(id,"order-001","中国",32212D,productService.selectProductListById(id));
    }

    @Override
    public Map<Object, Object> createProduct(Product product) {
        return productService.createProduct(product);
    }

    @Override
    public Product selectProductByPojo(Product product) {
        return productService.selectProductByPojo(product);
    }
}

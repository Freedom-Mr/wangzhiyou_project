package casia.isiteam.service.impl;

import casia.isiteam.pojo.Order;
import casia.isiteam.pojo.Product;
import casia.isiteam.service.ConsumerService;
import casia.isiteam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
        return new Order(id,"order-001","中国",12212D,productService.selectProductList());
    }

    @Override
    public Order queryOrderById(Integer id) {
        return new Order(id,"order-002","中国",22212D,productService.selectProductListByIds(Arrays.asList(1,2)));
    }

    @Override
    public Order searchOrderById(Integer id) {
        return new Order(id,"order-003","中国",32212D, Arrays.asList(productService.selectProductById(id)));
    }

}

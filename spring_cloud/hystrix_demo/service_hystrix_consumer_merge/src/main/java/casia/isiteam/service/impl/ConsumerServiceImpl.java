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
        // 模拟同一时间用户发起的多个请求
        Future<Product> p1 = productService.selectProductById(1);
        Future<Product> p2 = productService.selectProductById(2);
        Future<Product> p3 = productService.selectProductById(3);
        Future<Product> p4 = productService.selectProductById(4);
        Future<Product> p5 = productService.selectProductById(5);
        Future<Product> p6 = productService.selectProductById(6);
        try {
            System.out.println(p1.get());
            System.out.println(p2.get());
            System.out.println(p3.get());
            System.out.println(p4.get());
            System.out.println(p5.get());
            System.out.println(p6.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new Order(id,"order-003","中国",32212D, null);
    }

}

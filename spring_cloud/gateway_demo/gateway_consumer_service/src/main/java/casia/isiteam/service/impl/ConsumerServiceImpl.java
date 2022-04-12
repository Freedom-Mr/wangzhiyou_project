package casia.isiteam.service.impl;

import casia.isiteam.pojo.Order;
import casia.isiteam.service.ConsumerService;
import casia.isiteam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    public Order selectOrderById(Integer id) {

//        return new Order(id,"order-001","中国",32212D,productService.selectProductList());
        return new Order(id,"order-001","中国",32212D, Arrays.asList(productService.selectProductListById(id)));
    }

}

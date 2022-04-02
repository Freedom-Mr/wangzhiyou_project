package casia.isiteam.feign.controller;

import casia.isiteam.feign.pojo.Order;
import casia.isiteam.feign.pojo.Product;
import casia.isiteam.feign.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName: ConsumerController
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/30
 * Email: zhiyou_wang@foxmail.com
 */
@RestController
@RequestMapping("/order")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/list")
    public Order selectOrderList(){
        return consumerService.selectOrderList();
    }

    @GetMapping("/{id}")
    public Order selectOrderById(@PathVariable("id") Integer id){
        return consumerService.selectOrderById(id);
    }

    @PostMapping("/save")
    public Map<Object,Object> createProduct(@RequestBody Product product){
        return consumerService.createProduct(product);
    }

    @GetMapping("/pojo")
    public Product selectProductByPojo(Product product){
        return consumerService.selectProductByPojo(product);
    }
}

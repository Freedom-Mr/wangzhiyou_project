package casia.isiteam.controller;


import casia.isiteam.pojo.Order;
import casia.isiteam.service.ConsumerService;
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



    @GetMapping("/{id}")
    public Order selectOrderById(@PathVariable("id") Integer id){
        return consumerService.selectOrderById(id);
    }

}

package casia.isiteam.service;


import casia.isiteam.pojo.Order;

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
    Order queryOrderById(Integer id);
    Order searchOrderById(Integer id);

}

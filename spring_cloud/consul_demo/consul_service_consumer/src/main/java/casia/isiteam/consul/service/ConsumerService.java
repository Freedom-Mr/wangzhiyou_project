package casia.isiteam.consul.service;

import casia.isiteam.consul.pojo.Order;

/**
 * @ClassName: ConsumerService
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/30
 * Email: zhiyou_wang@foxmail.com
 */
public interface ConsumerService {
    Order selectOrderById(Integer id);
}

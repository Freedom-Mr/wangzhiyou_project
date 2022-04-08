package casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.m_impl;

import casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.MobilePhone;

/**
 * @ClassName: Rectangle
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public class XiaoMi implements MobilePhone {

    @Override
    public void draw() {
        System.out.println("Inside XiaoMi::draw() method.");
    }
}

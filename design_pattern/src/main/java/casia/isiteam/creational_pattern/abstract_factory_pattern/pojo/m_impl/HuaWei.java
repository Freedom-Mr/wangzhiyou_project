package casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.m_impl;

import casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.MobilePhone;

/**
 * @ClassName: Circle
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public class HuaWei implements MobilePhone {

    @Override
    public void draw() {
        System.out.println("Inside HuaWei::draw() method.");
    }
}

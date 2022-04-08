package casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.c_impl;

import casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.Color;

/**
 * @ClassName: Blue
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}

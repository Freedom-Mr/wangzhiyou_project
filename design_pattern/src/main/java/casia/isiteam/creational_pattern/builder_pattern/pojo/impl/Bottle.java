package casia.isiteam.creational_pattern.builder_pattern.pojo.impl;

import casia.isiteam.creational_pattern.builder_pattern.pojo.Packing;

/**
 * @ClassName: Bottle
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}

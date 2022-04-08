package casia.isiteam.creational_pattern.builder_pattern.pojo.abs;

import casia.isiteam.creational_pattern.builder_pattern.pojo.Item;
import casia.isiteam.creational_pattern.builder_pattern.pojo.Packing;
import casia.isiteam.creational_pattern.builder_pattern.pojo.impl.Wrapper;

/**
 * @ClassName: Burger
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}

package casia.isiteam.creational_pattern.builder_pattern.pojo.abs;

import casia.isiteam.creational_pattern.builder_pattern.pojo.Item;
import casia.isiteam.creational_pattern.builder_pattern.pojo.Packing;
import casia.isiteam.creational_pattern.builder_pattern.pojo.impl.Bottle;

/**
 * @ClassName: ColdDrink
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}

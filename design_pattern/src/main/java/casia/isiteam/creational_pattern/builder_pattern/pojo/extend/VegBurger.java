package casia.isiteam.creational_pattern.builder_pattern.pojo.extend;

import casia.isiteam.creational_pattern.builder_pattern.pojo.abs.Burger;

/**
 * @ClassName: VegBurger
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}

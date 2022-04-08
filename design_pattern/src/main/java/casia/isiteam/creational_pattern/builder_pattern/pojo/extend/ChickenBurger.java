package casia.isiteam.creational_pattern.builder_pattern.pojo.extend;

import casia.isiteam.creational_pattern.builder_pattern.pojo.abs.Burger;

/**
 * @ClassName: ChickenBurger
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}

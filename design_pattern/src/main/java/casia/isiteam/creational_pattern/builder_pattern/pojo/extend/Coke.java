package casia.isiteam.creational_pattern.builder_pattern.pojo.extend;

import casia.isiteam.creational_pattern.builder_pattern.pojo.abs.ColdDrink;

/**
 * @ClassName: Coke
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}

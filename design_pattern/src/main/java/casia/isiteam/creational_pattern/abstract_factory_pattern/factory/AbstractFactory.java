package casia.isiteam.creational_pattern.abstract_factory_pattern.factory;

import casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.Color;
import casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.MobilePhone;

/**
 * @ClassName: AbstractFactory
 * @Description: 为 Color 和 MobilePhone 对象创建抽象类来获取工厂。
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public abstract class AbstractFactory {
    //为 Color 和 MobilePhone 对象创建抽象类来获取工厂。
    public abstract Color getColor(String color);
    public abstract MobilePhone getMobilePhone(String mobilePhone);
}

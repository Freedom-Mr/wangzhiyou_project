package casia.isiteam.creational_pattern.abstract_factory_pattern;

import casia.isiteam.creational_pattern.abstract_factory_pattern.factory.FactoryProducer;
import casia.isiteam.creational_pattern.abstract_factory_pattern.factory.AbstractFactory;
import casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.Color;
import casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.MobilePhone;

/**
 * @ClassName: AbstractFactoryPatternDemo
 * @Description: 抽象工程模式
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public class AbstractFactoryPatternDemo {

    //抽象工程模式
    public static void main(String[] args) {

        //获取手机工厂
        AbstractFactory mobilePhoneFactory = FactoryProducer.getFactory("mobilePhone");

        //获取手机为 huawei 的对象
        MobilePhone mobilePhone1 = mobilePhoneFactory.getMobilePhone("huawei");

        //调用 huawei 的 draw 方法
        mobilePhone1.draw();

        //获取手机为 Apple 的对象
        MobilePhone mobilePhone2 = mobilePhoneFactory.getMobilePhone("apple");

        //调用 Apple 的 draw 方法
        mobilePhone2.draw();

        //获取手机为 XiaoMi 的对象
        MobilePhone mobilePhone3 = mobilePhoneFactory.getMobilePhone("xiaomi");

        //调用 XiaoMi 的 draw 方法
        mobilePhone3.draw();

        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");

        //获取颜色为 Red 的对象
        Color color1 = colorFactory.getColor("red");

        //调用 Red 的 fill 方法
        color1.fill();

        //获取颜色为 Green 的对象
        Color color2 = colorFactory.getColor("green");

        //调用 Green 的 fill 方法
        color2.fill();

        //获取颜色为 Blue 的对象
        Color color3 = colorFactory.getColor("blue");

        //调用 Blue 的 fill 方法
        color3.fill();
    }
}

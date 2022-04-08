package casia.isiteam.creational_pattern.factory_pattern;

import casia.isiteam.creational_pattern.factory_pattern.pojo.MobilePhone;
import casia.isiteam.creational_pattern.factory_pattern.factory.MobilePhoneFactory;

/**
 * @ClassName: FactoryPatternDemo
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        MobilePhoneFactory shapeFactory = new MobilePhoneFactory();

        //获取 HuaWei 的对象，并调用它的 draw 方法
        MobilePhone mobilePhone1 = shapeFactory.getMobilePhone("huawei");

        //调用 HuaWei 的 draw 方法
        mobilePhone1.draw();

        //获取 XiaoMi 的对象，并调用它的 draw 方法
        MobilePhone mobilePhone2 = shapeFactory.getMobilePhone("xiaomi");

        //调用 XiaoMi 的 draw 方法
        mobilePhone2.draw();

        //获取 Apple 的对象，并调用它的 draw 方法
        MobilePhone mobilePhone3 = shapeFactory.getMobilePhone("apple");

        //调用 Apple 的 draw 方法
        mobilePhone3.draw();
    }
}

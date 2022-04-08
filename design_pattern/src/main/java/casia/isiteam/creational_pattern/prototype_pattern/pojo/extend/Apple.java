package casia.isiteam.creational_pattern.prototype_pattern.pojo.extend;

import casia.isiteam.creational_pattern.prototype_pattern.pojo.MobilePhone;

/**
 * @ClassName: HuaWei
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public class Apple extends MobilePhone {
    public Apple(){
        type = "Apple";
    }

    @Override
    public void draw() {
        System.out.println("Inside Apple::draw() method.");
    }
}

package casia.isiteam.creational_pattern.abstract_factory_pattern.factory;

import casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.Color;
import casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.MobilePhone;
import casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.c_impl.Blue;
import casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.c_impl.Green;
import casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.c_impl.Red;

/**
 * @ClassName: ColorFactory
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public MobilePhone getMobilePhone(String mobilePhoneType){
        return null;
    }

    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("red")){
            return new Red();
        } else if(color.equalsIgnoreCase("green")){
            return new Green();
        } else if(color.equalsIgnoreCase("blue")){
            return new Blue();
        }
        return null;
    }
}

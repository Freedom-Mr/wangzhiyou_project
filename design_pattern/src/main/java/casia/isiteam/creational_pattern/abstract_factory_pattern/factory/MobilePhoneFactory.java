package casia.isiteam.creational_pattern.abstract_factory_pattern.factory;

import casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.Color;
import casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.MobilePhone;
import casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.m_impl.Apple;
import casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.m_impl.HuaWei;
import casia.isiteam.creational_pattern.abstract_factory_pattern.pojo.m_impl.XiaoMi;

/**
 * @ClassName: ShapeFactory
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public class MobilePhoneFactory extends AbstractFactory {

    @Override
    public MobilePhone getMobilePhone(String mobilePhoneType){
        if(mobilePhoneType == null){
            return null;
        }
        if(mobilePhoneType.equalsIgnoreCase("huawei")){
            return new HuaWei();
        } else if(mobilePhoneType.equalsIgnoreCase("xiaomi")){
            return new XiaoMi();
        } else if(mobilePhoneType.equalsIgnoreCase("apple")){
            return new Apple();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}

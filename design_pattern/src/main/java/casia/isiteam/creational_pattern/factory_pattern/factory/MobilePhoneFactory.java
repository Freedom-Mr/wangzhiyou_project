package casia.isiteam.creational_pattern.factory_pattern.factory;

import casia.isiteam.creational_pattern.factory_pattern.pojo.MobilePhone;
import casia.isiteam.creational_pattern.factory_pattern.pojo.impl.Apple;
import casia.isiteam.creational_pattern.factory_pattern.pojo.impl.HuaWei;
import casia.isiteam.creational_pattern.factory_pattern.pojo.impl.XiaoMi;

/**
 * @ClassName: ShapeFactory
 * @Description: 工厂
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public class MobilePhoneFactory {
    //使用 getMobilePhone 方法获取形状类型的对象
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
}

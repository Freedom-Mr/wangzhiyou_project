package casia.isiteam.creational_pattern.prototype_pattern;

import casia.isiteam.creational_pattern.prototype_pattern.pojo.MobilePhone;
import casia.isiteam.creational_pattern.prototype_pattern.pojo.cache.MobilePhoneCache;

/**
 * @ClassName: PrototypePatternDemo
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public class PrototypePatternDemo {
    public static void main(String[] args) {
        MobilePhoneCache.loadCache();

        MobilePhone clonedMobilePhone = (MobilePhone) MobilePhoneCache.getMobilePhone("1");
        System.out.println("MobilePhone : " + clonedMobilePhone.getType());

        MobilePhone clonedMobilePhone2 = (MobilePhone) MobilePhoneCache.getMobilePhone("2");
        System.out.println("MobilePhone : " + clonedMobilePhone2.getType());

        MobilePhone clonedMobilePhone3 = (MobilePhone) MobilePhoneCache.getMobilePhone("3");
        System.out.println("MobilePhone : " + clonedMobilePhone3.getType());
    }
}

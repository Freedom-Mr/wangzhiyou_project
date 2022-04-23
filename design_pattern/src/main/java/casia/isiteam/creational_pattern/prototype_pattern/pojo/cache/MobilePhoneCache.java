package casia.isiteam.creational_pattern.prototype_pattern.pojo.cache;

import casia.isiteam.creational_pattern.prototype_pattern.pojo.MobilePhone;
import casia.isiteam.creational_pattern.prototype_pattern.pojo.extend.Apple;
import casia.isiteam.creational_pattern.prototype_pattern.pojo.extend.HuaWei;
import casia.isiteam.creational_pattern.prototype_pattern.pojo.extend.XiaoMi;

import java.util.Hashtable;

/**
 * @ClassName: ShapeCache
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public class MobilePhoneCache {
    private static Hashtable<String, MobilePhone> mobilePhoneMap = new Hashtable<String, MobilePhone>();

    public static MobilePhone getMobilePhone(String mobilePhoneId) {
        MobilePhone cachedMobilePhone = mobilePhoneMap.get(mobilePhoneId);
        return (MobilePhone) cachedMobilePhone.clone();
    }

    // 对每种手机都运行数据库查询，并创建该手机
    // mobilePhoneMap.put(mobilePhoneKey, mobilePhone);
    // 例如，我们要添加三种手机
    public static void loadCache() {
        Apple apple = new Apple();
        apple.setId("1");
        mobilePhoneMap.put(apple.getId(),apple);

        HuaWei square = new HuaWei();
        square.setId("2");
        mobilePhoneMap.put(square.getId(),square);

        XiaoMi rectangle = new XiaoMi();
        rectangle.setId("3");
        mobilePhoneMap.put(rectangle.getId(),rectangle);
    }
}

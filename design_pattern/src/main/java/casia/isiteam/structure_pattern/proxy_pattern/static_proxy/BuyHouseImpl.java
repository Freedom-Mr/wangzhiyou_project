package casia.isiteam.structure_pattern.proxy_pattern.static_proxy;

/**
 * @ClassName: BuyHouseImpl
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/19
 * Email: zhiyou_wang@foxmail.com
 */
//买房实现
public class BuyHouseImpl implements BuyHouse {

    @Override
    public void buyHouse(Integer price) {
        System.out.println("买房,价格:" + price);
    }
}

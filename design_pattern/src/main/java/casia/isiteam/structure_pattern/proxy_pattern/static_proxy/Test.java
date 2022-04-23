package casia.isiteam.structure_pattern.proxy_pattern.static_proxy;

/**
 * @ClassName: Test
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/19
 * Email: zhiyou_wang@foxmail.com
 */
public class Test {
    public static void main(String[] args) {
        BuyHouse proxyBuy = new ProxyBuy(new BuyHouseImpl());
        proxyBuy.buyHouse(300);
    }
}

package casia.isiteam.structure_pattern.proxy_pattern.static_proxy;

/**
 * @ClassName: ProxyBuy
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/19
 * Email: zhiyou_wang@foxmail.com
 */
//代理类
public class ProxyBuy implements BuyHouse {

    private BuyHouse buyHouse;

    public ProxyBuy(BuyHouse buyHouse){
        this.buyHouse = buyHouse;
    }

    @Override
    public void buyHouse(Integer price) {
        buyHouse.buyHouse(price);
    }
}

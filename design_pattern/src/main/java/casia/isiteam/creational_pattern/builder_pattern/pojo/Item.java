package casia.isiteam.creational_pattern.builder_pattern.pojo;

/**
 * @ClassName: Item
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}

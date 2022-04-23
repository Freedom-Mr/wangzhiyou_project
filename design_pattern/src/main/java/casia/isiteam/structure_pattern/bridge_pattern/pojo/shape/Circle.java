package casia.isiteam.structure_pattern.bridge_pattern.pojo.shape;

import casia.isiteam.structure_pattern.bridge_pattern.abs.Shape;

/**
 * @ClassName: Circle
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/19
 * Email: zhiyou_wang@foxmail.com
 */
public class Circle extends Shape {

    public void draw() {
        color.bepaint("正方形");
    }
}

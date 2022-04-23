package casia.isiteam.structure_pattern.bridge_pattern.abs;

import casia.isiteam.structure_pattern.bridge_pattern.abs.Color;
/**
 * @ClassName: Shape
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/19
 * Email: zhiyou_wang@foxmail.com
 */
public abstract class Shape {
    public Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw();
}

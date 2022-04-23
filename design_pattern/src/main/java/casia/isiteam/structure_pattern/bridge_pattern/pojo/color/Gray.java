package casia.isiteam.structure_pattern.bridge_pattern.pojo.color;

import casia.isiteam.structure_pattern.bridge_pattern.abs.Color;

/**
 * @ClassName: Gray
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/19
 * Email: zhiyou_wang@foxmail.com
 */
public class Gray implements Color {

    public void bepaint(String shape) {
        System.out.println("灰色的" + shape);
    }
}

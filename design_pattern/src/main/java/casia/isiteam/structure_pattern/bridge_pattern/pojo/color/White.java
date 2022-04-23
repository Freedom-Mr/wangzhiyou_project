package casia.isiteam.structure_pattern.bridge_pattern.pojo.color;

import casia.isiteam.structure_pattern.bridge_pattern.abs.Color;

/**
 * @ClassName: White
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/19
 * Email: zhiyou_wang@foxmail.com
 */
public class White implements Color {

    public void bepaint(String shape) {
        System.out.println("白色的" + shape);
    }

}

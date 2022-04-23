package casia.isiteam.structure_pattern.adapter_pattern;

/**
 * @ClassName: ConcreteTarget
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/19
 * Email: zhiyou_wang@foxmail.com
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("concreteTarget目标方法");
    }
}

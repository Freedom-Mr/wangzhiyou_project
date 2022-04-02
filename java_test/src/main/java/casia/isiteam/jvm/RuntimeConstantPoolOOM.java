package casia.isiteam.jvm;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: RuntimeConstantPoolOOM
 * @Description: 方法区和运行时常量池溢出。
 *              1、适合JDK7以下版本运行报溢出，VM Args: -XX:PermSize-6M -XX:MaxPermSize=6M
 *              2、JDK>=7 不会出现溢出，因为原本放在永生代的字符串常量池被移到至Java堆中，所以此时限制方法区的容量对该测试毫无意义，这时候使用
 *                -Xmx6M -verbose:gc -XX:+PrintGCDetails -XX:-UseGCOverheadLimit 参数限制最大堆到6MB就能看到异常。
 *  @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/12
 * Email: zhiyou_wang@foxmail.com
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        //使用set保持常量池引用，避免Full GC回收常量池行为
        Set<String> set = new HashSet<>();

        //在short 范围内足以让6MB的permSize产生OOM了
        short i =0;
        while (true){
            set.add(String.valueOf(i++).intern());
        }
    }
}

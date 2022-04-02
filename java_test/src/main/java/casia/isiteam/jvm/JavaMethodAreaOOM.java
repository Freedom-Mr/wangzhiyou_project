package casia.isiteam.jvm;

import org.apache.log4j.EnhancedThrowableRenderer;

/**
 * @ClassName: JavaMethodAreaOOM
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/12
 * Email: zhiyou_wang@foxmail.com
 */
public class JavaMethodAreaOOM {
    public static void main(String[] args) {
        while (true) {
            EnhancedThrowableRenderer enhancer = new EnhancedThrowableRenderer();

        }
    }
    static class OOMObject{}
}

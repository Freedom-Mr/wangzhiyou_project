package casia.isiteam.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName: DirectMemoryOOM
 * @Description: 本机直接内存溢出
 *               容量大小可通过 -XX：MaxDirectMemorySize 参数来指定，如果不去指定，则默认与java堆最大值一致。
 *               VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/12
 * Email: zhiyou_wang@foxmail.com
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception{
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}

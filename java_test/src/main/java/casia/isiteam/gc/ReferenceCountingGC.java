package casia.isiteam.gc;

/**
 * @ClassName: ReferenceCountingGC
 * @Description: 验证主流java虚拟机没有选用引用计数算法进行内存管理
 *               譬如：单纯的引用计数就很难解决对象之间相互循环引用的问题
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/12
 * Email: zhiyou_wang@foxmail.com
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024;

    /**
     * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否回收过。
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        // 假设在这行发生GC，objA 和 objB 是否被回收。
        System.gc();

    }

    /**
     * 从运行结果中可以清楚看到内存回收日志中包含 （3875K->848K）,意味着虚拟对并没有因为这两个对象互相引用就放弃回收他们
     * 这也从侧面说明了java虚拟机并不是通过引用计数算法来判断对象是否存活的。
     * @param args
     */
    public static void main(String[] args) {
        testGC();
    }
}

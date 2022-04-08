package casia.isiteam.creational_pattern.singleton_pattern;

/**
 * @ClassName: Singleton
 * @Description: 单例模式的几种实现方式
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/6
 * Email: zhiyou_wang@foxmail.com
 */
public class Singleton {

    //单例模式的几种实现方式

    // ---------- 1、懒汉式，线程不安全  ---------------------
    private static Singleton instance;
    private Singleton (){}
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // ---------- 2、懒汉式，线程安全 ---------------------
    //优点：第一次调用才初始化，避免内存浪费。
    //缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率
    /*private static Singleton instance;
    private Singleton (){}
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }*/

    // ---------- 3、饿汉式 ---------------------
    //描述：这种方式比较常用，但容易产生垃圾对象。
    //优点：没有加锁，执行效率会提高。
    //缺点：类加载时就初始化，浪费内存。
    /*private static Singleton instance = new Singleton();
    private Singleton (){}
    public static Singleton getInstance() {
        return instance;
    }*/

    // ---------- 4、双检锁/双重校验锁（DCL，即 double-checked locking） ---------------------
    //描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
    /*private volatile static Singleton singleton;
    private Singleton (){}
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }*/

    // ---------- 5、登记式/静态内部类 ---------------------
    //描述：这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
    /*private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton (){}
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }*/

    // ---------- 6、枚举 ---------------------
    /*public enum Singleton2 {
        INSTANCE;
        public void whateverMethod() {
        }
    }*/

}

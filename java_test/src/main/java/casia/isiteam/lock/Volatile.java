package casia.isiteam.lock;

import java.util.concurrent.locks.Lock;

/**
 * @ClassName: Volatile
 * @Description: java虚拟机提供的最轻量化的同步机制
 *          对所有线程可见，对volatile变量所有的写操作都能立刻反映到其它线程中
 *          volatile变量在各个线程中是一致的，所以基于volatile变量运算在并发下是线程安全的
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/20
 * Email: zhiyou_wang@foxmail.com
 */
public class Volatile {
    public static volatile int race = 0;
    //用synchronized 上锁即可获取到正确的结果
    public static void increase(){
        race++;
    }
    private static final int THREADS_COUNT=20;


    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i=0;i<THREADS_COUNT;i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=0; j<10000; j++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }

        /**
         * 如果这段代码能够正确并发的话，输出结果应该是200000。
         * 但是当前运行代码每次输出的结果不一致，都是小于200000的数字，问题就出在自增运算”race++“之中,运行中当把race的值取到操作栈顶时，
         * volatile关键字保证了race的值此时正确，但是在执行加法运算时，其它线程把race的值改变了，而操作栈顶得成值就编程了过期数据。
         */
        System.out.println(race);
    }
}

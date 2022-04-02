package casia.isiteam.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: AtomicTest
 * @Description: Atomic 变量自增运算测试
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/21
 * Email: zhiyou_wang@foxmail.com
 */
public class AtomicTest {
    public static AtomicInteger race = new AtomicInteger();

    public static void increase(){
        race.incrementAndGet();
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) throws Exception{
        Thread[] threads = new Thread[THREADS_COUNT];
        for(int i=0; i<THREADS_COUNT;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<10000; i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() >2 )
            Thread.yield();
        System.out.println(race);
    }
}

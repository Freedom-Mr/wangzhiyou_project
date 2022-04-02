package casia.isiteam.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @ClassName: ExecutorServer
 * @Description: 线程池的四种方式
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/25
 * Email: zhiyou_wang@foxmail.com
 */
public class ExecutorServer {
    //线程池的四种方式，本质都是创建ThreadPoolExecutor类
    //newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
    //newFixedThreadPool  创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
    //newScheduledThreadPool 创建一个可定期或者延时执行任务的定长线程池，支持定时及周期性任务执行。
    //newCachedThreadPool 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
    public static void main(String[] args) {

//       cacheThreadPool();
//       fixTheadPoolTest();
//        singleTheadPoolTest();
//        sceduleThreadPool();

    }

    /**
     * 线程池主要参数
     * 1、corePoolSize（线程池基本大小）：当向线程池提交一个任务时，若线程池已创建的线程数小于corePoolSize，即便此时存在空闲线程，也会通过创建一个新线程来执行该任务，直到已创建的线程数大于或等于corePoolSize时，（除了利用提交新任务来创建和启动线程（按需构造），也可以通过 prestartCoreThread() 或 prestartAllCoreThreads() 方法来提前启动线程池中的基本线程。）
     * 2、maximumPoolSize（线程池最大大小）：线程池所允许的最大线程个数。当队列满了，且已创建的线程数小于maximumPoolSize，则线程池会创建新的线程来执行任务。另外，对于无界队列，可忽略该参数。
     * 3、keepAliveTime（线程存活保持时间）当线程池中线程数大于核心线程数时，线程的空闲时间如果超过线程存活时间，那么这个线程就会被销毁，直到线程池中的线程数小于等于核心线程数。
     * 4、workQueue（任务队列）：用于传输和保存等待执行任务的阻塞队列。
     * 5、threadFactory（线程工厂）：用于创建新线程。threadFactory创建的线程也是采用new Thread()方式，threadFactory创建的线程名都具有统一的风格：pool-m-thread-n（m为线程池的编号，n为线程池内的线程编号）。
     * 6、handler（线程饱和策略）：当线程池和队列都满了，再加入线程会执行此策略。
     */
    public static void ThreadPool(){

    }
    /**
     * 1.创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程<br>
     * 2.当任务数增加时，此线程池又可以智能的添加新线程来处理任务<br>
     * 3.此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小<br>
     */
    public static void cacheThreadPool() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= 10; i++) {
            final int ii = i;
            try {
                Thread.sleep(ii * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(()->
                    System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii)
            );
        }
    }

    /**
     * 1.创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小<br>
     * 2.线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程<br>
     * 3.因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字，和线程名称<br>
     */
    public static void fixTheadPoolTest() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int ii = i;
            fixedThreadPool.execute(() -> {
                System.out.println("FixedThread线程名称：" + Thread.currentThread().getName() + "，执行" + ii);
                try {
                    Random rand = new Random();
                    Thread.sleep((1+rand.nextInt(3))*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        //关闭
        fixedThreadPool.shutdown();
    }

    /**
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     */
    public static void singleTheadPoolTest() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int ii = i;
            pool.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "=>" + ii);
                    Random rand = new Random();
                    Thread.sleep((1+rand.nextInt(4))*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        //关闭
        pool.shutdown();
    }

    /**
     * 创建一个定长线程池，支持定时及周期性任务执行。延迟执行
     */
    public static void sceduleThreadPool() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        Runnable r1 = () -> System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行:3秒后执行");
        scheduledThreadPool.schedule(r1, 3, TimeUnit.SECONDS);

        Runnable r2 = () -> System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行:延迟2秒后每3秒执行一次");
        scheduledThreadPool.scheduleAtFixedRate(r2, 2, 3, TimeUnit.SECONDS);

        Runnable r3 = () -> System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行:普通任务");

        for (int i = 0; i < 5; i++) {
            scheduledThreadPool.execute(r3);
        }

        //关闭
//        scheduledThreadPool.shutdown();
    }
}

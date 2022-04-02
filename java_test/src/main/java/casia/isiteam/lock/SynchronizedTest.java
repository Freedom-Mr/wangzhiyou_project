package casia.isiteam.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: SynchronizedTest
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/25
 * Email: zhiyou_wang@foxmail.com
 */
public class SynchronizedTest {
    //synchronized: 1、以获取锁的线程执行完同步代码，释放锁 2、线程执行发生异常，jvm会让线程释放锁
    //假设A线程获得锁，B线程等待。如果A线程阻塞，B线程会一直等待

    //1.首先synchronized是java内置关键字，在jvm层面，Lock是个java类；
    //
    //2.synchronized无法判断是否获取锁的状态，Lock可以判断是否获取到锁；
    //
    //3.synchronized会自动释放锁(a 线程执行完同步代码会释放锁 ；b 线程执行过程中发生异常会释放锁)，Lock需在finally中手工释放锁（unlock()方法释放锁），否则容易造成线程死锁；
    //
    //4.用synchronized关键字的两个线程1和线程2，如果当前线程1获得锁，线程2线程等待。如果线程1阻塞，线程2则会一直等待下去，而Lock锁就不一定会等待下去，如果尝试获取不到锁，线程可以不用一直等待就结束了；
    //
    //5.synchronized的锁可重入、不可中断、非公平，而Lock锁可重入、可判断、可公平（两者皆可）
    //
    //6.Lock锁适合大量同步的代码的同步问题，synchronized锁适合代码少量的同步问题。

    public void test(Thread thread){
       synchronized (this){
           System.out.println("线程"+thread.getName() + "获取当前锁"); //打印当前锁的名称
           try {
               Thread.sleep(2000);//为看出执行效果，是线程此处休眠2秒
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("线程" + thread.getName() + "执行完毕释放锁");
       }
    }
    public static void main(String[] args) {
        SynchronizedTest lockTest = new SynchronizedTest();
        //声明一个线程 “线程一”
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.test(Thread.currentThread());
            }
        }, "thread1");
        //声明一个线程 “线程二”
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.test(Thread.currentThread());
            }
        }, "thread2");
        // 启动2个线程
        thread2.start();
        thread1.start();
    }
}

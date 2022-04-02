package casia.isiteam.thread;

import java.util.Random;

/**
 * @ClassName: ExtendsThread
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/25
 * Email: zhiyou_wang@foxmail.com
 */
public class ExtendsThread extends Thread{

    public void run(){
        try {
            Random rand = new Random();
//            Thread.sleep((2+rand.nextInt(10))*1000);
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" MyThread.run() , 优先级priority=" +Thread.currentThread().getPriority());
    }
    public void ThreadTest(){};

    public static void main(String[] args) {
        ExtendsThread extendsThread1 = new ExtendsThread();
        extendsThread1.start();

        ExtendsThread extendsThread2 = new ExtendsThread();
        //设置线程优先级
        extendsThread2.setPriority(1);
        extendsThread2.start();


    }
}

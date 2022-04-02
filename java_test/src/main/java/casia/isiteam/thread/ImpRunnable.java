package casia.isiteam.thread;

import java.util.Random;

/**
 * @ClassName: ImpRunnable
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/25
 * Email: zhiyou_wang@foxmail.com
 */
public class ImpRunnable implements Runnable{

    @Override
    public void run() {
        try {
            Random rand = new Random();
            Thread.sleep((2+rand.nextInt(10))*1000);
            System.out.println(Thread.currentThread().getName()+" thread.run()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ImpRunnable impRunnable = new ImpRunnable();
        Thread thread1 = new Thread(impRunnable);
        thread1.start();

        Thread thread2 = new Thread(impRunnable);
        thread2.setName("aa");
        thread2.start();

    }
}

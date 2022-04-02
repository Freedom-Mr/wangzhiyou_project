package casia.isiteam.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: ImpCallable
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/25
 * Email: zhiyou_wang@foxmail.com
 */
public class ImpCallable{
    class CallableTest<String> implements Callable<Object>{
        @Override
        public Object call() throws Exception {
            try {
                Random rand = new Random();
//            Thread.sleep((2+rand.nextInt(10))*1000);
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Thread.currentThread().getName()+"线程执行完毕！";
        }
    }

    public void test() throws ExecutionException, InterruptedException {
        Callable<Object> callableTest = new CallableTest<Object>();

        //使用FutureTask类包装Callable对象，该FutureTask对象封装了Callable对象的Call方法的放回值
        FutureTask<Object> onetask = new FutureTask<Object>(callableTest);

        //创建Thread对象，参数为FutureTask对象
        Thread t = new Thread(onetask,"线程1");

        //启动线程
        t.start();

        //获取线程执行完毕后的结果
        System.out.println(onetask.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ImpCallable impCallable = new ImpCallable();
        impCallable.test();
    }
}

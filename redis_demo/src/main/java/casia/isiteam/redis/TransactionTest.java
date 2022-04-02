package casia.isiteam.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @ClassName: TransactionTest
 * @Description: 并发事务测试
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/18
 * Email: zhiyou_wang@foxmail.com
 */
public class TransactionTest {


    public static void main(String[] args) {
        TransactionTest test = new TransactionTest();
        test.test();
    }
    public void test(){
        //该线程会先启动，这里开启watch 监控和 事务后，设置了线程阻塞，在此期间下面的线程执行完毕并修改了值，watch状态变化 所以当前事务不执行。
        ThreadTest threadTest1 = new ThreadTest(10,"v2");
        threadTest1.start();

        //该线程会比上面的线程启动晚，但是会提前执行完事务，修改了值
        ThreadTest threadTest2 = new ThreadTest(1,"v1");
        threadTest2.start();

        //到了这里，事务操作基本了解了。但是有人会想到一个问题：
        // Redis 事务中如何解决并发修改的问题？
        //例如秒杀20个商品，会出现的问题
        // 1，库存会出现复数，为何会这样呢？因为如30个用户同时拿到数据，都会进行减1操作，库存就会出现-10；
        // 2， 库存剩余问题
        // 那如何解决呢？
        // 解决超卖问题？思路是 利用redis  watch监听商品变化，把需要减商品的步骤放入multi中，当watch(key) 发生变化时，会自动取消事务，但是这样
        // 会出现问题2，商品库存遗留问题，因为比如我们设置并发量为200，其中只有1个人能够成功，这样就会出现遗留问题，

    }
    class ThreadTest extends Thread{
        private long sleep;
        private String value;
        public ThreadTest(int sleep,String value){
            this.sleep = sleep;
            this.value = value;
        }
        @Override
        public void run() {
            Jedis jedis = new Jedis("http://127.0.0.1:6379");
            jedis.auth("root");

            try {
                //事务过程
                // 设置键值
                jedis.set("k", "v");
                // 开启监视 watch （乐观锁）, 被修改时，提供整个事务回滚的功能
                jedis.watch("k");
//                jedis.unwatch();//关闭监视

                // 开始事务
                Transaction tx = jedis.multi();

                // 命令入列
                tx.set("k", this.value);
                tx.expire("k",20);

                //阻塞
                try {
                    System.out.println("阻塞："+this.sleep);
                    Thread.sleep(this.sleep * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //丢弃事务
//                tx.discard();

                // 执行事务
                tx.exec();
                System.out.println(jedis.get("k"));
            }catch (Exception e){
                System.out.print("线程-"+this.sleep);
                System.out.println(e.getMessage());
            }finally {
                //关闭
                jedis.close();
            }
            System.out.println(this.sleep+"完成");
        }
    }
}

package casia.isiteam.redis;

import redis.clients.jedis.Jedis;

/**
 * @ClassName: SetType
 * @Description: set 集合类型
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/18
 * Email: zhiyou_wang@foxmail.com
 */
public class SetType {
    private static Jedis jedis;
    public SetType(){
        //连接本地的 Redis 服务
        jedis = new Jedis("http://127.0.0.1:6379");
        // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
        jedis.auth("root");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }

    public static void main(String[] args) {
        SetType setType =new SetType();

        //向集合添加一个或多个成员
        System.out.println( jedis.sadd("s","a") );
        System.out.println( jedis.sadd("s","a","b") );
        System.out.println( jedis.sadd("ss","c","b") );

        //获取集合的成员数
        System.out.println( jedis.scard("s"));

        //返回第一个集合与其他集合之间的差异。
        System.out.println( jedis.sdiff("s"));

        //返回给定所有集合的差集并存储在 destination 中
//        System.out.println( jedis.sdiffstore("s","ss"));

        //判断 member 元素是否是集合 key 的成员
        System.out.println( jedis.sismember("s","a") );

        //返回集合中的所有成员
        System.out.println( jedis.smembers("s") );

        //将 member 元素从 source 集合移动到 destination 集合
        System.out.println( jedis.smove( "s", "s2","a" ));

        //移除并返回集合中的一个随机元素
        System.out.println( jedis.spop("ss") );

        //返回集合中一个或多个随机数
        System.out.println( jedis.srandmember("s") );

        //移除集合中一个或多个成员
        System.out.println( jedis.srem("s","c") );


        //所有给定集合的并集存储在 destination 集合中
        System.out.println( jedis.sunionstore("s","b") );


        //关闭
        jedis.close();
    }
}

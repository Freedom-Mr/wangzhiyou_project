package casia.isiteam.redis;

import redis.clients.jedis.Jedis;

/**
 * @ClassName: SortedSetType
 * @Description: 有序set 类型
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/18
 * Email: zhiyou_wang@foxmail.com
 */
public class SortedSetType {
    private static Jedis jedis;
    public SortedSetType(){
        //连接本地的 Redis 服务
        jedis = new Jedis("http://127.0.0.1:6379");
        // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
        jedis.auth("root");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }

    public static void main(String[] args) {
        SortedSetType setType =new SortedSetType();

        //向集合添加一个或多个成员
        System.out.println( jedis.zadd("z",1,"a") );
        System.out.println( jedis.zadd("z",0,"b") );

        //获取集合的成员数
        System.out.println( jedis.zcard("z"));

        //计算在有序集合中指定区间分数的成员数
        System.out.println( jedis.zcount("z",0,2));

        //有序集合中对指定成员的分数加上增量 increment
        System.out.println( jedis.zincrby("z",1,"a"));

        //计算给定的一个或多个有序集的交集并将结果集存储在新的有序集合 destination 中
//        System.out.println( jedis.zinterstore("z","zz") );

        //在有序集合中计算指定字典区间内成员数量
        System.out.println( jedis.zlexcount("z","-","+") );

        //通过分数返回有序集合指定区间内的成员
        System.out.println( jedis.zrangeByScore( "z", "1","2" ));

        //返回有序集合中指定成员的索引
        System.out.println( jedis.zrange("z",0,1) );

        //移除有序集合中的一个或多个成员
        System.out.println( jedis.zrem("z","c") );

        //移除有序集合中给定的排名区间的所有成员
//        System.out.println( jedis.zremrangeByRank("z",5,8) );

        //移除有序集合中给定的分数区间的所有成员
//        System.out.println( jedis.zrangeByScore("z",3,4) );

        //返回有序集中指定区间内的成员，通过索引，分数从高到低
        System.out.println( jedis.zrevrange("z",0,3) );

        //返回有序集中指定分数区间内的成员，分数从高到低排序
        System.out.println( jedis.zrevrangeByScore("z",0,3) );

        //返回有序集合中指定成员的排名，有序集成员按分数值递减(从大到小)排序
        System.out.println( jedis.zrevrank("z","a") );

        //返回有序集中，成员的分数值
        System.out.println( jedis.zscore("z","a") );

        //计算给定的一个或多个有序集的并集，并存储在新的 key 中
        System.out.println( jedis.zunionstore("z","a") );

        //关闭
        jedis.close();
    }
}

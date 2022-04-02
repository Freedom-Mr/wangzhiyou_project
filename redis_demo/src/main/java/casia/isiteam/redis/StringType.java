package casia.isiteam.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @ClassName: StringType
 * @Description: 数据类型，字符串（String)
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/18
 * Email: zhiyou_wang@foxmail.com
 */
public class StringType {
    private static Jedis jedis;
    public StringType(){
        //连接本地的 Redis 服务
        jedis = new Jedis("http://127.0.0.1:6379");
        // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
        jedis.auth("root");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }
    public static void main(String[] args) {
        StringType stringType = new StringType();

        //写入key
        System.out.println( jedis.set("a","123") );

        //获取指定key
        System.out.println( jedis.get("a") );

        //返回 key 中字符串值的子字符
        System.out.println( jedis.getrange("a",0,1) );

        //将给定 key 的值设为 value ，并返回 key 的旧值(old value)。
        System.out.println( jedis.getSet("a","234") );

        //对 key 所储存的字符串值，获取指定偏移量上的位(bit)。
        System.out.println( jedis.getbit("a",1) );

        //获取所有(一个或多个)给定 key 的值。
        List<String> rs = jedis.mget("a","b");
        rs.stream().forEach(System.out::println);

        //对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit)。
//        jedis.setbit("a",1L,false);

        //将值 value 关联到 key ，并将 key 的过期时间设为 seconds (以秒为单位)。
        System.out.println( jedis.setex("a",60,"345") );

        //只有在 key 不存在时设置 key 的值。
        System.out.println( jedis.setnx("b","345") );

        //返回 key 所储存的字符串值的长度。
        System.out.println( jedis.strlen("b") );

        //同时设置一个或多个 key-value 对
        System.out.println( jedis.mset("a","456","b","234") );

        //同时设置一个或多个 key-value 对，当且仅当所有给定 key 都不存在。
        System.out.println( jedis.msetnx("a","456","c","234") );

        //这个命令和 SETEX 命令相似，但它以毫秒为单位设置 key 的生存时间，而不是像 SETEX 命令那样，以秒为单位。
        System.out.println( jedis.psetex("a",30,"567") );

        //将 key 中储存的数字值增一。
        System.out.println( jedis.incr("b") );

        //将 key 所储存的值加上给定的浮点增量值（increment） 。
        System.out.println( jedis.incrBy("b",12) );

        //key 所储存的值减去给定的减量值（decrement） 。
        System.out.println( jedis.decr("b") );
        System.out.println( jedis.decrBy("b",10) );

        //如果 key 已经存在并且是一个字符串， APPEND 命令将指定的 value 追加到该 key 原来值（value）的末尾。
        System.out.println( jedis.append("a","3") );

        //删除
        System.out.println( jedis.del("a","b") );

        jedis.close();
    }
}

package casia.isiteam.redis;

import redis.clients.jedis.Jedis;

/**
 * @ClassName: RedisClinet
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/18
 * Email: zhiyou_wang@foxmail.com
 */
public class RedisClinet {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("http://127.0.0.1:6379");
        // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
        jedis.auth("root");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());

        //选择数据库
        System.out.println(jedis.select(2));

        //测试写入字符串
        jedis.set("a","1");
        String s = jedis.get("a");
        System.out.println(s);


        jedis.close();
    }
}

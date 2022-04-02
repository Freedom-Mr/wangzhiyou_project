package casia.isiteam.redis;

import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @ClassName: HashType
 * @Description: 哈希类型
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/18
 * Email: zhiyou_wang@foxmail.com
 */
public class HashType {
    private static Jedis jedis;
    public HashType(){
        //连接本地的 Redis 服务
        jedis = new Jedis("http://127.0.0.1:6379");
        // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
        jedis.auth("root");

        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }

    public static void main(String[] args) {
        HashType hashType = new HashType();

        // field-value (域-值)对设置到哈希表 key 中。
        System.out.println( jedis.hset("h","a","1") );
        System.out.println( jedis.hsetnx("h","b","1") );//只有在字段 field 不存在时，设置哈希表字段的值。
        System.out.println( jedis.hmget("h","a","2","a","3") );

        //查看哈希表 key 中，指定的字段是否存在。
        System.out.println( jedis.exists("h") );

        //获取存储在哈希表中指定字段的值。
        System.out.println( jedis.hget("h","a") );

        //获取在哈希表中指定 key 的所有字段和值
        Map<String,String> maps = jedis.hgetAll("h");
        maps.forEach((k,v)->{
            System.out.println(k+"\t"+v);
        });

        //为哈希表 key 中的指定字段的浮点数值加上增量 increment 。
        System.out.println( jedis.hincrBy("h","a",1) );
        System.out.println( jedis.hincrByFloat("h","a",1) );

        //获取所有哈希表中的字段
        System.out.println( jedis.hkeys("h") );

        //获取哈希表中字段的数量
        System.out.println( jedis.hlen("h") );

        //获取哈希表中所有值。
        System.out.println( jedis.hvals("h") );

        //迭代哈希表中的键值对。
//        System.out.println( jedis.hscan("h","a") );

        //删除指定字段
        System.out.println( jedis.hdel("h","b") );

        //删除key
        System.out.println( jedis.del("h") );

        //关闭
        jedis.close();
    }
}

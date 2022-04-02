package casia.isiteam.redis;

import redis.clients.jedis.Jedis;

/**
 * @ClassName: KeyTest
 * @Description: key 测试
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/18
 * Email: zhiyou_wang@foxmail.com
 */
public class KeyTest {
    private static Jedis jedis;
    public KeyTest(){
        //连接本地的 Redis 服务
        jedis = new Jedis("http://127.0.0.1:6379");
        // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
        jedis.auth("root");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }

    public static void main(String[] args) {
        KeyTest keyTest = new KeyTest();

        //检查key是否存在
        boolean isExists = jedis.exists("a");
        System.out.println( isExists );

        //写入key
        if( !isExists ){
            System.out.println( jedis.set("a","1") );
        }

        //返回key的数据类型
        System.out.println( jedis.type("a") );

        //序列化给定 key ，并返回被序列化的值。
        byte[] bytes = jedis.dump("a");
        System.out.println( bytes );

        //设置key过期时间,单位 seconds 秒
        System.out.println(  jedis.expire("a",20) );//秒
        System.out.println(  jedis.pexpire("a",50000) );//毫秒

        //返回剩余过期时间
        System.out.println( jedis.pttl("a") );

        //移除key的过期时间
        System.out.println( jedis.persist("a") );

        //从当前数据库随机返回一个key
        System.out.println( jedis.randomKey() );

        //修改key名称
        System.out.println( jedis.rename("a","b") );

        //迭代
        /*ScanResult<String> ss = jedis.scan("a");
        System.out.println(ss.getCursor());
        List<String> rs = ss.getResult();
        for (String s:rs) {
            System.out.println(s);
        }*/

        //将当前数据库的 key 移动到给定的数据库 db 当中。
//        jedis.move("a",1);

        //关闭
        jedis.close();
    }
}

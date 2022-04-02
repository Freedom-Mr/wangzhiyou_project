package casia.isiteam.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.args.ListPosition;

/**
 * @ClassName: ListType
 * @Description: List 类型
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/18
 * Email: zhiyou_wang@foxmail.com
 */
public class ListType {
    private static Jedis jedis;
    public ListType(){
        //连接本地的 Redis 服务
        jedis = new Jedis("http://127.0.0.1:6379");
        // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
        jedis.auth("root");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }

    public static void main(String[] args) {
        ListType listType = new ListType();

        //将一个值插入到已存在的列表头部
        System.out.println( jedis.lpush("l",System.currentTimeMillis()/1000 +"") );
        System.out.println( jedis.lpushx("l",(System.currentTimeMillis()+1000)/1000 +"") );
        System.out.println( jedis.lpushx("l",(System.currentTimeMillis()+1000)/1000 +"") );

        //移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
        System.out.println( jedis.blpop(100,"l"));

        //移出并获取列表的最后一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
        System.out.println( jedis.brpop(100,"l"));

        //从列表中弹出一个值，将弹出的元素插入到另外一个列表中并返回它； 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
        System.out.println( jedis.brpoplpush("l","ll",100));

        //通过索引获取列表中的元素
        System.out.println( jedis.lindex("ll",0) );

        //通过索引设置列表元素的值
        System.out.println( jedis.lset("ll",0,"12") );

        //在列表的元素前或者后插入元素
        System.out.println( jedis.linsert( "ll", ListPosition.BEFORE,"12","1647590725" ));

        //获取列表长度
        System.out.println( jedis.llen("ll") );

        //获取列表指定范围内的元素
        System.out.println( jedis.lrange("ll",0,2) );

        //移除列表的最后一个元素，并将该元素添加到另一个列表并返回
        System.out.println( jedis.rpoplpush("ll","lll") );

        //在列表中添加一个或多个值
        System.out.println( jedis.rpush("lll","a") );

        //为已存在的列表添加值
        System.out.println( jedis.rpushx("lll","b") );

        //移出并获取列表的第一个元素
        System.out.println( jedis.lpop("ll") );

        //移除列表的最后一个元素，返回值为移除的元素。
        System.out.println( jedis.rpop("ll") );

        //移除列表元素
        System.out.println( jedis.lrem("ll",-2,"12") );

        //对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。
        System.out.println( jedis.ltrim("lll",5,7) );

        //关闭
        jedis.close();
    }
}

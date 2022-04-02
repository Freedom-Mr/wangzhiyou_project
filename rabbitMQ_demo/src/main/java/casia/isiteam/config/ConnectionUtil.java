package casia.isiteam.config;

import org.apache.log4j.Logger;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @ClassName: ConnectionUtil
 * @Description: 连接类
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/28
 * Email: zhiyou_wang@foxmail.com
 */
public class ConnectionUtil {
    private static Logger logger = Logger.getLogger(ConnectionUtil.class);

    public static Connection getConnection() {
        try {
            Connection connection = null;
            //定义一个连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            //设置服务端地址（域名地址/ip）
            factory.setHost("n3");
            //设置服务器端口号
            factory.setPort(5672);
            //设置虚拟主机(相当于数据库中的库)
            factory.setVirtualHost("/");
            //设置用户名
            factory.setUsername("guest");
            //设置密码
            factory.setPassword("guest");
            connection = factory.newConnection();
            return connection;
        } catch (Exception e) {
            return null;
        }
    }
}

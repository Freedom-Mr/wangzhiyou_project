package casia.isiteam.routingQueue;

import casia.isiteam.config.ConnectionUtil;
import casia.isiteam.config.RabbitConstant;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: ProviderTest
 * @Description: 路由模式-生产者
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/28
 * Email: zhiyou_wang@foxmail.com
 */
public class Provider {
    private static final String exchangeName = "routing-exchange";//交换机名称
    public static void main(String[] args) throws IOException, TimeoutException {
        Provider providerTest = new Provider();
        providerTest.testProvider();
    }

    /**
     * 生产者
     */
    public void testProvider() throws IOException, TimeoutException {
        //1.获取连接
        Connection connection = ConnectionUtil.getConnection();

        //创建通信“通道”，相当于TCP中的虚拟连接
        Channel channel = connection.createChannel();

        //创建一个交换机,
        // 交换机名称
        // 交换机的类型：选择 DIRECT 路由模式（把交换机中的消息发送给所有的绑定到交换机的队列）
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT);

        //创建队列,声明并创建俩个队列，如果队列已存在，则使用这个队列
        //第一个参数：队列名称
        //第二个参数：是否持久化，false对应不持久化数据，MQ停掉数据就会丢失
        //第三个参数：是否队列私有化，false则代表所有消费者都可以访问，true代表只有第一次拥有它的消费者才能一直使用，其他消费者不让访问
        //第四个：是否自动删除,false代表连接停掉后不自动删除掉这个队列
        //其他额外的参数, null
        channel.queueDeclare(RabbitConstant.ROUTING_QUEUES_1,false, false, false, null);
        channel.queueDeclare(RabbitConstant.ROUTING_QUEUES_2,false, false, false, null);

        //把者两个队列绑定到交换机上
        //第一个参数：队列名称
        //第二个参数：交换机名称
        //第三个参数：是路由键
        channel.queueBind(RabbitConstant.ROUTING_QUEUES_1,exchangeName,"error");
        channel.queueBind(RabbitConstant.ROUTING_QUEUES_2,exchangeName,"info");

        //四个参数
        //exchange 交换机
        //队列名称不需要填入
        //额外的设置属性
        //最后一个参数是要传递的消息字节数组
        for(int i=1;i<11;i++){
            String message = "";
            if(i%2==0){
                message = "routing-queue-error-"+i;
                channel.basicPublish(exchangeName, "error", null,message.getBytes());
            }else{
                message = "routing-queue-info-"+i;
                channel.basicPublish(exchangeName, "info", null,message.getBytes());
                //如果设置路由键与上面绑定的不一致，消息会丢失，如下列定义debug路由键
//                channel.basicPublish(exchangeName, "debug", null,message.getBytes());
            }
            System.out.println(message+" ===发送成功===");
        }

        //关闭
        channel.close();
        connection.close();
    }
}

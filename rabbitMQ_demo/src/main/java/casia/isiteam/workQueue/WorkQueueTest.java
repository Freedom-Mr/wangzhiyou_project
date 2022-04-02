package casia.isiteam.workQueue;

import casia.isiteam.config.ConnectionUtil;
import casia.isiteam.config.RabbitConstant;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: WorkQueueTest
 * @Description: 简单工作模式模式
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/28
 * Email: zhiyou_wang@foxmail.com
 */
public class WorkQueueTest {
    /**
     * 简单工作模式模式
     * @param args
     * @throws IOException
     * @throws TimeoutException
     */
    public static void main(String[] args) throws IOException, TimeoutException {
        WorkQueueTest workQueueTest = new WorkQueueTest();
//        workQueueTest.testProvider();
        workQueueTest.testConsumer();
    }

    /**
     * 生产者
     */
    public void testProvider() throws IOException, TimeoutException {
        //1.获取连接
        Connection connection = ConnectionUtil.getConnection();

        //创建通信“通道”，相当于TCP中的虚拟连接
        Channel channel = connection.createChannel();

        //创建队列,声明并创建一个队列，如果队列已存在，则使用这个队列
        //第一个参数：队列名称ID
        //第二个参数：是否持久化，false对应不持久化数据，MQ停掉数据就会丢失
        //第三个参数：是否队列私有化，false则代表所有消费者都可以访问，true代表只有第一次拥有它的消费者才能一直使用，其他消费者不让访问
        //第四个：是否自动删除,false代表连接停掉后不自动删除掉这个队列
        //其他额外的参数, null
        channel.queueDeclare(RabbitConstant.QUEUE_HELLOWORLD,false, false, false, null);

        String message = "这是简单工作模式的一条消息,"+System.currentTimeMillis();
        //四个参数
        //exchange 交换机，暂时用不到，在后面进行发布订阅时才会用到
        //队列名称
        //额外的设置属性
        //最后一个参数是要传递的消息字节数组
        channel.basicPublish("", RabbitConstant.QUEUE_HELLOWORLD, null,message.getBytes());
        System.out.println("===发送成功===");

        //关闭
        channel.close();
        connection.close();
    }

    /**
     * 消费者
     */
    public void testConsumer() throws IOException, TimeoutException {
        //获取TCP长连接
        Connection connection = ConnectionUtil.getConnection();

        //创建通信“通道”，相当于TCP中的虚拟连接
        Channel channel = connection.createChannel();

        //从MQ服务器中获取数据
        //创建一个消息消费者
        //第一个参数：队列名
        //第二个参数代表是否自动确认收到消息，false代表手动编程来确认消息，这是MQ的推荐做法
        //第三个参数要传入DefaultConsumer的实现类
        String msg = channel.basicConsume(RabbitConstant.QUEUE_HELLOWORLD, false, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body);
                System.out.println("消费者接收到的消息："+message);

                System.out.println("消息的TagId："+envelope.getDeliveryTag());
                //手动提交 ack
                //第一个参数：deliveryTag	消息的随机标签信息
                //第二个参数：false只确认签收当前的消息，设置为true的时候则代表签收该消费者所有未签收的消息
                channel.basicAck(envelope.getDeliveryTag(), false);

                //拒绝消息 Nack：消费者处理如果出了问题，需要告诉队列信息消费失败
                //第一个参数：deliveryTag	消息的随机标签信息
                //第二个参数：multiple 是否批量；true表示一次性的将小于deliveryTag的值进行ack
                //第三个参数：requeue 被拒绝的消息是否重新入队列
//                channel.basicNack(envelope.getDeliveryTag(),false,false);

                //拒绝消息 Reject
                //第一个参数：deliveryTag	消息的随机标签信息
                //第三个参数：requeue 被拒绝的消息是否重新入队列
//                channel.basicReject(envelope.getDeliveryTag(),false);
            }
        });

        System.in.read();
        //关闭
        channel.close();
        connection.close();
    }

}

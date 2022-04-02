package casia.isiteam.workQueues;

import casia.isiteam.config.ConnectionUtil;
import casia.isiteam.config.RabbitConstant;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: Consumer1
 * @Description: 工作队列模式-消费者1
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/28
 * Email: zhiyou_wang@foxmail.com
 */
public class Consumer2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        Consumer2 consumer2 = new Consumer2();
        consumer2.consumer();
    }
    public void consumer() throws IOException, TimeoutException {
        //获取TCP长连接
        Connection connection = ConnectionUtil.getConnection();

        //创建通信“通道”，相当于TCP中的虚拟连接
        Channel channel = connection.createChannel();

        //从MQ服务器中获取数据
        //创建一个消息消费者
        //第一个参数：队列名
        //第二个参数代表是否自动确认收到消息，false代表手动编程来确认消息，这是MQ的推荐做法
        //第三个参数要传入DefaultConsumer的实现类
        String msg = channel.basicConsume(RabbitConstant.WORK_QUEUES, false, new DefaultConsumer(channel){
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

//package casia.isiteam.rpcQueue;
//
//import casia.isiteam.config.ConnectionUtil;
//import casia.isiteam.config.RabbitConstant;
//import com.rabbitmq.client.*;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
///**
// * @ClassName: ProviderTest
// * @Description: rpc模式-生产者
// * @Vsersion: 1.0
// * <p>
// * Created by casia.wangzhiyou on 2022/3/28
// * Email: zhiyou_wang@foxmail.com
// */
//public class Provider {
//    private static final String exchangeName = "rpc-exchange";//交换机名称
//    public static void main(String[] args) throws IOException, TimeoutException {
//        Provider providerTest = new Provider();
//        providerTest.testProvider();
//    }
//
//    /**
//     * 生产者
//     */
//    public void testProvider() throws IOException, TimeoutException {
//        //1.获取连接
//        Connection connection = ConnectionUtil.getConnection();
//
//        //创建通信“通道”，相当于TCP中的虚拟连接
//        Channel channel = connection.createChannel();
//
//
//        /*
//         * 定义队列 rpc_queue, 将从它接收请求信息
//         *
//         * 参数:
//         * 1. queue, 对列名
//         * 2. durable, 持久化
//         * 3. exclusive, 排他
//         * 4. autoDelete, 自动删除
//         * 5. arguments, 其他参数属性
//         */
//        channel.queueDeclare(RabbitConstant.RPC_QUEUES,false,false,false,null);
//        channel.queuePurge(RabbitConstant.RPC_QUEUES);//清除队列中的内容
//
//        channel.basicQos(1);//一次只接收一条消息
//
//
//        //收到请求消息后的回调对象
//        DeliverCallback deliverCallback = new DeliverCallback() {
//            @Override
//            public void handle(String consumerTag, Delivery message) throws IOException {
//                //处理收到的数据(要求第几个斐波那契数)
//                String msg = new String(message.getBody(), "UTF-8");
//                int n = Integer.parseInt(msg);
//                //求出第n个斐波那契数
//                int r = fbnq(n);
//                String response = String.valueOf(r);
//
//                //设置发回响应的id, 与请求id一致, 这样客户端可以把该响应与它的请求进行对应
//                BasicProperties replyProps = new BasicProperties.Builder()
//                        .correlationId(message.getProperties().getCorrelationId())
//                        .build();
//                /*
//                 * 发送响应消息
//                 * 1. 默认交换机
//                 * 2. 由客户端指定的,用来传递响应消息的队列名
//                 * 3. 参数(关联id)
//                 * 4. 发回的响应消息
//                 */
//                channel.basicPublish("",message.getProperties().getReplyTo(), replyProps, response.getBytes("UTF-8"));
//                //发送确认消息
//                channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
//            }
//
//
//        };
//
//        //
//        CancelCallback cancelCallback = new CancelCallback() {
//            @Override
//            public void handle(String consumerTag) throws IOException {
//            }
//        };
//
//        //消费者开始接收消息, 等待从 rpc_queue接收请求消息, 不自动确认
//        channel.basicConsume(RabbitConstant.RPC_QUEUES, false, deliverCallback, cancelCallback);
//
//        //关闭
//        channel.close();
//        connection.close();
//    }
//    protected static int fbnq(int n) {
//        if(n == 1 || n == 2) return 1;
//
//        return fbnq(n-1)+fbnq(n-2);
//    }
//
//}

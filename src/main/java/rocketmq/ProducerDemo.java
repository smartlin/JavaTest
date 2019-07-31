package rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * Created by starlin
 * on 2018/5/23 10:53.
 * 生产者示例
 */
public class ProducerDemo {
    // 在生产者范例中，我们制定了消费组为"mengzhidu-user"，
    // 并且我们制定了命名服务器的地址，然后我们就开始了生产者，
    // 然后我们在一个for循环中发送了五次消息，然后我们在生产者中获取了消息的状态。
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("starlin-user");
        //指定NameServer地址，多个地址以 ; 隔开
        producer.setNamesrvAddr("192.168.235.134:9876");

        /**
        * Producer对象在使用之前必须要调用start初始化，初始化一次即可
        * 注意：切记不可以在每次发送消息时，都调用start方法
        */
        producer.start();

        for (int i = 0; i < 5; i++) {
            Message message = new Message("user", "push", String.valueOf(i), new String("starlin-" + i).getBytes());
            SendResult result = producer.send(message);
            System.out.println("消息id为：" + result.getMsgId() + "发送状态为：" + result.getSendStatus());
        }
    }
}


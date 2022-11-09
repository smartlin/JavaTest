package rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * Created by starlin
 * on 2018/5/23 10:59.
 * ������ʾ��
 */
public class ConsumerDemo {
    // ���ǵ�������Ҳ�ƶ�������Ϊ"starlin-user"��
    // ������Ҳָ���������������ĵ�ַ��Ȼ�����������յ���Ϣ��Ĵ���ʽ��Ȼ��������������ߡ�
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("benchmark_consumer");
        //ָ��NameServer��ַ�������ַ�� ; ����
        consumer.setNamesrvAddr("192.168.32.190:9876");
        consumer.subscribe("user","push");
        /**
         * ����Consumer��һ�������ǴӶ���ͷ����ʼ���ѻ��Ƕ���β����ʼ����
         * ����ǵ�һ����������ô�����ϴ����ѵ�λ�ü�������
         */
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.registerMessageListener(new MessageListenerConcurrently(){
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                Message message = list.get(0);
                System.out.println("�������յ�����Ϣ���ݣ�" + new String(message.getBody()));
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.start();
    }
}

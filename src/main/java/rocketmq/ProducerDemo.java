package rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * Created by starlin
 * on 2018/5/23 10:53.
 * ������ʾ��
 */
public class ProducerDemo {
    // �������߷����У������ƶ���������Ϊ"mengzhidu-user"��
    // ���������ƶ��������������ĵ�ַ��Ȼ�����ǾͿ�ʼ�������ߣ�
    // Ȼ��������һ��forѭ���з����������Ϣ��Ȼ���������������л�ȡ����Ϣ��״̬��
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("starlin-user");
        //ָ��NameServer��ַ�������ַ�� ; ����
        producer.setNamesrvAddr("192.168.235.134:9876");

        /**
        * Producer������ʹ��֮ǰ����Ҫ����start��ʼ������ʼ��һ�μ���
        * ע�⣺�мǲ�������ÿ�η�����Ϣʱ��������start����
        */
        producer.start();

        for (int i = 0; i < 5; i++) {
            Message message = new Message("user", "push", String.valueOf(i), new String("starlin-" + i).getBytes());
            SendResult result = producer.send(message);
            System.out.println("��ϢidΪ��" + result.getMsgId() + "����״̬Ϊ��" + result.getSendStatus());
        }
    }
}


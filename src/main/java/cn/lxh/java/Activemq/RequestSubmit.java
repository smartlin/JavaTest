package cn.lxh.java.Activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by starlin
 * on 2017/09/04 14:34.
 */
public class RequestSubmit {
    //��Ϣ������
    private MessageProducer producer;
    //һ�����ͻ��߽�����Ϣ���߳�
    private Session session;

    public void init() throws Exception {
        //ConnectionFactory���ӹ�����JMS������������
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://192.168.128.132:61616");
        //Connection��JMS�ͻ��˵�JMS Provider�����ӣ��ӹ��칤���еõ����Ӷ���
        Connection connection = connectionFactory.createConnection();
        //����
        connection.start();
        //��ȡ���Ӳ���
        session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destinatin = session.createQueue("RequestQueue");
        //�õ���Ϣ���ɣ����ͣ���
        producer = session.createProducer(destinatin);
        //���ò��־û�
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
    }

    public void submit(HashMap<Serializable,Serializable> requestParam) throws Exception {
        ObjectMessage message = session.createObjectMessage(requestParam);
        producer.send(message);
        session.commit();
    }

    public static void main(String[] args) throws Exception{
        RequestSubmit submit = new RequestSubmit();
        submit.init();
        HashMap<Serializable,Serializable> requestParam = new HashMap<Serializable,Serializable>();
        requestParam.put("starlin", "zzh");
        submit.submit(requestParam);
    }
}

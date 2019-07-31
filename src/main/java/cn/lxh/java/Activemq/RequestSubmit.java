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
    //消息发送者
    private MessageProducer producer;
    //一个发送或者接受消息的线程
    private Session session;

    public void init() throws Exception {
        //ConnectionFactory连接工厂，JMS用它创建连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://192.168.128.132:61616");
        //Connection：JMS客户端到JMS Provider的连接，从构造工厂中得到连接对象
        Connection connection = connectionFactory.createConnection();
        //启动
        connection.start();
        //获取连接操作
        session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destinatin = session.createQueue("RequestQueue");
        //得到消息生成（发送）者
        producer = session.createProducer(destinatin);
        //设置不持久化
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

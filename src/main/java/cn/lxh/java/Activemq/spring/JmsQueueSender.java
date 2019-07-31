package cn.lxh.java.Activemq.spring;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;

/**
 * Created by starlin
 * on 2017/09/04 16:27.
 */
@Component
public class JmsQueueSender {
    private JmsTemplate jmsTemplate;

    public void setConnectionFactory(ConnectionFactory connectionFactory){
        this.jmsTemplate = new JmsTemplate(connectionFactory);
    }

    public void simpleSend(){
        jmsTemplate.convertAndSend("Queue.name","test!!!");
    }

    public JmsTemplate getJmsTemplate(){
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}

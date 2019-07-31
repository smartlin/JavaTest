package cn.lxh.java.Activemq.spring;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by starlin
 * on 2017/09/04 16:28.
 */
@Component
public class JmsQueueReceiver implements MessageListener {

    @Override
    public void onMessage(Message message) {
        if(message instanceof TextMessage){
            final TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println(textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}

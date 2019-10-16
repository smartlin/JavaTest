package quartz.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("simpleService")
public class SimpleService {
    
    private static final long serialVersionUID = 122323233244334343L;
    private static final Logger logger = LoggerFactory.getLogger(SimpleService.class);
    
    public void testMethod1(){
        //����ִ�ж�ʱ����ҵ��
        logger.info("testMethod1.......1");
        System.out.println("2--testMethod1......."+System.currentTimeMillis()/1000);
    }
    
    public void testMethod2(){
        logger.info("testMethod2.......2");    
    }
}
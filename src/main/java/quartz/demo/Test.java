package quartz.demo;

import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by starlin
 * on 2018/8/12 18:44.
 */
public class Test {
    public static void main(String[] args) throws SchedulerException {
        ApplicationContext context = new ClassPathXmlApplicationContext("quartz/spring-quartz.xml");
    }
}

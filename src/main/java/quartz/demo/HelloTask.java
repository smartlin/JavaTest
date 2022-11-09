package quartz.demo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by starlin
 * on 2018/8/12 18:24.
 */
public class HelloTask implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello World! MyJob is executing.111");
    }
    public static void main(String[] args) {
        ApplicationContext springContext = new ClassPathXmlApplicationContext("/quartz/spring-quartz.xml");

    }
}

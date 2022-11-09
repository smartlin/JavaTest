package quartz.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by starlin
 * on 2018/8/12 18:24.
 */
public class HelloTask1 implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello World! MyJob is executing.11");
    }

    public static void main(String[] args) {
        try {
            // 获取调度器
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            // 创建Job执行类
            JobDetail job = JobBuilder.newJob(HelloTask.class)
                    .storeDurably()
                    .withIdentity("hello world ", "test")
                    .build();
            // 创建trigger,每分钟运行一次,无限循环
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("hello world ", "test")
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(1).repeatForever())
                    .build();
            scheduler.scheduleJob(job, trigger);
            // and start it off
            scheduler.start();
            Thread.sleep(2000);
            scheduler.shutdown();
        } catch (SchedulerException se) {
            se.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

}

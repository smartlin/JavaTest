package quartz.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by starlin
 * on 2017/01/10 16:13.
 */
public class HelloQuartz implements Job{

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello quartz!!");
    }
    public static void main(String[] args) throws InterruptedException  {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try{
            // 通过schedulerFactory获取一个调度器
            scheduler = schedulerFactory.getScheduler();
            // 创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类
            JobDetail jobDetail = JobBuilder.newJob(HelloQuartz.class).withIdentity("JobName","JobGroupName").build();

            //定义触发规则
             Trigger trigger=TriggerBuilder.newTrigger().withIdentity("SimpleTrigger", "SimpleTriggerGroup")
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(3).withRepeatCount(6))
                    .startNow().build();
            //  corn表达式  每五秒执行一次
            //Trigger trigger = TriggerBuilder.newTrigger().withIdentity("CronTrigger", "CronTriggerGroup")
            //        .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
            //        .startNow().build();

            //把作业和触发器注册到任务调度中
            scheduler.scheduleJob(jobDetail,trigger);
            // 启动调度
            scheduler.start();
            Thread.sleep(10000);
            // 停止调度
            scheduler.shutdown();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

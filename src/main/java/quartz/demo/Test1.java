package quartz.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;


/**
 * Created by starlin
 * on 2018/8/12 18:44.
 */
public class Test1 {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        try{

            // 创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类
            JobDetail job = JobBuilder.newJob(HelloTask.class).withIdentity("JobName1","JobGroupName1").build();

            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(40)
                            .repeatForever())
                    .build();

            scheduler.scheduleJob(job, trigger);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

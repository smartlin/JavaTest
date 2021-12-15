package cn.lxh.java.ManyThread.ScheduledExecutorService;

import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by starlin
 * on 2021/11/8 13:21.
 */
public class CancelScheduledTaskTest {

    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello");
        }
    };

    @Scheduled(cron = "${sue.spring.task.cron}")
    public void test12() throws InterruptedException {
        LocalDateTime localDateTime = LocalDateTime.now();
        if (localDateTime.getHour() > 12 ) {
            ScheduledFuture<?> scheduledFuture =
                    scheduledExecutorService.scheduleAtFixedRate(r, 1L, 1L, TimeUnit.SECONDS);
            Thread.sleep(5000L);
            // 取消任务
            boolean status = scheduledFuture.cancel(false);
            System.out.println("任务取消成功12：" + status);
        }
    }

    @Scheduled(cron = "${sue.spring.task.cron}")
    public void test11() throws InterruptedException {
        LocalDateTime localDateTime = LocalDateTime.now();
        if (localDateTime.getHour() < 11) {
            // 每秒执行一次
            ScheduledFuture<?> scheduledFuture1 =
                    scheduledExecutorService.scheduleAtFixedRate(r, 1L, 1L, TimeUnit.SECONDS);
            Thread.sleep(5000L);
            // 取消任务
            boolean status = scheduledFuture1.cancel(false);
            System.out.println("任务取消成功11：" + status);
        }
    }

    public void main(String[] args) throws InterruptedException {
        test12();
        test11();
    }

}

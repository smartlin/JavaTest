package cn.lxh.java.ManyThread.Callable;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.TimeUnit;

/**
 * Created by starlin
 * on 2021/4/19 23:10.
 * ListenableFuture 相比 Future 是不需要知道 执行结果的情况下就可以将 成功或者失败的业务代码 通过回调的方式 预埋，带来的好处就是异步，不需要阻塞当前线程，从而可以提高系统的吞吐量
 * Future 需要通过 get() 方法阻塞当前线程，在获取线程的执行结果后再根据执行结果编写相关的业务代码
 */
@Slf4j
public class SubmitListenableTest {
    public static void main(String[] args) {
        ThreadPoolTaskExecutor executorService = new ThreadPoolTaskExecutor();
        executorService.setCorePoolSize(1);
        executorService.setMaxPoolSize(1);
        executorService.initialize();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            ListenableFuture<Boolean> asyncResult = executorService.submitListenable(() -> {

                // 休息5毫秒，模拟执行
                TimeUnit.MILLISECONDS.sleep(5);
                //throw new RuntimeException("出现异常");
                return true;

            });
            asyncResult.addCallback(data -> {
                try {
                    // 休息3毫秒模拟获取到执行结果后的操作
                    TimeUnit.MILLISECONDS.sleep(3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, ex -> log.info("**异常信息**：{}", ExceptionUtils.getThrowableList(ex)));
        }
        System.out.println(String.format("总结耗时：%s", System.currentTimeMillis() - start));
    }
}

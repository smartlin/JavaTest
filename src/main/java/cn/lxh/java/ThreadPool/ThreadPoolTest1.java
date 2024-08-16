package cn.lxh.java.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by starlin
 * on 2024/1/29 10:28.
 */
public class ThreadPoolTest1 {
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(2, 2,
            60, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1));

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread.sleep(100);
            for (int j = 0; j < 2; j++) {
                THREAD_POOL_EXECUTOR.execute(() -> {
                    int a = 0;
                });
            }
            System.out.println("========详情任务，处理完成");
        }
        System.out.println("所有任务执行完成");
    }
}

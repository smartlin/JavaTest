package cn.lxh.java.ManyThread.ThreadLocal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by starlin
 * on 2020/8/13 19:11.
 */
public class AbortPolicyTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 3, 10,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(2),
                // Ìí¼Ó AbortPolicy ¾Ü¾ø²ßÂÔ
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 6; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}

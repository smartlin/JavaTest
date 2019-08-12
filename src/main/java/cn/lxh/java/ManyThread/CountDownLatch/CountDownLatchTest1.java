package cn.lxh.java.ManyThread.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by starlin
 * on 2019/8/12 15:56.
 */
public class CountDownLatchTest1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 3个主线程
        final CountDownLatch main = new CountDownLatch(3);
        // 1个子线程
        final CountDownLatch sub = new CountDownLatch(1);

        for (int i = 0; i < 3; i++) {
            final int c = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("线程：" + Thread.currentThread().getName() + "已到达起跑线");
                        // 每次主线程减1，当主线程减到0时，主线程就被唤醒
                        main.countDown();
                        // 所有子线程到达之后必须等待
                        sub.await();
                        System.out.println("线程"+Thread.currentThread().getName()+"开始跑步---》到达终点！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();

        // 所有子线程到达后，主线程发起跑令
        try {
            main.await();
            Thread.sleep(1000);
            System.out.println("线程" + Thread.currentThread().getName() + "准备就绪");
            System.out.println("线程" + Thread.currentThread().getName() + "发起跑令");
            // 子线程减到1，被唤醒继续执行
            sub.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

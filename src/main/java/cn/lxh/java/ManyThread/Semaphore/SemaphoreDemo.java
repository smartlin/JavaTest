package cn.lxh.java.ManyThread.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by starlin
 * on 2018/6/4 15:51.
 */
public class SemaphoreDemo {
    public static void main(String[] args) throws Exception{
        ExecutorService service = Executors.newCachedThreadPool();
        //5个坑位
        final Semaphore semaphore = new Semaphore(5);
        //10个人排队
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("线程" + Thread.currentThread().getName() + "进入，当前已有" + (5 - semaphore.availablePermits()) + "个并发");
                        Thread.sleep((long) (Math.random()*10000));
                        System.out.println("线程" + Thread.currentThread().getName() + "即将离开");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }
    }
}

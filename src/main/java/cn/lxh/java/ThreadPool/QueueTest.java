package cn.lxh.java.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * WhyLinkedBlockingQueue中的setCapacity不修改，则程序运行至main主线程会停止
 * 修改了setCapatcity后后面的子线程能够继续运行
 */
public class QueueTest {
    public static void main(String[] args) throws InterruptedException {
        WhyLinkedBlockingQueue<Object> blockingQueue = new WhyLinkedBlockingQueue<>(5);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ":开始执行put(" + i + "）;");
                    blockingQueue.put(i);
                    System.out.println(Thread.currentThread().getName() + ":put(" + i + ")成功," + "刺余容里：" + blockingQueue.remainingCapacity());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        blockingQueue.setCapacity(100);
        System.out.println(Thread.currentThread().getName() + ":队列容量修改完成 ," + "剩余容量：" + blockingQueue.remainingCapacity());

        //这里调用put方法，在不修改setCapacity方法，子线程依然能够运行，效果和修改setCapacity方法一样
        //blockingQueue.put(100);
        //System.out.println(Thread.currentThread().getName() + ":put(100) 成功，" + "剩余容量：" + blockingQueue.remainingCapacity());
    }
}
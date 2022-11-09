package cn.lxh.java.ManyThread.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore(信号量)是用来控制同时访问特定资源的线程数量，它协调各个线程，以保证合理的使用公共资源。
 * Semaphore有两个构造函数：Semaphore(int permits)默认是非公平的，
 * Semaphore(int permits, boolean fair)可以设置为公平的
 * Created by starlin
 * on 2017/02/27 22:05.
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService executorService = Executors.newFixedThreadPool(30);
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for(int i=0;i<THREAD_COUNT;i++){
            final int a= i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        //使用Semaphore的acquire()方法获取一个许可证
                        semaphore.acquire();
                        System.out.println("do something......" + a);
                        //使用完之后调用release()方法归还许可证
                        semaphore.release();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }
}

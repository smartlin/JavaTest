package cn.lxh.java.ManyThread.Semaphore;

import java.time.LocalTime;
import java.util.concurrent.Semaphore;

/**
 * Created by starlin
 * on 2017/09/25 13:25.
 */
public class HelloSemaphore {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
          private Semaphore semaphore = new Semaphore(2);

            @Override
            public void run() {
                try {
                    System.out.println(String.format("����ִ������:%s,��ǰʱ��:%s",Thread.currentThread().getName(), LocalTime.now()));
                    semaphore.acquire();
                    System.out.println(String.format("����ʼ:%s,��ǰʱ��:%s",Thread.currentThread().getName(), LocalTime.now()));
                    Thread.sleep(5000);
                    System.out.println(String.format("�������:%s,��ǰʱ��:%s",Thread.currentThread().getName(), LocalTime.now()));
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread[] threads = new Thread[3];
        for(int i=0;i<threads.length;i++){
            threads[i] = new Thread(runnable);
            threads[i].start();
        }
    }
}

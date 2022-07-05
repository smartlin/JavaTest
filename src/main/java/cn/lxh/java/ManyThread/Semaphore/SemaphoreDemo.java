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
        //5����λ
        final Semaphore semaphore = new Semaphore(5);
        //10�����Ŷ�
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("�߳�" + Thread.currentThread().getName() + "���룬��ǰ����" + (5 - semaphore.availablePermits()) + "������");
                        Thread.sleep((long) (Math.random()*10000));
                        System.out.println("�߳�" + Thread.currentThread().getName() + "�����뿪");
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

package cn.lxh.java.ManyThread.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore(�ź���)����������ͬʱ�����ض���Դ���߳���������Э�������̣߳��Ա�֤�����ʹ�ù�����Դ��
 * Semaphore���������캯����Semaphore(int permits)Ĭ���Ƿǹ�ƽ�ģ�
 * Semaphore(int permits, boolean fair)��������Ϊ��ƽ��
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
                        //ʹ��Semaphore��acquire()������ȡһ�����֤
                        semaphore.acquire();
                        System.out.println("do something......" + a);
                        //ʹ����֮�����release()�����黹���֤
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

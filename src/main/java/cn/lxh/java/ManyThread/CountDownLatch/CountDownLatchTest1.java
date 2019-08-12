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
        // 3�����߳�
        final CountDownLatch main = new CountDownLatch(3);
        // 1�����߳�
        final CountDownLatch sub = new CountDownLatch(1);

        for (int i = 0; i < 3; i++) {
            final int c = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("�̣߳�" + Thread.currentThread().getName() + "�ѵ���������");
                        // ÿ�����̼߳�1�������̼߳���0ʱ�����߳̾ͱ�����
                        main.countDown();
                        // �������̵߳���֮�����ȴ�
                        sub.await();
                        System.out.println("�߳�"+Thread.currentThread().getName()+"��ʼ�ܲ�---�������յ㣡");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();

        // �������̵߳�������̷߳�������
        try {
            main.await();
            Thread.sleep(1000);
            System.out.println("�߳�" + Thread.currentThread().getName() + "׼������");
            System.out.println("�߳�" + Thread.currentThread().getName() + "��������");
            // ���̼߳���1�������Ѽ���ִ��
            sub.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

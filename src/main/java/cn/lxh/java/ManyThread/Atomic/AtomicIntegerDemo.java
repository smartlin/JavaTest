package cn.lxh.java.ManyThread.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by starlin
 * on 2018/3/27 23:03.
 * ʹ��ԭ������AtomicInteger�滻��ͨint����ִ��������ԭ�Ӳ�������֤���̰߳�ȫ
 */
public class AtomicIntegerDemo {

    static AtomicInteger atomicInteger = new AtomicInteger();

    public static class AddThread implements Runnable{

        @Override
        public void run() {
            for(int i=0 ;i < 10000;i++) {
                atomicInteger.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        //����10���߳�ͬʱִ����������
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new AddThread());
        }
        //�����߳�
        for (int i=0;i<10;i++) {
            threads[i].start();
        }
        for (int i=0;i<10;i++) {
            threads[i].join();
        }

        System.out.println(atomicInteger);
    }
}

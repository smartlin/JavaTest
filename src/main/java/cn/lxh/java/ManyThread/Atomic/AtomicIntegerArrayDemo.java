package cn.lxh.java.ManyThread.Atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by starlin
 * on 2018/4/15 15:46.
 * ԭ�Ӹ�������ָ����ͨ��ԭ�ӵķ�ʽ�����������ĳ��Ԫ��
 */
public class AtomicIntegerArrayDemo {
    public static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                //ִ��������Ԫ����������,����Ϊindex,�������±�
                atomicIntegerArray.getAndIncrement(i%atomicIntegerArray.length());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        //����10���߳�
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new AddThread());
        }
        //����10���߳�
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        System.out.println(atomicIntegerArray);
    }
}

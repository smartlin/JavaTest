package cn.lxh.java.ManyThread.Atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by starlin
 * on 2018/4/15 15:46.
 * 原子更新数组指的是通过原子的方式更新数组里的某个元素
 */
public class AtomicIntegerArrayDemo {
    public static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                //执行数组中元素自增操作,参数为index,即数组下标
                atomicIntegerArray.getAndIncrement(i%atomicIntegerArray.length());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        //创建10条线程
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new AddThread());
        }
        //启动10条线程
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        System.out.println(atomicIntegerArray);
    }
}

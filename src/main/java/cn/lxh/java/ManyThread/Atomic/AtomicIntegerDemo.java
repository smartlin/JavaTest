package cn.lxh.java.ManyThread.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by starlin
 * on 2018/3/27 23:03.
 * 使用原子类型AtomicInteger替换普通int类型执行自增的原子操作，保证了线程安全
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
        //开启10条线程同时执行自增操作
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new AddThread());
        }
        //启动线程
        for (int i=0;i<10;i++) {
            threads[i].start();
        }
        for (int i=0;i<10;i++) {
            threads[i].join();
        }

        System.out.println(atomicInteger);
    }
}

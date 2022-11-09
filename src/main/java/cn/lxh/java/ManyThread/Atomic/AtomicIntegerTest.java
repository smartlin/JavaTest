package cn.lxh.java.ManyThread.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by starlin
 * on 2019/10/16 10:01.
 */
public class AtomicIntegerTest {
    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void increase() {
        atomicInteger.incrementAndGet();
    }

    private static final int THREAD_COUNTS = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNTS];
        for (int i = 0; i < THREAD_COUNTS; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(atomicInteger);
    }

}

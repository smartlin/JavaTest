package cn.lxh.java.ManyThread.CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by starlin
 * on 2018/7/6 11:12.
 */
public class ABATest {
    private static AtomicInteger atomicInteger = new AtomicInteger(100);
    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(100,0);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInteger.compareAndSet(100, 110);
                atomicInteger.compareAndSet(110, 100);
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("AtomicInteger----->" + atomicInteger.compareAndSet(100,110));
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                atomicStampedReference.compareAndSet(100, 110, atomicStampedReference.getStamp(),
                        atomicStampedReference.getStamp() + 1);
                atomicStampedReference.compareAndSet(110, 100, atomicStampedReference.getStamp(),
                        atomicStampedReference.getStamp() + 1);
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = atomicStampedReference.getStamp();
                System.out.println("before stamp---->" + stamp);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("after stamp----->" + atomicStampedReference.getStamp());
                System.out.println("AtomicStampedReference----->" + atomicStampedReference.compareAndSet(100,110,stamp,stamp+1));
            }
        });

        thread3.start();
        thread4.start();
    }
}

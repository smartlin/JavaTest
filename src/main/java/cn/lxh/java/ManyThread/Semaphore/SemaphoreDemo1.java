package cn.lxh.java.ManyThread.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 当Semaphore遇到finally的坑
 */
public class SemaphoreDemo1 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3, true);
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread threadA = new Thread(new MyRunnable(1, semaphore, reentrantLock), "thread-A");
        Thread threadB = new Thread(new MyRunnable(2, semaphore, reentrantLock), "thread-B");
        Thread threadC = new Thread(new MyRunnable(1, semaphore, reentrantLock), "thread-C");
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

class MyRunnable implements Runnable {
    private int n;
    private Semaphore semaphore;
    private ReentrantLock lock;

    public MyRunnable(int n, Semaphore semaphore, ReentrantLock lock) {
        this.n = n;
        this.semaphore = semaphore;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(n);
            // semaphore.drainPermits()会导致线程死锁
//            System.out.println("剩余可用许可证: " + semaphore.drainPermits());
            // semaphore.availablePermits()不会导致线程死锁
            System.out.println("剩余可用许可证: " + semaphore.availablePermits());
            System.out.println(Thread.currentThread().getName() + "执行完成。。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(n);
        }
    }
}

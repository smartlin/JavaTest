package cn.lxh.java.ManyThread.ReentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by starlin
 * on 2017/09/24 22:16.
 * 写锁互斥
 */
public class WriteLockTest implements Runnable{
    ReentrantReadWriteLock writeLock = new ReentrantReadWriteLock();

    @Override
    public void run() {
        try {
            writeLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+"获得了写锁，时间为：" + System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            writeLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        WriteLockTest writeLockTest = new WriteLockTest();
        Thread thread1 = new Thread(writeLockTest);
        Thread thread2 = new Thread(writeLockTest);
        thread1.start();
        thread2.start();
    }
}

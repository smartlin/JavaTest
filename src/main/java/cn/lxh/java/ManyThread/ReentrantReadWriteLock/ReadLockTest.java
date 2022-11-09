package cn.lxh.java.ManyThread.ReentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by starlin
 * on 2017/09/24 22:04.
 * 读锁共享
 */
public class ReadLockTest implements Runnable{
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        try {
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+"获得了读锁, 时间为:" + System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }

    }

    public static void main(String[] args) {
        ReadLockTest readLockTest = new ReadLockTest();
        Thread thread1 = new Thread(readLockTest);
        Thread thread2 = new Thread(readLockTest);
        thread1.start();
        thread2.start();
    }
}

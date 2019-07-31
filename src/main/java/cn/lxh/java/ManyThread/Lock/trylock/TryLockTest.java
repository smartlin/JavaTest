package cn.lxh.java.ManyThread.Lock.trylock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by starlin
 * on 2018/7/9 16:38.
 */
public class TryLockTest extends Thread{
    public static ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if (reentrantLock.tryLock(5, TimeUnit.SECONDS)) {
                Thread.sleep(6000);
            } else {
                System.out.println("get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        TryLockTest tryLockTest1 = new TryLockTest();
        TryLockTest tryLockTest2 = new TryLockTest();
        tryLockTest1.start();
        tryLockTest2.start();
    }
}

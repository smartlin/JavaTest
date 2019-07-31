package cn.lxh.java.ManyThread.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by starlin
 * on 2018/7/9 16:15.
 */
public class ReentrantLockTest extends Thread{
    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            reentrantLock.lock();
            try {
                i++;
            } catch (Exception e) {

            }finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest reentrantLock1 = new ReentrantLockTest();
        ReentrantLockTest reentrantLock2 = new ReentrantLockTest();
        ReentrantLockTest reentrantLock3 = new ReentrantLockTest();

        reentrantLock1.start();
        reentrantLock2.start();
        reentrantLock3.start();
        reentrantLock1.join();
        reentrantLock2.join();
        reentrantLock3.join();
        System.out.println(i);
    }
}

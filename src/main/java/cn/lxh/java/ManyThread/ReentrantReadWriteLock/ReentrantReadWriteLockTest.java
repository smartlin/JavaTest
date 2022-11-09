package cn.lxh.java.ManyThread.ReentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by starlin
 * on 2017/09/24 20:53.
 */
public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        final ReentrantReadWriteLock.ReadLock readLock;
        final ReentrantReadWriteLock.WriteLock writeLock;
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(false);
        readLock = readWriteLock.readLock();
        writeLock = readWriteLock.writeLock();

        System.out.println("main:before readLock.lock()");
        readLock.lock();
        System.out.println("main:after writeLock.lock()");

        Thread threadW = new Thread(){
            @Override
            public void run(){
                System.out.println("threadW: before writeLock.lock()");
                writeLock.lock();
                System.out.println("threadW: after writeLock.lock()");
            }
        };

        Thread threadR = new Thread(){
            @Override
            public void run(){
                System.out.println("threadR: before readLock.lock()");
                readLock.lock();
                System.out.println("threadR: after readLock.lock()");
            }
        };

        try{
            threadW.start();
            Thread.sleep(1000);
            threadR.start();
            threadW.join();
            threadR.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

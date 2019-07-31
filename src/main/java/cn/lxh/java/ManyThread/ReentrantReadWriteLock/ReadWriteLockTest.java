package cn.lxh.java.ManyThread.ReentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by starlin
 * on 2017/09/24 22:27.
 * ��д����
 */


public class ReadWriteLockTest extends ReentrantReadWriteLock{
    public void read() {
        try {
            readLock().lock();
            System.out.println(Thread.currentThread().getName()+"����˶�����ʱ��Ϊ��"+System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readLock().unlock();
        }

    }

    public void write() {
        try {
            writeLock().lock();
            System.out.println(Thread.currentThread().getName()+"�����д����ʱ��Ϊ��"+System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            writeLock().unlock();
        }
    }


    public static void main(String[] args) {
        final ReadWriteLockTest readLockTest = new ReadWriteLockTest();
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                readLockTest.read();
            }
        };
        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                readLockTest.write();
            }
        };
        Thread tRead = new Thread(readRunnable);
        Thread tWrite = new Thread(writeRunnable);
        tRead.start();
        tWrite.start();
    }
}



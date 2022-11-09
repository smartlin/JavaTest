package cn.lxh.java.ManyThread.notify;

import java.util.concurrent.TimeUnit;

/**
 * 唤醒并不代表立刻获得对象的锁，要等待执行notify()方法的线程执行完，
 * 即退出synchronized代码块后，当前线程才会释放锁，而呈wait状态的线程才可以获取该对象锁。
 * Created by starlin
 * on 2017/02/25 22:21.
 */
public class WaitNotifyTest {
    public static Object object = new Object();
    static class Thread1 implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
            synchronized (object){
                try {
                    object.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " get the lock");
        }

    }

    static class Thread2 implements Runnable{

        @Override
        public void run() {
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+ " is running");
                object.notify();
                System.out.println(Thread.currentThread().getName() + " invoke notify()");
                System.out.println(Thread.currentThread().getName()+ " release the lock.");
            }
        }
    }
    //当Thread-0调用了wait方法后就释放了object锁，Thread-1获取锁之后调用notify的释放锁，
    // 但是这个时候Thread0没有立刻获取object锁，而是等到了Thread-1的同步块退出之后才获取了object的锁
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        thread1.start();
        TimeUnit.SECONDS.sleep(1);
        thread2.start();
    }
}


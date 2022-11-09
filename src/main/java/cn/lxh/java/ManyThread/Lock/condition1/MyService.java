package cn.lxh.java.ManyThread.Lock.condition1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by starlin
 * on 2016/08/21 16:14.
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();
    public void awaitA(){
        try{
            lock.lock();
            System.out.println("begin awaitA时间为=" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end awaitA时间为=" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void awaitB(){
        try{
            lock.lock();
            System.out.println("begin awaitB时间为=" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end awaitB时间为=" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void singalAll_A(){
        try{
            lock.lock();
            System.out.println(" singalAll_A时间为=" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            conditionA.signal();

        }finally {
            lock.unlock();
        }
    }
    public void singalAll_B(){
        try{
            lock.lock();
            System.out.println(" singalAll_B时间为=" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            conditionA.signal();

        }finally {
            lock.unlock();
        }
    }
}

package cn.lxh.java.ManyThread.Lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by starlin
 * on 2016/08/21 16:05.
 */
public class UserConditionWaitNotify {
    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    public void await(){
        try{
            lock.lock();
            System.out.println(" await的时间为=" + System.currentTimeMillis());
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void singal(){
        try{
            lock.lock();
            System.out.println("singal的时间为=" + System.currentTimeMillis());
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
}

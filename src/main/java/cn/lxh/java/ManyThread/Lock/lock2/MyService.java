package cn.lxh.java.ManyThread.Lock.lock2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by starlin
 * on 2016/08/21 15:44.
 */
public class MyService {
    private Lock lock = new ReentrantLock();
   public void testMethodA(){
        try{
            lock.lock();
            System.out.println("methodA begin ThreadName="+Thread.currentThread().getName() + "time="+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodA end ThreadName="+Thread.currentThread().getName() + "time="+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
   }
    public void testMethodB(){
        try{
            lock.lock();
            System.out.println("methodB begin ThreadName="+Thread.currentThread().getName() + "time="+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodB end ThreadName="+Thread.currentThread().getName() + "time="+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

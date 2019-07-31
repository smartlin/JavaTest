package cn.lxh.java.ManyThread.Lock.lock1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by starlin
 * on 2016/08/21 15:36.
 */
public class Service {
    private Lock lock = new ReentrantLock();
    public void testMethod(){
        lock.lock();//获得锁
        for(int i=0;i<5;i++){
            System.out.println("ThreadName=" + Thread.currentThread().getName()+(" " + (i+1)));
        }
        lock.unlock();//释放锁
    }
}

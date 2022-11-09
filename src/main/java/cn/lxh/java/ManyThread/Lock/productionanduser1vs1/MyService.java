package cn.lxh.java.ManyThread.Lock.productionanduser1vs1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by starlin
 * on 2016/08/21 16:44.
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    private boolean hasValue = false;
    public void set(){
        try{
            lock.lock();
            while(hasValue==true){
                condition.await();
            }
            System.out.println("boy");
            hasValue = true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void get(){
        try{
            lock.lock();
            while (hasValue ==false){
                condition.await();
            }
            System.out.println("---girl");
            hasValue = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

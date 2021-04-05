package cn.lxh.java.ManyThread.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;



/**
 * Created by starlin
 * on 2021/3/29 23:18.
 */
//不可重入锁
public class MyLock implements Lock {
    public static void main(String[] args) throws Exception{
        MyLock myLock = new MyLock();
        new Thread(()->{
            myLock.lock();
            try {
                Thread.sleep(1);
                System.out.println("lock t1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                myLock.unlock();
                System.out.println("unlock t1");
            }
        },"t1").start();

        new Thread(()->{
            myLock.lock();
            try {
                System.out.println("lock t2");
            }finally {
                myLock.unlock();
                System.out.println("unlock t2");
            }
        },"t2").start();
    }

    class MySync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override //是否是独占锁
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        public Condition newCondition() {
            return new ConditionObject();
        }
    }

    private MySync mySync = new MySync();

    @Override
    public void lock() {
        mySync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        mySync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return mySync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return mySync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        mySync.release(1);
    }

    @Override
    public Condition newCondition() {
        return mySync.newCondition();
    }
}

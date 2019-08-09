package cn.lxh.java.ManyThread.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by starlin
 * on 2017/02/26 20:29.
 */
public class ConditionTest {
    private static int value = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition456 = lock.newCondition();
    private Condition condition789 = lock.newCondition();
    private Condition condition101112 = lock.newCondition();

    class ThreadA implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("首先输出1-3");
                while (value <= 3) {
                    System.out.println(value++);
                }
                condition456.signal();
            } finally {
                lock.unlock();
            }

            try {
                lock.lock();
                while (value <= 6) {
                    condition789.await();
                }
                System.out.println("输出7-9");
                while (value <= 9) {
                    System.out.println(value++);
                }
                condition101112.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class ThreadB implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                while (value <= 3) {
                    condition456.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

            try {
                lock.lock();
                System.out.println("输出4-6");
                while (value <= 6) {
                    System.out.println(value++);
                }
                condition789.signal();
            } finally {
                lock.unlock();
            }

            try {
                lock.lock();
                while (value <= 9){
                    condition101112.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

            try {
                lock.lock();
                System.out.println("输出11-12");
                while (value<=12){
                    System.out.println(value++);
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();
        Thread threadA = new Thread(conditionTest.new ThreadA());
        Thread threadB = new Thread(conditionTest.new ThreadB());
        threadA.start();
        threadB.start();
    }
}

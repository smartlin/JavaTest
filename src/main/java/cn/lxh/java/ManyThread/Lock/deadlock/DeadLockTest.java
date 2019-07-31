package cn.lxh.java.ManyThread.Lock.deadlock;

/**
 * Created by starlin
 * on 2018/4/17 11:06.
 * 死锁测试
 */
public class DeadLockTest {
    private final Object object1 = new Object();
    private final Object object2 = new Object();

    public static void main(String[] args) {
        DeadLockTest deadLockTest = new DeadLockTest();
        deadLockTest.testDeadLock();
    }

    private void testDeadLock() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                calLock12();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                calLock21();
            }
        });

        thread1.start();
        thread2.start();
    }

    private void calLock12() {
        synchronized (object1) {
            sleep();
            synchronized (object2) {
                sleep();
            }
        }
    }

    private void calLock21() {
        synchronized (object2) {
            sleep();
            synchronized (object1) {
                sleep();
            }
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

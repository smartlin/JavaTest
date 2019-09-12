package cn.lxh.java.ManyThread.DeadLockTest;

/**
 * Created by starlin
 * on 2019/9/11 16:29.
 * ËÀËø´úÂë
 */
public class DeadLockTest {
    private Object object1 = new Object();
    private Object object2 = new Object();

    public static void main(String[] args) {
        DeadLockTest deadLockTest = new DeadLockTest();
        deadLockTest.deadLock();
    }

    private void deadLock() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object1) {
                    try {
                        System.out.println("in lock name object1");
                        Thread.sleep(500);
                        synchronized (object2) {
                            System.out.println("in lock object2");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object2) {
                    try {
                        System.out.println("in lock name object2");
                        Thread.sleep(500);
                        synchronized (object1) {
                            System.out.println("in lock object1");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

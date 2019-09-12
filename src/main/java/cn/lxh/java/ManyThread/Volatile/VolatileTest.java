package cn.lxh.java.ManyThread.Volatile;

/**
 * Created by starlin
 * on 2019/9/9 15:49.
 * ��֤volatile���εı������߱�ԭ����
 */
public class VolatileTest implements Runnable {

    private volatile int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        Thread thread1 = new Thread(volatileTest);
        Thread thread2 = new Thread(volatileTest);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(volatileTest.i);
    }
}

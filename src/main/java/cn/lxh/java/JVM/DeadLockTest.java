package cn.lxh.java.JVM;

import java.io.Serializable;

/**
 * Created by starlin
 * on 2018/8/25 17:47.
 * ����JConsole�۲�����
 */
public class DeadLockTest implements Serializable {

    static class SynAddRunnable implements Runnable {
        int a, b;

        public SynAddRunnable(int a,int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunnable(1,2)).start();
            new Thread(new SynAddRunnable(2, 1)).start();
        }
    }
}

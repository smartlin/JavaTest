package cn.lxh.java.ManyThread.Interrupted;

import java.util.concurrent.TimeUnit;

/**
 * Created by starlin
 * on 2019/10/16 15:12.
 * �ӽ�����Կ������׳�InterruptedException���߳�SleepThread�����жϱ�ʶλ������ˣ���һֱæµ�������߳�BusyThread���жϱ�ʶλû�б����
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleeperRunner(), "SleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interruptdd is  " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
    }

    static class SleeperRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

}

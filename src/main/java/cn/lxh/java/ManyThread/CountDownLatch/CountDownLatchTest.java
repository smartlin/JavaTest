package cn.lxh.java.ManyThread.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁：CountDownLatch
 * Created by starlin
 * on 2016/06/15 19:28.
 */
public class CountDownLatchTest {
    public long timeTasks(int nThreads,final Runnable task) throws InterruptedException {
         final CountDownLatch startGate = new CountDownLatch(1);
         final CountDownLatch endGate = new CountDownLatch(nThreads);
        for(int i=0;i<nThreads;i++){
            Thread t = new Thread(){
                public void run(){
                    try {
                        startGate.await();
                        try{
                            task.run();
                        }finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end-start;
    }

    public static void main(String[] args) {
        System.out.println(System.nanoTime());
        System.out.println(System.currentTimeMillis());
    }

}

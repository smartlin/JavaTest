package cn.lxh.java.ManyThread.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest_2 {

    private static CyclicBarrier barrier;
    
    static class ThreadTest1 implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "达到...");
            try {
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完成...");
        }
    }
    
    public static void main(String[] args) {
        barrier = new CyclicBarrier(5,new Runnable() {
            @Override
            public void run() {
                System.out.println("执行CyclicBarrier中的任务.....");
            }
        });
        for(int i = 1 ; i <= 5 ; i++){
            ThreadTest1 threadTest1 = new ThreadTest1();
            new Thread(threadTest1).start();
        }
    }
}
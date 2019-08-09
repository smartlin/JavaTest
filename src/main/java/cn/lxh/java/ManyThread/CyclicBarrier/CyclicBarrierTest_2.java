package cn.lxh.java.ManyThread.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest_2 {

    private static CyclicBarrier barrier;
    
    static class ThreadTest1 implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "�ﵽ...");
            try {
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "ִ�����...");
        }
    }
    
    public static void main(String[] args) {
        barrier = new CyclicBarrier(5,new Runnable() {
            @Override
            public void run() {
                System.out.println("ִ��CyclicBarrier�е�����.....");
            }
        });
        for(int i = 1 ; i <= 5 ; i++){
            ThreadTest1 threadTest1 = new ThreadTest1();
            new Thread(threadTest1).start();
        }
    }
}
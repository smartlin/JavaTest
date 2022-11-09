package com.starlin.multithreaded.design.pattern.Chapter4;

/**
 * Created by starlin
 * on 2022/10/16 23:17.
 * Part4
 */
public class TestThread extends Thread{
    @Override
    public void run() {
        System.out.println("begin");
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        Thread thread = new TestThread();
        while (true) {
            thread.start();
        }
    }
}

package com.starlin.src.Balking.Q4

public class TestThread extends Thread {
    public void run() {
        System.out.print("BEGIN");
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("END");
    }
}

package com.starlin.src.ThreadSpecificStorage.Q11

public class ClientThread extends Thread {
    public ClientThread(String name) {
        super(name);
        Log.println("constructor is called.");
    }
    public void run() {
        System.out.println(getName() + " BEGIN");
        for (int i = 0; i < 10; i++) {
            Log.println("i = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        Log.close();
        System.out.println(getName() + " END");
    }
}

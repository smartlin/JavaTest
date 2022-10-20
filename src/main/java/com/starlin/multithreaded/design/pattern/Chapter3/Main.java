package com.starlin.multithreaded.design.pattern.Chapter3;

/**
 * Created by starlin
 * on 2022/9/25 23:33.
 */
public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "Alice", 314445655L).start();
        new ServerThread(requestQueue,"Bobby",455676868L).start();
    }
}

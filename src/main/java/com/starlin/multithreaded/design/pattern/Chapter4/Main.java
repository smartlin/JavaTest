package com.starlin.multithreaded.design.pattern.Chapter4;

import com.starlin.multithreaded.design.pattern.Chapter3.ClientThread;
import com.starlin.multithreaded.design.pattern.Chapter3.RequestQueue;
import com.starlin.multithreaded.design.pattern.Chapter3.ServerThread;
import com.starlin.multithreaded.design.pattern.Chapter3.TalkThread;

/**
 * Created by starlin
 * on 2022/9/25 23:33.
 */
public class Main {
    public static void main(String[] args) {
        com.starlin.multithreaded.design.pattern.Chapter3.RequestQueue requestQueue = new RequestQueue();
        new TalkThread(requestQueue, "Alice", 314445655L).start();
        new TalkThread(requestQueue,"Bobby",455676868L).start();
    }
}

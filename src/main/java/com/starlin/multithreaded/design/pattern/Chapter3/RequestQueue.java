package com.starlin.multithreaded.design.pattern.Chapter3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by starlin
 * on 2022/9/25 23:23.
 */
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<>();
    public synchronized Request getRequest() {
        while (queue.peek() == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }
}

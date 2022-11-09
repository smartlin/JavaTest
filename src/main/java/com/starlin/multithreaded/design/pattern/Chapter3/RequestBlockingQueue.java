package com.starlin.multithreaded.design.pattern.Chapter3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by starlin
 * on 2022/9/25 22:58.
 */
public class RequestBlockingQueue {
    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<Request>();

    public Request getRequest() {
        Request request = null;
        try {
            request = queue.take();
        } catch (Exception e) {
        }
        return request;
    }

    public void putRequest(Request request) throws InterruptedException {
        queue.put(request);
    }
}

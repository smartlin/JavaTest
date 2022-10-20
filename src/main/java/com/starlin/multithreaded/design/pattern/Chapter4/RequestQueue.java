package com.starlin.multithreaded.design.pattern.Chapter4;

import com.starlin.multithreaded.design.pattern.Chapter3.Request;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by starlin
 * on 2022/10/16 23:30.
 */
public class RequestQueue {
    private static final long TIMEOUT = 30000L;
    private final Queue<Request> queue = new LinkedList<>();

    public synchronized Request getRequest() {
        //��ʼʱ��
        long start = System.currentTimeMillis();
        while (queue.peek() == null) {
            //��ǰʱ��
            long now = System.currentTimeMillis();
            //ʣ��ĵȴ�ʱ��
            long rest = TIMEOUT - (now-start);
            if (rest <= 0) {
                throw new LivenessException("throw by " + Thread.currentThread().getName());
            }
            try {
                wait(rest);
            } catch (InterruptedException e) {

            }
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }
}

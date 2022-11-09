package com.starlin.multithreaded.design.pattern.Chapter3;

/**
 * Created by starlin
 * on 2022/9/25 23:03.
 */
public class TalkThread extends Thread {
    private final RequestBlockingQueue input;
    private final RequestBlockingQueue output;

    public TalkThread(RequestBlockingQueue input, RequestBlockingQueue output, String name) {
        super(name);
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":BEGIN");
        for (int i = 0; i < 20; i++) {
            Request request1 = input.getRequest();
            System.out.println(Thread.currentThread().getName() + " gets " + request1);

            Request request2 = new Request(request1.getName() + "!");
            System.out.println(Thread.currentThread().getName() + " puts " + request2);
            try {
                output.putRequest(request2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + ":END");
    }

    public static void main(String[] args) throws InterruptedException {
        RequestBlockingQueue requestQueue1 = new RequestBlockingQueue();
        RequestBlockingQueue requestQueue2 = new RequestBlockingQueue();
        //未加改行，程序运行的结果会产生死锁（该行相当于一个seed）
        requestQueue1.putRequest(new Request("Hello"));
        new TalkThread(requestQueue1, requestQueue2, "Alice").start();
        new TalkThread(requestQueue2, requestQueue1, "Bobby").start();
    }
}

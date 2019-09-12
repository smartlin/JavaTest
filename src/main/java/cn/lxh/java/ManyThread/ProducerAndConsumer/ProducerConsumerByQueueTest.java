package cn.lxh.java.ManyThread.ProducerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by starlin
 * on 2019/9/12 10:53.
 * 用阻塞队列实现一个生产者和消费者模型
 */
public class ProducerConsumerByQueueTest {

    public static void main(String[] args) {
        BlockingQueue sharedQueue = new LinkedBlockingDeque();
        Thread threadP = new Thread(new Producer(sharedQueue));
        Thread threadC = new Thread(new Consumer(sharedQueue));
        threadP.start();
        threadC.start();
    }
}

class Producer implements Runnable {

    private final BlockingQueue sharedQueue;

    public Producer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("生产者：" + i);
                sharedQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    private final BlockingQueue sharedQueue;

    public Consumer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("消费者：" + sharedQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
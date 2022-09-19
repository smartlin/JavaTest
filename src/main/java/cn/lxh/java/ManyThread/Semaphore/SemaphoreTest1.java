package cn.lxh.java.ManyThread.Semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by starlin
 * on 2022/9/9 22:52.
 */
public class SemaphoreTest1 {
    public static void main(String[] args) {
        BoundedResource boundedResource = new BoundedResource(3);
        for (int i = 0; i < 10; i++) {
            new UserThread(boundedResource).start();
        }
    }
}

//资源个数有限
class BoundedResource {
    private final Semaphore semaphore;
    private final int permits;
    private final static Random RANDOM = new Random(314159);

    BoundedResource(int permits) {
        this.semaphore = new Semaphore(permits);
        this.permits = permits;
    }

    public void use() throws InterruptedException {
        semaphore.acquire();
        try {
            doUse();
        } finally {
            semaphore.release();
        }
    }

    protected void doUse() throws InterruptedException {
        System.out.println("Begin :used = " + (permits - semaphore.availablePermits()) + "线程名称：" + Thread.currentThread().getName());
        Thread.sleep(3000);
        System.out.println("End : used = " + (permits - semaphore.availablePermits()) + "线程名称：" + Thread.currentThread().getName());
    }
}

class UserThread extends Thread {
    private final static Random RANDOM = new Random(26535);
    private final BoundedResource boundedResource;

    UserThread(BoundedResource boundedResource) {
        this.boundedResource = boundedResource;
    }

    @Override
    public void run() {
        try {
            while (true) {
                boundedResource.use();
                Thread.sleep(RANDOM.nextInt(3000));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
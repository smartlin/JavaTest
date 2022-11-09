package cn.lxh.java.ManyThread.BlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by starlin
 * on 2017/09/25 16:00.
 * ��������
 */
public class BlockingQueueTest {
    //������
    public static class Producer implements Runnable{
        private final BlockingQueue<Integer> blockingQueue;
        private volatile boolean flag;
        private Random random;

        public Producer(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
            flag = false;
            random = new Random();
        }

        @Override
        public void run() {
            //while (!flag){
                for(int i=0;i<10;i++){
                    try{
                        System.out.println(Thread.currentThread().getName()+" ������ " + i);
                        blockingQueue.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //int info = random.nextInt(100);
                //try{
                //    blockingQueue.put(info);
                //    System.out.println(Thread.currentThread().getName()+" ������ " + info);
                //    Thread.sleep(50);
                //} catch (InterruptedException e) {
                //    e.printStackTrace();
                //}
            //}
        }

        public void shutdown(){
            flag = true;
        }
    }

    //������
    public static class Consumer implements Runnable{
        private final BlockingQueue<Integer> blockingQueue;
        private volatile boolean flag;

        public Consumer(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true){
                int info;
                try{
                    info = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName()+" ������ "+info);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void shutdown(){
            flag = true;
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(10);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        //for(int i=0;i<10;i++){
        //    if(i<5){
        //        new Thread(producer,"������"+i).start();
        //    }else{
        //        new Thread(consumer,"������"+(i-5)).start();
        //    }
        //}
        Thread pThread = new Thread(producer);
        Thread cThread = new Thread(consumer);
        pThread.start();
        cThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //producer.shutdown();
        //consumer.shutdown();
    }
}

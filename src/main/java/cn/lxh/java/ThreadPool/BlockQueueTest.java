package cn.lxh.java.ThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 申请一个长度为 5 的队列，然后在循环里面调用 put 方法，当队列满了之后，程序就阻塞住了。
 * 通过 dump 当前线程可以知道主线程确实是阻塞在了我们前面分析的地方：
 */
public class BlockQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Object> blockingQueue = new LinkedBlockingQueue<>(5);
        for(int i = 0;i< 10;i++){
            System.out.println("开始执行linkedBlockingQueue.put(" + i + ") ");
            blockingQueue.put(i);
            System.out.println("linkedBlockingQueue.put("+ i +") 成功," + "剩余容显："+blockingQueue.remainingCapacity());
        }
    }
}
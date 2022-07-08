package cn.lxh.java.ManyThread.BlockingQueue;


import cn.lxh.java.ManyThread.CompletableFuture.SmallTool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ArrayBlockingQueue 公平队列
 * 下面代码中的先来者张三永远都会比李四先买到烧饼
 * 这里的公平，不仅仅是消费者公平，生产者也是公平的
 * 创建一个公平队列，先来的消费者一定先取出，先来的生产者一定先放进去
 */
public class _02_ArrayBlockingQueue_fair {
    private static BlockingQueue<String> shaobingQueue = new ArrayBlockingQueue<>(3,true);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                SmallTool.printTimeAndThread("来买烧饼");
                String shaobing = shaobingQueue.poll(1, TimeUnit.SECONDS);
                String tag = shaobing == null ? "再见, 以后不来了" : "买到烧饼了";
                SmallTool.printTimeAndThread(tag);
            } catch (InterruptedException e) {
                SmallTool.printTimeAndThread("被中断" + e.getMessage());
            }
        }, "张三").start();

        SmallTool.sleepMillis(100);     // 模拟张三先到

        new Thread(() -> {
            try {
                SmallTool.printTimeAndThread("来买烧饼");
                String shaobing = shaobingQueue.poll(1, TimeUnit.SECONDS);
                String tag = shaobing == null ? "草, 不敢掀昊天宗的摊子! " : "买到烧饼了";
                SmallTool.printTimeAndThread(tag);
            } catch (InterruptedException e) {
                SmallTool.printTimeAndThread("被中断" + e.getMessage());
            }
        }, "李四").start();

        shaobingQueue.offer("芝麻烧饼");
    }
}

package cn.lxh.java.ManyThread.BlockingQueue;


import cn.lxh.java.ManyThread.CompletableFuture.SmallTool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * LinkedBlockingQueue 非公平的，支持同时存取（源码里面有2把锁takeLock，putLock）
 * 下面的代码运行的结果是不确定的
 * 有可能后来的李四比张三先买到烧饼
 */
public class _01_LinkedBlockingQueue_unfair {

    public static void main(String[] args) {
        BlockingQueue<String> shaobingQueue = new LinkedBlockingQueue<>(3);

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
                String tag = shaobing == null ? "草, 掀摊子! " : "买到烧饼了";
                SmallTool.printTimeAndThread(tag);
            } catch (InterruptedException e) {
                SmallTool.printTimeAndThread("被中断" + e.getMessage());
            }
        }, "李四").start();

        shaobingQueue.offer("芝麻烧饼");
    }
}

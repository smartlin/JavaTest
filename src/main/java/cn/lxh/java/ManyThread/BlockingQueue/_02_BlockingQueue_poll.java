package cn.lxh.java.ManyThread.BlockingQueue;


import cn.lxh.java.ManyThread.CompletableFuture.SmallTool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * LinkedBlockingQueue poll方法演示
 * 场景：小白正在做烧饼，路人正准备去买烧饼，可是小白突然有事不能继续做烧饼了，这个时候路人甲不可能一直等待
 * 这个时候调用poll方法，加上等待的时间
 * 超过等待拿到的值为null（例子中运行的结果为null）
 * LinkedBlockingQueue队列不得插入null值，会抛出NPE异常，源码中有介绍
 */
public class _02_BlockingQueue_poll {
    public static void main(String[] args) {
        BlockingQueue<String> shaobingQueue = new LinkedBlockingQueue<>(3);

        Thread xiaoBai = new Thread(() -> {
            SmallTool.printTimeAndThread("小白 收拾东西，准备开张");
            SmallTool.printTimeAndThread("小白 接到电话 往家里跑");

        });

        Thread roadPeopleA = new Thread(() -> {
            SmallTool.printTimeAndThread("路人甲 来买烧饼");
            try {
                String shaobing = shaobingQueue.poll(2, TimeUnit.SECONDS);
                SmallTool.printTimeAndThread("路人甲 买到了烧饼: " + shaobing);
            } catch (InterruptedException e) {
                SmallTool.printTimeAndThread("路人甲 被中断" + e.getMessage());
            }
        });

        xiaoBai.start();
        try {
            Thread.sleep(10);   // 先等小白收拾一下，再让路人甲出场
        } catch (InterruptedException e) {
            SmallTool.printTimeAndThread("主线程 被中断" + e.getMessage());
        }
        roadPeopleA.start();
    }
}

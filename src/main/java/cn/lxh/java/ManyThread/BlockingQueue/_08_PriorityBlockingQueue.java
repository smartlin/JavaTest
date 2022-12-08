package cn.lxh.java.ManyThread.BlockingQueue;

import cn.lxh.java.ManyThread.CompletableFuture.SmallTool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by starlin
 * on 2022/12/7 17:59.
 * 场景：小白制作3个烧饼，其中味道分为好吃的、一般、难吃的三种，顾客小白过来购买烧饼，使用PriorityBlockingQueue队列来保证顾客每次都是买的是味道最好的烧饼[DELICIOUS]
 * 取出来的结果是按照排序的顺序，但是遍历队列的结果是无序的
 * PriorityBlockingQueue是优先级队列，PriorityBlockingQueue队列的元素需要实现Comparable接口，完成队列的排序
 */
public class _08_PriorityBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<PanCake> blockingQueue = new PriorityBlockingQueue<PanCake>(
                5
        );
        Thread xb = new Thread(() -> {
            blockingQueue.add(new PanCake(Flavor.EDIBLE));
            SmallTool.printTimeAndThread("做好第1个烧饼");
            blockingQueue.add(new PanCake(Flavor.DELICIOUS));
            SmallTool.printTimeAndThread("做好第2个烧饼");
            blockingQueue.add(new PanCake(Flavor.UNPALATABLE));
            SmallTool.printTimeAndThread("做好第3个烧饼");
        }, "小白");

        xb.start();

        try {
            xb.join();     // 让小白顺利做完 3个烧饼
        } catch (InterruptedException e) {
            SmallTool.printTimeAndThread("被中断" + e.getMessage());
        }

        new Thread(() -> {
            SmallTool.printTimeAndThread("买到烧饼" + blockingQueue.poll().flavor);
        }, "张三").start();
    }

    private static class PanCake implements Comparable<PanCake> {
        private Flavor flavor;
        public PanCake(Flavor flavor) {
            this.flavor = flavor;
        }
        @Override
        public int compareTo(PanCake o) {
            return this.flavor.compareTo(Flavor.EDIBLE);
        }
    }
}


enum Flavor {
    DELICIOUS, // 好吃
    EDIBLE,     // 一般(能下口)
    UNPALATABLE // 难吃
}

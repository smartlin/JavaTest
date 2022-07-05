package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * Created by starlin
 * on 2022/7/1 19:23.
 */
public class ApplyToEitherDemo {
    /**
     * 场景：小白从餐厅吃完饭，准备坐公交车回家，有两路公交车可以选择（700路，800路），那一路公交车先到，就上车
     * applyToEither作用就是那一个任务先完成，则下面代码中的变量firstBusCome等于先完成任务的返回值
     * 在下面的场景中，都有可能发生异常，可以使用exceptionally来捕获异常。
     * @param args
     */
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("吃完饭，走出餐厅");
        SmallTool.printTimeAndThread("等待700路或者800路公交车到来");
        CompletableFuture<String> bus = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("700路公交车正在赶来");
            SmallTool.sleepMillis(100);
            return "700路公交车来了";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("800路公交车正在赶来");
            SmallTool.sleepMillis(200);
            return "800路公交车来了";
        }), firstBusCome -> {
            SmallTool.printTimeAndThread(firstBusCome);
            if (firstBusCome.startsWith("700")) {
                throw new RuntimeException("700路公交出故障路。。。。");
            }
            return firstBusCome;
        }).exceptionally(e ->{
            SmallTool.printTimeAndThread(e.getMessage());
            SmallTool.printTimeAndThread("小白叫了出租车");
            return "出租车到了";
        });

        SmallTool.printTimeAndThread(String.format("%s,小白坐车回家", bus.join()));
    }
}

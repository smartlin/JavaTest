package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * Created by starlin
 * on 2022/7/1 14:50.
 * CompletableFuture入门
 */
public class ThenApplyAsyncDemo {
    /**
     * 场景5：小白吃好饭，服务员收好钱，并要求另外一个服务员开发票
     * 可以使用supplyAsync(),同时开启 厨师炒菜 和 服务员蒸饭 两个异步任务
     * CompletableFuture提供了另外一种写法thenCombine
     * @param args
     */
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("小白吃好了");
        SmallTool.printTimeAndThread("小白结账、并要求开发票");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("服务员1、收款500元");
            SmallTool.sleepMillis(1000);
            return "500";
        }).thenApplyAsync(money ->{
            SmallTool.printTimeAndThread(String.format("服务员2，开发票，面额 %s元", money));
            SmallTool.sleepMillis(200);
            return String.format("%s元发票", money);
        });

        SmallTool.printTimeAndThread("小白接电话");
        SmallTool.printTimeAndThread(String.format("小白拿到%s,准备回家",cf1.join()));
    }
}

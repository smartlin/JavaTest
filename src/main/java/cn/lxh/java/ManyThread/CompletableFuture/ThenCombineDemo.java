package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * Created by starlin
 * on 2022/7/1 14:50.
 * CompletableFuture入门
 */
public class ThenCombineDemo {
    /**
     * 场景4：前面3个例子中，饭是提前蒸好的，现在的场景是饭没有蒸好，即小白进入餐厅，厨师开始炒菜和服务员开始蒸饭 是同时进行的，等他们都完成后小白才开始吃饭
     * 可以使用supplyAsync(),同时开启 厨师炒菜 和 服务员蒸饭 两个异步任务
     * CompletableFuture提供了另外一种写法thenCombine
     * @param args
     */
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("进入餐厅");
        SmallTool.printTimeAndThread("开始点菜");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("厨师炒菜");
            SmallTool.sleepMillis(1000);
            return "番茄炒蛋";
            //thenCompose： 前一个任务完成（炒菜），后面的任务（打饭）才能进行
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            SmallTool.printTimeAndThread("服务员蒸饭");
            SmallTool.sleepMillis(1000);
            return "米饭";
        }),(dish,rice) -> {
            SmallTool.printTimeAndThread("服务员打饭");
            SmallTool.sleepMillis(1000);
            return String.format("%s + %s 好了", dish, rice);
        });

        SmallTool.printTimeAndThread("等菜的过程中，完游戏");
        //这里的join()方法也可以换成get()方法，唯一区别是get()方法需要捕获异常
        SmallTool.printTimeAndThread(String.format("%s,菜饭已好，开吃",cf1.join()));
    }
}

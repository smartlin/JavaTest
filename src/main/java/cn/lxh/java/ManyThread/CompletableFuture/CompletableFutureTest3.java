package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * Created by starlin
 * on 2022/7/1 14:50.
 * CompletableFuture入门
 */
public class CompletableFutureTest3 {
    /**
     * 场景3：厨师和服务员都是单独的线程，把菜和饭都好了以后，在一起给小白
     * 前提：厨师炒菜 在服务员打饭 前面
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
        }).thenCompose(dish -> CompletableFuture.supplyAsync(()->{
            SmallTool.printTimeAndThread("服务员打饭");
            SmallTool.sleepMillis(1000);
            return dish + " + 米饭";
        }));

        SmallTool.printTimeAndThread("等菜的过程中，完游戏");
        //这里的join()方法也可以换成get()方法，唯一区别是get()方法需要捕获异常
        SmallTool.printTimeAndThread(String.format("%s,菜饭已好，开吃",cf1.join()));
    }
}

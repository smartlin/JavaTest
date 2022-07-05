package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * Created by starlin
 * on 2022/7/1 14:50.
 * CompletableFuture入门
 */
public class CompletableFutureTest2 {
    /**
     * 场景2：在场景1中，厨师要炒菜和蒸饭，在该场景中，把厨师蒸饭的交给服务员来处理
     * 线程：增加服务员线程，厨师线程，小白线程
     * @param args
     */
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("进入餐厅");
        SmallTool.printTimeAndThread("开始点菜");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("厨师炒菜");
            SmallTool.sleepMillis(1000);
            CompletableFuture<String> race = CompletableFuture.supplyAsync(() -> {
                SmallTool.printTimeAndThread("服务员打饭");
                SmallTool.sleepMillis(1000);
                return " + 米饭已好";
            });
            return "番茄炒蛋" + race.join();
        });

        SmallTool.printTimeAndThread("等菜的过程中，完游戏");
        //这里的join()方法也可以换成get()方法，唯一区别是get()方法需要捕获异常
        SmallTool.printTimeAndThread(String.format("%s,菜饭已好，开吃",cf1.join()));
    }
}

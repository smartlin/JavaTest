package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * Created by starlin
 * on 2022/6/15 18:29.
 * CompletableFuture入门
 */
public class CompletableFutureTest1 {
    /**
     * 场景1：小白进入餐厅吃饭，厨师做菜，等菜好的过程中在玩游戏，菜好了，开吃
     * 线程：服务员线程、小白线程
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SmallTool.printTimeAndThread("进入餐厅");
        SmallTool.printTimeAndThread("开始点菜");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("厨师炒菜");
            SmallTool.sleepMillis(200);
            SmallTool.printTimeAndThread("厨师打饭");
            SmallTool.sleepMillis(100);
            return "菜和米饭已经做好";
        });
        SmallTool.printTimeAndThread("等菜的过程中，完游戏");
        //这里的join()方法也可以换成get()方法，唯一区别是get()方法需要捕获异常
        SmallTool.printTimeAndThread(String.format("%s,菜饭已好，开吃",cf1.join()));
    }

}

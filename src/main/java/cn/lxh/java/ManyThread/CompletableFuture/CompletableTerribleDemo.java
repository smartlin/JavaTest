package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

/**
 * Created by starlin
 * on 2022/7/4 11:41.
 * Completable性能问题
 * 场景：小白进餐厅吃饭，点了12个菜，测试需要12个菜需要做多久
 * 一台电脑性能好坏与CPU性能有关，当然跟内存，网卡，硬盘之类的设备也有关系
 * 测试电脑是8核心16线程，一瞬间可以同时处理的任务数就是16个
 */
public class CompletableTerribleDemo {
    public static void main(String[] args) {
        //testError();
        //testCorrect();
        testStream();
    }

    /**
     * 错误示例：当有一批异步任务的时候，一个一个的去join，直接把异步任务变成了串行
     * 运行时间：10102ms
     */
    public static void testError() {
        SmallTool.printTimeAndThread("小白和朋友进入餐厅点菜");
        long startTime = System.currentTimeMillis();
        List<Dish> dishes = new ArrayList<>();
        //点菜
        for (int i = 0; i < 10; i++) {
            Dish dish = new Dish("菜" + i, 1);
            dishes.add(dish);
        }
        //做菜
        for (Dish dish : dishes) {
            CompletableFuture.runAsync(() -> dish.make()).join();
        }
        long endTime = System.currentTimeMillis();

        SmallTool.printTimeAndThread("菜都做好了，可以吃了 " + (endTime - startTime));
    }


      /**
       * 正确示例：当有一批异步任务的时候，先放入list，等待所有任务执行完毕
       * 运行时间：1078ms
       */
    public static void testCorrect() {
        SmallTool.printTimeAndThread("小白和朋友进入餐厅点菜");
        long startTime = System.currentTimeMillis();
        List<Dish> dishes = new ArrayList<>();
        //点菜
        for (int i = 0; i < 10; i++) {
            Dish dish = new Dish("菜" + i, 1);
            dishes.add(dish);
        }
        //做菜
        List<CompletableFuture> completableFutureList = new ArrayList<>();
        for (Dish dish : dishes) {
            CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> dish.make());
            completableFutureList.add(cf);
        }
        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[completableFutureList.size()])).join();
        long endTime = System.currentTimeMillis();

        SmallTool.printTimeAndThread("菜都做好了，可以吃了 " + (endTime - startTime));
    }

    public static void testStream() {
        SmallTool.printTimeAndThread("小白和朋友进入餐厅点菜");
        long startTime = System.currentTimeMillis();
        CompletableFuture[] dishes = IntStream.rangeClosed(1, 15)
                .mapToObj(i -> new Dish("菜" + i, 1))
                .map(dish -> CompletableFuture.runAsync(dish::make))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(dishes).join();

        long endTime = System.currentTimeMillis();
        SmallTool.printTimeAndThread("菜都做好了，可以吃了 " + (endTime - startTime));
    }
}

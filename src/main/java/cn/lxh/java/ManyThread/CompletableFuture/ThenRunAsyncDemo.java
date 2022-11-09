package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by starlin
 * on 2022/7/4 15:37.
 * 测试 A和 B 都不会出现在同一个线程，自测即可（不得用于生成环境）
 */
public class ThenRunAsyncDemo {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0,
                TimeUnit.MILLISECONDS, new SynchronousQueue<>());
        CompletableFuture.runAsync(() -> SmallTool.printTimeAndThread("A"), threadPoolExecutor)
                .thenRunAsync(() -> SmallTool.printTimeAndThread("B"))
                .join();
    }
}

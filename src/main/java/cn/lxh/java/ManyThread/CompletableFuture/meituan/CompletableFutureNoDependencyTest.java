package cn.lxh.java.ManyThread.CompletableFuture.meituan;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by starlin
 * on 2022/12/14 15:14.
 */
public class CompletableFutureNoDependencyTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        //1、使用runAsync或supplyAsync发起异步调用
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            return "result1";
        }, executor);
        //2、CompletableFuture.completedFuture()直接创建一个已完成状态的CompletableFuture
        CompletableFuture<String> cf2 = CompletableFuture.completedFuture("result2");
        //3、先初始化一个未完成的CompletableFuture，然后通过complete()、completeExceptionally()，完成该CompletableFuture
        CompletableFuture<String> cf = new CompletableFuture<>();
        cf.complete("success");
    }
}

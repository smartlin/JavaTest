package cn.lxh.java.ManyThread.CompletableFuture.meituan;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by starlin
 * on 2022/12/14 15:36.
 */
public class CompletableFutureThenCompine {
    public static void main(String[] args) throws Exception{
        ExecutorService executor = Executors.newFixedThreadPool(5);
        long start = System.currentTimeMillis();
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MICROSECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("执行step 1");
            System.out.println("step1 线程名称: " + Thread.currentThread().getName() + System.currentTimeMillis());
            System.out.println("cf1 系统时间：" + System.currentTimeMillis());
            return "step1 result";
        }, executor);
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MICROSECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("执行step 2");
            System.out.println("step2 线程名称: " + Thread.currentThread().getName());
            System.out.println("cf2 系统时间：" + System.currentTimeMillis());
            return "step2 result";
        },executor);
//        cf1.thenCombine(cf2, (result1, result2) -> {
//            System.out.println(result1 + " , " + result2);
//            System.out.println("执行step 3");
//            System.out.println("step3 线程名称：{}" + Thread.currentThread().getName());
//            return "step3 result";
//        }).thenAccept(result3 -> System.out.println(result3));
        long end = System.currentTimeMillis();
        System.out.println((end - start)/1000 + "秒");
    }
}

package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by starlin
 * on 2022/6/15 18:29.
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> cf = new CompletableFuture<>();
        cf.complete("测试");
        //调用着阻塞，等待结果返回
        String result = cf.get();
        System.out.println("cf get 返回值" + result);

        //System.out.println("===============提交任务runAsync()方法和supplyAsync()方法===================start================");
        //提交任务runAsync，无返回值Void
        //CompletableFuture.runAsync（..）传入的是一个 Runnable 接口，
        //使用了 Java 8 的 lambda 表达式的写法，和定义一个 Runnable 对象是等价的
        CompletableFuture<Void> cf1 = CompletableFuture.runAsync(() ->{
            System.out.println("模拟任务正在运行");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        //主线程阻塞，等待任务完成
        System.out.println("cf1 get 返回值" + cf1.get());

        //提交任务supplyAsync，有返回值
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() ->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "任务执行完成";
        });
        String result2 = cf2.get();
        System.out.println("cf2 get 返回值：" + cf2.get());

        // 单个CompletableFuture的依赖可以通过thenApply、thenAccept、thenCompose等方法来实现
        //二元依赖可以通过thenCombine等回调来实现
        //多元依赖可以通过allOf或anyOf方法来实现，区别是当需要多个依赖全部完成时使用allOf，当多个依赖中的任意一个完成即可时使用anyOf

        //System.out.println("===============链式操作thenRun、thenAccept 、thenApply===================start================");

        // thenRun 后面跟的是一个无参数、无返回值的方法 称为 Consumer
        CompletableFuture<Void> cf3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "测试结果";
        }).thenRun(() ->{
            System.out.println("任务已完成");
        });

        // thenAccept t 后面跟的是一个有参数、无返回值的方法，称为 Consumer
        CompletableFuture<Void> cf4 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "测试结果";
        }).thenAccept(System.out::println);

        //System.out.println("===============链式操作thenRun、thenAccept 、thenApply===================end================");
    }
    //测试thenApply
    public void testThenApply() {
        // thenApply 后面跟的是一个有参数、有返回值的方法，称为 Function
        CompletableFuture<String> cf5 = CompletableFuture.supplyAsync(() ->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "测试结果";
        }).thenApply(result2 -> {
            return result2 + "after + thenApply";
        });
    }
}

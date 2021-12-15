package cn.lxh.java.ManyThread.Callable;

import java.util.concurrent.*;

public class CompletableFutureTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CompletableFuture<String> xiaoMei = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "-小美：我开始化妆了，好了我叫你。");
            try {
                int time = ThreadLocalRandom.current().nextInt(5);
                TimeUnit.SECONDS.sleep(time);
                System.out.println(Thread.currentThread().getName() + "-小美,化妆耗时:" + time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "小美：化妆完毕了。";
        }, executorService);

        CompletableFuture<String> xiaoGuai = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "-小乖：我开始化妆了，好了我叫你。");
            try {
                int time = ThreadLocalRandom.current().nextInt(5);
                TimeUnit.SECONDS.sleep(time);
                System.out.println(Thread.currentThread().getName() + "-小乖,化妆耗时:" + time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "小乖：化妆完毕了。";
        }, executorService);

        CompletableFuture<Object> girl = CompletableFuture.anyOf(xiaoMei, xiaoGuai);
        girl.thenAccept(result -> {
            System.out.println("我看最后是谁先画完呢 = " + result);
        });

        CompletableFuture<String> eatChooseOne = girl.thenApplyAsync((result) -> {
            try {
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result + "这里人少,我们去吃沙县小吃吧!";
        }, executorService);

        CompletableFuture<String> eatChooseTwo = girl.thenApplyAsync((result) -> {
            try {
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result + "这里人少,我们去吃黄焖鸡吧!";
        }, executorService);

        CompletableFuture.allOf(eatChooseOne, eatChooseTwo).thenAccept(result -> {
            System.out.println("最终结果：" + result);
        });
    }
}
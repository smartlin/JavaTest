package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by starlin
 * on 2022/7/4 11:17.
 * 6核6线程和6核12线程区别
 * 比喻：6核6线程相当于 6个单灶台和6个厨师
 *      6核12线程相当于 6个双灶台和6个厨师
 */
public class GetCpuPoolSize {
    public static void main(String[] args) {
        // Returns the number of processors available to the Java virtual machine.
        System.out.println(Runtime.getRuntime().availableProcessors());

        // 查看当前线程数
        System.out.println(ForkJoinPool.commonPool().getPoolSize());

        //查看最大线程数
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
    }
}

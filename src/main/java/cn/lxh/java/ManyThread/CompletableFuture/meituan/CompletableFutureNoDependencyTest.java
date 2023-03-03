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
        //1��ʹ��runAsync��supplyAsync�����첽����
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            return "result1";
        }, executor);
        //2��CompletableFuture.completedFuture()ֱ�Ӵ���һ�������״̬��CompletableFuture
        CompletableFuture<String> cf2 = CompletableFuture.completedFuture("result2");
        //3���ȳ�ʼ��һ��δ��ɵ�CompletableFuture��Ȼ��ͨ��complete()��completeExceptionally()����ɸ�CompletableFuture
        CompletableFuture<String> cf = new CompletableFuture<>();
        cf.complete("success");
    }
}

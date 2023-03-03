package cn.lxh.java.ManyThread.CompletableFuture.meituan;

import java.util.concurrent.*;

/**
 * Created by starlin
 * on 2022/12/14 15:28.
 */
public class CompletableFutureBlockThread {
    public static void main(String[] args) {
        ExecutorService threadPool1 = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync ִ���̣߳�" + Thread.currentThread().getName());
            //ҵ�����
            return "";
        }, threadPool1);
        //��ʱ�����future1�е�ҵ������Ѿ�ִ����ϲ����أ����thenApplyֱ���ɵ�ǰmain�߳�ִ�У����򣬽�����ִ������ҵ�������threadPool1�е��߳�ִ�С�
        future1.thenApply(value -> {
            System.out.println("thenApply ִ���̣߳�" + Thread.currentThread().getName());
            return value + "1";
        });
        //ʹ��ForkJoinPool�еĹ����̳߳�CommonPool
        future1.thenApplyAsync(value -> {
        //do something
            return value + "1";
        });
        //ʹ��ָ���̳߳�
        future1.thenApplyAsync(value -> {
            //do something
            return value + "1";
        }, threadPool1);
    }
}

package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.*;

/**
 * Created by starlin
 * on 2024/8/13 14:46.
 * 需要将父任务与子任务做线程池隔离，两个任务请求不同的线程池，避免循环依赖导致的阻塞
 * doGet方法第三行通过supplyAsync向threadPool1请求线程，并且内部子任务又向threadPool1请求线程。threadPool1大小为10，
 * 当同一时刻有10个请求到达，则threadPool1被打满，子任务请求线程时进入阻塞队列排队，
 * 但是父任务的完成又依赖于子任务，这时由于子任务得不到线程，父任务无法完成。主线程执行cf1.join()进入阻塞状态，并且永远无法恢复
 */
public class WrongCompletableFutureDemo {
    public static void main(String[] args) {
        doGet();
    }

    public static Object doGet() {
        ExecutorService threadPool1 = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));

        CompletableFuture cf1 = CompletableFuture.supplyAsync(() -> {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("child");
                return "child";
            }, threadPool1).join();//子任务
        }, threadPool1);// 主任务
        return cf1.join();
    }
}

package cn.lxh.java.ManyThread.Callable;

import java.util.concurrent.*;

/**
 * Created by starlin
 * on 2018/4/15 14:24.
 * 使用Callable和Future获取线程执行结果
 */
public class FutureTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> future = executorService.submit(task);
        executorService.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在进行计算");
        try {
            System.out.println("task运行结果"+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
}

class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i <100 ; i++) {
            sum += i;
        }
        return sum;
    }
}

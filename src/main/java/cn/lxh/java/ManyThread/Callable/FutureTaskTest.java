package cn.lxh.java.ManyThread.Callable;

import java.util.concurrent.*;

/**
 * Created by starlin
 * on 2018/4/15 14:39.
 * ����FutureTask + callable ��ȡ���
 */
public class FutureTaskTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //���ﶨ���taskΪFutureTest�е�task
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        executorService.submit(futureTask);
        executorService.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("���߳���ִ������");

        try {
            System.out.println("task���н��"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

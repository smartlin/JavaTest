package cn.lxh.java.ManyThread.ThreadLocal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by starlin
 * on 2020/8/13 19:27.
 * �Զ���ܾ�����
 */
public abstract class RejectedExecutionHandlerTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 3, 10,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(2),
                // �Զ���ܾ�����
                new RejectedExecutionHandler(){
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        //ҵ������
                        System.out.println("ִ���Զ���ܾ�����");
                    }
                });
        for (int i = 0; i < 6; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}

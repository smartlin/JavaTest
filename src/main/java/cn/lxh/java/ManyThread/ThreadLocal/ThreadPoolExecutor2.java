package cn.lxh.java.ManyThread.ThreadLocal;

import java.util.concurrent.*;

/**
 * Created by starlin
 * on 2020/8/13 18:58.
 * ����execute������ submit��������
 */
public class ThreadPoolExecutor2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 10L,
                TimeUnit.SECONDS, new LinkedBlockingQueue(20));
        // execute ʹ��
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, execute.");
            }
        });

        // submit ʹ��
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Hello, submit.");
                return "Success";
            }
        });
        System.out.println(future.get());
    }
}

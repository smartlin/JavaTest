package cn.lxh.java.ManyThread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchanger是一个用于线程间协作的工具类,线程间交换数据
 * 在这个同步点，两个线程可以交换彼此的数据。
 * 这两个线程通过exchange方法交换数据，如果第一个线程先执行exchange()方法，它会一直等待第二个线程也执行exchange方法。
 * 当两个线程都到达同步点时，这两个线程就可以交换数据，将本现场生产出来的数据传递给对方
 * 如果两个线程有一个没有执行exchange(V x)方法，则会一直等待，
 * 如果担心有特殊情况发生，避免一直等待，可以使用exchange(V x, long timeout, TimeUnit unit)设置最大等待时长
 * Created by starlin
 * on 2017/02/27 22:29.
 */
public class ExchangerTest {
    private static final Exchanger<String> EXCHANGER = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String A = "I am A";
                try{
                    String B = EXCHANGER.exchange(A);
                    System.out.println("In 1-" + Thread.currentThread().getName() + ": " + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String B = "I am B";
                try{
                    String A = EXCHANGER.exchange(B);
                    System.out.println("In 2-" + Thread.currentThread().getName() +": " + A);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.shutdown();
    }
}

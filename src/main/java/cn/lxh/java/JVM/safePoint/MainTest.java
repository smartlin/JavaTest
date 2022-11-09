package cn.lxh.java.JVM.safePoint;

import java.util.concurrent.atomic.AtomicInteger;

public class MainTest {

    public static AtomicInteger num = new AtomicInteger(0);

    /**
     * for循环中int类型改为long类型，会有不同的输出结果
     * 涉及到safepoint的知识点
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=()->{
            for (int i = 0; i < 1000000000; i++) {
                num.getAndAdd(1);
            }
            System.out.println(Thread.currentThread().getName()+"执行结束!");
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println("num = " + num);
    }
}
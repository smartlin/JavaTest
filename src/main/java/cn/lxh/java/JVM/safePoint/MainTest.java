package cn.lxh.java.JVM.safePoint;

import java.util.concurrent.atomic.AtomicInteger;

public class MainTest {

    public static AtomicInteger num = new AtomicInteger(0);

    /**
     * forѭ����int���͸�Ϊlong���ͣ����в�ͬ��������
     * �漰��safepoint��֪ʶ��
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=()->{
            for (int i = 0; i < 1000000000; i++) {
                num.getAndAdd(1);
            }
            System.out.println(Thread.currentThread().getName()+"ִ�н���!");
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println("num = " + num);
    }
}
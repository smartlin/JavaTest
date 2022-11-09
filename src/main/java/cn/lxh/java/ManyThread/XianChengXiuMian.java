package cn.lxh.java.ManyThread;

/**
 * 线程的休眠
 * Created by 1762 on 2015/09/05.
 */
class XianChengXiuMianDemo implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            try {
                Thread.sleep(1000);//线程休眠 1000为毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ",i=" + i);//ManyThread.currentThread()取得当前线程类对象
        }
    }
}

public class XianChengXiuMian {
    public static void main(String[] args) {
        XianChengXiuMianDemo xc = new XianChengXiuMianDemo();
        Thread t1 = new Thread(xc,"线程A");
        Thread t2 = new Thread(xc,"线程B");
        Thread t3 = new Thread(xc,"线程C");
        t1.setPriority(Thread.MAX_PRIORITY);//设置线程最高优先级 10
        t2.setPriority(Thread.NORM_PRIORITY);//设置线程一般优先级 5
        t3.setPriority(Thread.MIN_PRIORITY);//设置线程最低优先级 1
        t1.start();
        t2.start();
        t3.start();
//        new ManyThread(xc,"线程A").start();
//        new ManyThread(xc,"线程B").start();
//        new ManyThread(xc,"线程C").start();
        System.out.println(Thread.currentThread().getPriority());//取得主线程优先级为5
    }
}

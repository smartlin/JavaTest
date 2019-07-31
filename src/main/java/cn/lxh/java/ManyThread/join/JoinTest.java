package cn.lxh.java.ManyThread.join;

import java.util.concurrent.TimeUnit;

/**
 * Created by starlin
 * on 2017/02/25 22:58.
 * 如果一个线程A执行了thread.join()语句，其含义是：当前线程A等待thread线程终止之后才从thread.join()返回。
 * join与synchronized的区别是：join在内部使用wait()方法进行等待，而synchronized关键字使用的是“对象监视器”做为同步。
 * join提供了另外两种实现方法：join(long millis)和join(long millis, int nanos)，
 * 至多等待多长时间而退出等待(释放锁)，退出等待之后还可以继续运行。
 * 内部是通过wait方法来实现的
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("method main begin");
        Thread thread = new Thread(new Runnable() {
            int i = 0;
            @Override
            public void run() {
                while (true){
                    System.out.println(i++);
                    try{
                        TimeUnit.MILLISECONDS.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        thread.join(2000);
        System.out.println("method main end");
    }
}

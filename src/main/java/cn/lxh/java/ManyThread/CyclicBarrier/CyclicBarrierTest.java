package cn.lxh.java.ManyThread.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier让一组线程达到一个屏障时被阻塞，知道最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续运行。
 * CyclicBarrier默认的构造方法是CyclicBarrier(int parties)，其参数表示屏障拦截的线程数量，每个线程调用await方法告诉CyclicBarrier我已经达到了屏障，然后当前线程被阻塞。
 * CyclicBarrier还提供了一个更高级的构造函数CyclicBarrier(int parties, Runnable barrierAction)用于在线程达到屏障时，优先执行barrierAction
 * Created by starlin
 * on 2017/02/27 16:18.
 */
public class CyclicBarrierTest {
    //原先使用new CyclicBarrier(2)输出顺序为3142
    //使用new CyclicBarrier(2,new A())输出顺序为31542
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2,new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println(1);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(2);
            }
        }).start();

        try{
            System.out.println(3);
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(4);
    }

    static class A implements Runnable{

        @Override
        public void run() {
            System.out.println(5);
        }
    }
}

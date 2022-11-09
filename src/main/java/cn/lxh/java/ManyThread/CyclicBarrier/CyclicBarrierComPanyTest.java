package cn.lxh.java.ManyThread.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by starlin
 * on 2019/8/9 15:29.
 */
public class CyclicBarrierComPanyTest {
    public static void main(String[] args) throws InterruptedException {
        // 表示人数
        int count = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count + 1);

        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(count);

        for (int i = 0; i < count; i++) {
            // 将子线程加入到主线程中
            threadPool.execute(new Employee(cyclicBarrier,i + 1));
            Thread.sleep(10);
        }
        try {
            // 阻塞线程，直到所有人到达集合点才执行（出发去目的地）
            cyclicBarrier.await();
            Thread.sleep(10);
            System.out.println("所有人已经到达集合节点，开始前往目的地");
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}

// 每个员工代表子线程
class Employee implements Runnable {

    private CyclicBarrier cyclicBarrier;

    private int employeeIndex;

    public Employee(CyclicBarrier barrier,int employeeIndex){
        this.cyclicBarrier = barrier;
        this.employeeIndex = employeeIndex;
    }

    @Override
    public void run() {
        try {
            System.out.println("员工：" + employeeIndex + ",正在前往集合");
            Thread.sleep(10*employeeIndex);
            System.out.println("员工：" + employeeIndex + ",已到达集合点");
            cyclicBarrier.await();
            //Thread.sleep(10);
            System.out.println("员工：" + employeeIndex + ",已出发前往目的地");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
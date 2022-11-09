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
        // ��ʾ����
        int count = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count + 1);

        // �����̳߳�
        ExecutorService threadPool = Executors.newFixedThreadPool(count);

        for (int i = 0; i < count; i++) {
            // �����̼߳��뵽���߳���
            threadPool.execute(new Employee(cyclicBarrier,i + 1));
            Thread.sleep(10);
        }
        try {
            // �����̣߳�ֱ�������˵��Ｏ�ϵ��ִ�У�����ȥĿ�ĵأ�
            cyclicBarrier.await();
            Thread.sleep(10);
            System.out.println("�������Ѿ����Ｏ�Ͻڵ㣬��ʼǰ��Ŀ�ĵ�");
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}

// ÿ��Ա���������߳�
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
            System.out.println("Ա����" + employeeIndex + ",����ǰ������");
            Thread.sleep(10*employeeIndex);
            System.out.println("Ա����" + employeeIndex + ",�ѵ��Ｏ�ϵ�");
            cyclicBarrier.await();
            //Thread.sleep(10);
            System.out.println("Ա����" + employeeIndex + ",�ѳ���ǰ��Ŀ�ĵ�");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
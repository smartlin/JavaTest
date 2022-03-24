package cn.lxh.java.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * WhyLinkedBlockingQueue�е�setCapacity���޸ģ������������main���̻߳�ֹͣ
 * �޸���setCapatcity���������߳��ܹ���������
 */
public class QueueTest {
    public static void main(String[] args) throws InterruptedException {
        WhyLinkedBlockingQueue<Object> blockingQueue = new WhyLinkedBlockingQueue<>(5);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ":��ʼִ��put(" + i + "��;");
                    blockingQueue.put(i);
                    System.out.println(Thread.currentThread().getName() + ":put(" + i + ")�ɹ�," + "�������" + blockingQueue.remainingCapacity());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        blockingQueue.setCapacity(100);
        System.out.println(Thread.currentThread().getName() + ":���������޸���� ," + "ʣ��������" + blockingQueue.remainingCapacity());

        //�������put�������ڲ��޸�setCapacity���������߳���Ȼ�ܹ����У�Ч�����޸�setCapacity����һ��
        //blockingQueue.put(100);
        //System.out.println(Thread.currentThread().getName() + ":put(100) �ɹ���" + "ʣ��������" + blockingQueue.remainingCapacity());
    }
}
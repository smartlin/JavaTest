package cn.lxh.java.ThreadPool;

import cn.hutool.core.thread.NamedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadChangeDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadChangeDemo.class);

    public static void main(String[] args) {
        dynamicModifyExecutor();
    }

    private static ThreadPoolExecutor buildThreadPoolExecutor() {
        return new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.SECONDS,
                new ResizeableCapacityLinkedBlockingQueue<>(10),
                new NamedThreadFactory("why����", false));
    }

    private static void dynamicModifyExecutor() {
        ThreadPoolExecutor executor = buildThreadPoolExecutor();
        for (int i = 0; i < 15; i++) {
            executor.execute(() -> {
                threadPoolStatus(executor, "��������");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolStatus(executor, "�ı�֮ǰ");
        executor.setCorePoolSize(10);
        executor.setMaximumPoolSize(10);
        ResizeableCapacityLinkedBlockingQueue<Runnable> queue = (ResizeableCapacityLinkedBlockingQueue) executor.getQueue();
        queue.setCapacity(100);
        LOGGER.info("============================================================================================================");
        threadPoolStatus(executor, "�ı�֮��");
    }

    /**
     * ��ӡ�̳߳�״̬
     *
     * @param executor
     * @param name
     */
    private static void threadPoolStatus(ThreadPoolExecutor executor, String name) {
        BlockingQueue<Runnable> queue = executor.getQueue();
        System.out.println(Thread.currentThread().getName() + "-" + name + "-:" +
                "�����߳�����" + executor.getCorePoolSize() +
                " ��߳�����" + executor.getActiveCount() +
                " ����߳�����" + executor.getMaximumPoolSize() +
                " �̳߳ػ�Ծ�ȣ�" +
                divide(executor.getActiveCount(), executor.getMaximumPoolSize()) +
                " �����������" + executor.getCompletedTaskCount() +
                " ���д�С��" + (queue.size() + queue.remainingCapacity()) +
                " ��ǰ�Ŷ��߳�����" + queue.size() +
                " ����ʣ���С��" + queue.remainingCapacity() +
                " ����ʹ�öȣ�" + divide(queue.size(), queue.size() + queue.remainingCapacity()));
    }

    private static String divide(int num1, int num2) {
        return String.format("%1.2f%%", Double.parseDouble(num1 + "") / Double.parseDouble(num2 + "") * 100);
    }
}
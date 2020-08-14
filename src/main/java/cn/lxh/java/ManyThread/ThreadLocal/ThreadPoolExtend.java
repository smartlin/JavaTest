package cn.lxh.java.ManyThread.ThreadLocal;

import java.util.concurrent.*;

/**
 * Created by starlin
 * on 2020/8/13 19:37.
 * beforeExecute �� afterExecute ����
 */
public class ThreadPoolExtend {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // �̳߳���չ����
        MyThreadPoolExecutor executor = new MyThreadPoolExecutor(2, 4, 10,TimeUnit.SECONDS, new LinkedBlockingQueue());
        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                Thread.currentThread().getName();
            });
        }
    }
    /**
     * �̳߳���չ
     */
    static class MyThreadPoolExecutor extends ThreadPoolExecutor {
        // �����߳�ִ�п�ʼʱ��
        private final ThreadLocal<Long> localTime = new ThreadLocal<>();
        public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                    TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        /**
         * ��ʼִ��֮ǰ
         * @param t �߳�
         * @param r ����
         */
        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            Long sTime = System.nanoTime(); // ��ʼʱ�� (��λ������)
            localTime.set(sTime);
            System.out.println(String.format("%s | before | time=%s",
                    t.getName(), sTime));
            super.beforeExecute(t, r);
        }

        /**
         * ִ�����֮��
         * @param r ����
         * @param t �׳����쳣
         */
        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            Long eTime = System.nanoTime(); // ����ʱ�� (��λ������)
            Long totalTime = eTime - localTime.get(); // ִ����ʱ��
            System.out.println(String.format("%s | after | time=%s | ��ʱ��%s ����",
                    Thread.currentThread().getName(), eTime, (totalTime / 1000000.0)));
            super.afterExecute(r, t);
        }
    }
}

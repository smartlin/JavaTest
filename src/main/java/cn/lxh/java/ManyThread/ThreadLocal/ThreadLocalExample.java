package cn.lxh.java.ManyThread.ThreadLocal;

/**
 * Created by starlin
 * on 2017/09/22 15:57.
 * �����������̹߳���һ��MyRunnableʵ����ÿ���߳�ִ��run()������ʱ�򣬻��ͬһ��ThreadLocalʵ�����ò�ͬ��ֵ��
 * �������set()������ʱ����synchronized�ؼ���ͬ�������Ҳ���һ��ThreadLocal����ʵ������ô�ڶ����߳̽��Ḳ�ǵ�һ���߳������õ�ֵ
 */
public class ThreadLocalExample {
    public static class MyRunnable implements Runnable{
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random()*100D));
            try {
                Thread.sleep(200);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ "----->" + threadLocal.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

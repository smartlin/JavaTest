package cn.lxh.java.ManyThread.ThreadLocal;

/**
 * Created by starlin
 * on 2017/09/22 15:57.
 * 创建了两个线程共享一个MyRunnable实例。每个线程执行run()方法的时候，会给同一个ThreadLocal实例设置不同的值。
 * 如果调用set()方法的时候用synchronized关键字同步，而且不是一个ThreadLocal对象实例，那么第二个线程将会覆盖第一个线程所设置的值
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

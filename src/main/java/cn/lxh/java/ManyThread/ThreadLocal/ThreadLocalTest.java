package cn.lxh.java.ManyThread.ThreadLocal;

/**
 * Created by starlin
 * on 2019/7/3 15:57.
 * ThreadLocal的最佳实践
 *
 * 由于线程的生命周期很长，如果我们往ThreadLocal里面set了很大很大的Object对象，
 * 虽然set、get等等方法在特定的条件会调用进行额外的清理，但是ThreadLocal被垃圾回收后，
 * 在ThreadLocalMap里对应的Entry的键值会变成null，但是后续在也没有操作set、get等方法了。
 * 所以最佳实践，应该在我们不使用的时候，主动调用remove方法进行清理。
 *
 * 把ThreadLocal定义为static还有一个好处就是，由于ThreadLocal有强引用在，
 * 那么在ThreadLocalMap里对应的Entry的键会永远存在，
 * 那么执行remove的时候就可以正确进行定位到并且删除！！！
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    threadLocal.set(i);
                    System.out.println(Thread.currentThread().getName() + "--->" + threadLocal.get());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                // 主动调用remove方法进行清理
                threadLocal.remove();
            }
        },"thread1").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "--->" + threadLocal.get());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                // 主动调用remove方法进行清理
                threadLocal.remove();
            }
        },"thread2").start();
    }
}

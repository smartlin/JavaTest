package cn.lxh.java.ManyThread.join;

/**
 * Created by starlin
 * on 2016/08/20 21:36.
 * 主要是测试Thead.sleep()不释放锁，线程A一直持有ThreadB对象的锁，时间达6秒
 * ThreadC只有的ThreadA6秒释放了ThreadB的锁，才能调用ThreadB的中的同步方法
 */
public class Test {
    public static void main(String[] args) {
        try{
            ThreadB threadB = new ThreadB();
            ThreadA threadA = new ThreadA(threadB);
            threadA.start();
            Thread.sleep(1000);
            ThreadC c = new ThreadC(threadB);
            c.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

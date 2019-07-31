package cn.lxh.java.ManyThread.notify;

/**
 * Created by starlin
 * on 2016/08/20 16:33.
 * 必须执行完notify()方法所在的同步synchronized代码块后才释放锁
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        threadA.start();
        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.start();
        SynNotifyMethodThread synNotifyMethodThread = new SynNotifyMethodThread(lock);
        synNotifyMethodThread.start();
    }
}

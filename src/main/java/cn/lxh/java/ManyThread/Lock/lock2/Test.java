package cn.lxh.java.ManyThread.Lock.lock2;

/**
 * Created by starlin
 * on 2016/08/21 15:50.
 * 使用ReentrantLock实现同步
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.setName("A");
        a.start();
        ThreadAA aa = new ThreadAA(myService);
        aa.setName("AA");
        aa.start();
        Thread.sleep(1000);
        ThreadB b = new ThreadB(myService);
        b.setName("B");
        b.start();
        ThreadBB bb = new ThreadBB(myService);
        bb.setName("BB");
        bb.start();
    }
}

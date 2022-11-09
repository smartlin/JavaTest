package cn.lxh.java.ManyThread.Lock.productionanduser1vs1;

/**
 * Created by starlin
 * on 2016/08/21 16:51.
 * 实现生产者消费者1对1
 */
public class Test {
    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.start();
        ThreadB b = new ThreadB(myService);
        b.start();
    }
}

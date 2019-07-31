package cn.lxh.java.ManyThread.Lock.condition1;

/**
 * Created by starlin
 * on 2016/08/21 16:21.
 * 使用多个Condition实现通知部分线程
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(myService);
        b.setName("B");
        b.start();
        Thread.sleep(3000);
        myService.singalAll_A();
    }
}

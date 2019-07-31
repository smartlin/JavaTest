package cn.lxh.java.ManyThread.Lock.lock1;

/**
 * Created by starlin
 * on 2016/08/21 15:40.
 */
public class Test {
    public static void main(String[] args) {
        Service service = new Service();
        MyThread a1 = new MyThread(service);
        MyThread a2 = new MyThread(service);
        MyThread a3 = new MyThread(service);
        MyThread a4 = new MyThread(service);
        MyThread a5 = new MyThread(service);
        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
    }
}

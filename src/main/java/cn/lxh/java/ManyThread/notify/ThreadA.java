package cn.lxh.java.ManyThread.notify;

/**
 * Created by starlin
 * on 2016/08/20 16:29.
 */
public class ThreadA extends Thread{
    private Object lock;
    public ThreadA(Object lock){
        super();
        this.lock = lock;
    }
    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }
}

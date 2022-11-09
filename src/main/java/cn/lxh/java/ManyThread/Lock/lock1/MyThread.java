package cn.lxh.java.ManyThread.Lock.lock1;

/**
 * Created by starlin
 * on 2016/08/21 15:38.
 */
public class MyThread extends Thread{
    private Service service;

    public MyThread(Service service) {
        this.service = service;
    }

    @Override
    public void run(){
        service.testMethod();
    }
}

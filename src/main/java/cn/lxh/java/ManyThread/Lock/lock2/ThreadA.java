package cn.lxh.java.ManyThread.Lock.lock2;

/**
 * Created by starlin
 * on 2016/08/21 15:48.
 */
public class ThreadA extends Thread {
    private MyService myService;

    public ThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run(){
        myService.testMethodA();
    }
}

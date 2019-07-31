package cn.lxh.java.ManyThread.Lock.lock2;

/**
 * Created by starlin
 * on 2016/08/21 15:49.
 */
public class ThreadAA extends Thread {
    private MyService myService;

    public ThreadAA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run(){
        myService.testMethodA();
    }
}

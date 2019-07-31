package cn.lxh.java.ManyThread.Lock.lock2;

/**
 * Created by starlin
 * on 2016/08/21 15:48.
 */
public class ThreadB extends Thread {
    private MyService myService;

    public ThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run(){
        myService.testMethodB();
    }
}

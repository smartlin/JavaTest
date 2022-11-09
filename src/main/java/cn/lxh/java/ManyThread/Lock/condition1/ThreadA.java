package cn.lxh.java.ManyThread.Lock.condition1;

/**
 * Created by starlin
 * on 2016/08/21 16:20.
 */
public class ThreadA extends Thread {
    private MyService myService;

    public ThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run(){
        myService.awaitA();
    }
}

package cn.lxh.java.ManyThread.Lock.productionanduser1vs1;

/**
 * Created by starlin
 * on 2016/08/21 16:50.
 */
public class ThreadA extends Thread{
    private MyService myService;

    public ThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run(){
        for(int i=0;i<Integer.MAX_VALUE;i++){
            myService.set();
        }
    }
}

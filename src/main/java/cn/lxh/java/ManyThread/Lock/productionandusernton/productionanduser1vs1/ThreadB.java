package cn.lxh.java.ManyThread.Lock.productionandusernton.productionanduser1vs1;

/**
 * Created by starlin
 * on 2016/08/21 16:50.
 */
public class ThreadB extends Thread{
    private MyService myService;

    public ThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run(){
        for(int i=0;i<Integer.MAX_VALUE;i++){
            myService.get();
        }
    }
}

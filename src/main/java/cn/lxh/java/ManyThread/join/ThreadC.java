package cn.lxh.java.ManyThread.join;

/**
 * Created by starlin
 * on 2016/08/20 21:34.
 */
public class ThreadC extends Thread{
    private ThreadB b;
    public ThreadC(ThreadB b){
        this.b = b;
    }
    @Override
    public void run(){
        b.bService();
    }
}

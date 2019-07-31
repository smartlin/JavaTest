package cn.lxh.java.ManyThread.join;

/**
 * Created by starlin
 * on 2016/08/20 21:31.

 */
public class ThreadA extends Thread {
    private ThreadB b;
    public ThreadA(ThreadB b){
        this.b = b;
    }
    @Override
    public void run(){
        try{
            synchronized (b){
                b.start();
                Thread.sleep(6000);//Thread.sleep()不释放锁
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

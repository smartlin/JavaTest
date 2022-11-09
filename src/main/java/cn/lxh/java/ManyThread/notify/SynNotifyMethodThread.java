package cn.lxh.java.ManyThread.notify;

/**
 * Created by starlin
 * on 2016/08/20 16:32.
 */
public class SynNotifyMethodThread extends Thread{
    private Object lock;
    public SynNotifyMethodThread(Object lock){
        super();
        this.lock = lock;
    }
    @Override
    public void run() {
        Service service = new Service();
        service.synNotifyMethod(lock);
    }
}

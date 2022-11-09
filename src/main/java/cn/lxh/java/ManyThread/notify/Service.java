package cn.lxh.java.ManyThread.notify;

/**
 * Created by starlin
 * on 2016/08/20 16:20.
 * Notify()被执行后不释放锁
 */
public class Service {
    public void testMethod(Object lock)  {
        try{
            synchronized (lock){
                System.out.println("begin wait() ThreadName=" + Thread.currentThread().getName());
                lock.wait();
                System.out.println("end wait() ThreadName=" + Thread.currentThread().getName());
            }
        }catch (InterruptedException e){

        }
    }
    public void synNotifyMethod(Object lock){
        try{
            synchronized (lock){
                System.out.println("begin notify() ThreadName=" + Thread.currentThread().getName() + " time=" +System.currentTimeMillis());
                lock.notify();
                Thread.sleep(5000);
                System.out.println("end notify() ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            }
        }catch (InterruptedException e){

        }
    }
}

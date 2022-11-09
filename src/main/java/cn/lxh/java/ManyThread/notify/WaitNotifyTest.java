package cn.lxh.java.ManyThread.notify;

import java.util.concurrent.TimeUnit;

/**
 * ���Ѳ����������̻�ö��������Ҫ�ȴ�ִ��notify()�������߳�ִ���꣬
 * ���˳�synchronized�����󣬵�ǰ�̲߳Ż��ͷ���������wait״̬���̲߳ſ��Ի�ȡ�ö�������
 * Created by starlin
 * on 2017/02/25 22:21.
 */
public class WaitNotifyTest {
    public static Object object = new Object();
    static class Thread1 implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
            synchronized (object){
                try {
                    object.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " get the lock");
        }

    }

    static class Thread2 implements Runnable{

        @Override
        public void run() {
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+ " is running");
                object.notify();
                System.out.println(Thread.currentThread().getName() + " invoke notify()");
                System.out.println(Thread.currentThread().getName()+ " release the lock.");
            }
        }
    }
    //��Thread-0������wait��������ͷ���object����Thread-1��ȡ��֮�����notify���ͷ�����
    // �������ʱ��Thread0û�����̻�ȡobject�������ǵȵ���Thread-1��ͬ�����˳�֮��Ż�ȡ��object����
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        thread1.start();
        TimeUnit.SECONDS.sleep(1);
        thread2.start();
    }
}


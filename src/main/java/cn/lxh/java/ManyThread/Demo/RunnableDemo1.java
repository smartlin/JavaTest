package cn.lxh.java.ManyThread.Demo;

/**
 * 利用Runnable实现三个线程卖票
 * 多个线程访问同一资源一定要考虑线程同步，但是同步会影响程序的性能，同时会提升数据的安全性
 * 但是过多的同步(synchronized)会有可能出现死锁
 * ManyThread.currentThread()取得当前线程对象，然后用getName()方法获取线程名称
 * 非static的同步方法使用对象是this，static的同步方法使用的对象是 类名.class
 * Created by 1762 on 2015/09/05.
 */
class MYThread implements Runnable{
    private int tickets = 8;
    public void run(){
        for(int i = 0;i<20;i++){
            this.sale();
        }
//            synchronized (this) {//同步处理，异步处理不使用synchronized 这一块也称为同步代码块synchronized(对象){}
//                                 //synchronized (this)表示当前操作每次只允许一个对象进入
//                if (this.tickets > 0) {
//                    try {
//                        ManyThread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(ManyThread.currentThread().getName() + ",剩余票数:" + this.tickets--);
//                }
//            }
//        }
    }

    public synchronized void sale(){//定义同步方法 和上面的同步代码块一样
        if (this.tickets > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ",剩余票数:" + this.tickets--);//ManyThread.currentThread()取得当前线程对象
        }
    }
    public static void test(){
        MYThread mt = new MYThread();
        new Thread(mt,"票贩1").start();//一个线程  多个线程对象只用一个MYThread对象
        new Thread(mt,"票贩2").start();//二个线程
        new Thread(mt,"票贩3").start();//三个线程
        new Thread(mt,"票贩4").start();//三个线程
        new Thread(mt,"票贩5").start();//三个线程
        new Thread(mt,"票贩6").start();//三个线程

    }
}



public class RunnableDemo1 {
    public static void main(String[] args) {
        MYThread.test();
    }
}

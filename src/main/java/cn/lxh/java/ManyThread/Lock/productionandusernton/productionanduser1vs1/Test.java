package cn.lxh.java.ManyThread.Lock.productionandusernton.productionanduser1vs1;

/**
 * Created by starlin
 * on 2016/08/21 16:51.
 * 实现生产者消费者多对多
 */
public class Test {
    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA[] a = new ThreadA[10];
        ThreadB[] b = new ThreadB[10];
        for(int i=0;i<10;i++){
            a[i] = new ThreadA(myService);
            b[i] = new ThreadB(myService);
            a[i].start();
            b[i].start();
        }

    }
}

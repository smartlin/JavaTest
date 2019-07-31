package cn.lxh.java.ManyThread.Demo;

/**
 * Created by starlin
 * on 2017/09/22 13:28.
 * JavaÍ¬²½ÊµÀý
 */
public class Counter {
    long count = 0;
    public synchronized void add(long value){
        this.count += value;
        System.out.println(count);
    }
}

class CounterThead extends Thread{
    protected  Counter counter = null;

    public CounterThead(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            counter.add(i);
        }
    }
}

class Test{
    public static void main(String[] args) {
        Counter counter = new Counter();
        //CounterThead thead1 = new CounterThead(counter);
        //CounterThead thead2 = new CounterThead(counter);
        Thread thread1 = new CounterThead(counter);
        Thread thread2 = new CounterThead(counter);
        //new Thread(thead1).start();
        //new Thread(thead2).start();
        thread1.start();
        thread2.start();
    }
}

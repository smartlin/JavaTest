package cn.lxh.java.ManyThread.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ����JDK1.5������lockʵ����������������
 * Created by starlin
 * on 2016/04/18 22:23.
 */
public class LockDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Conustom customer = new Conustom(resource);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(producer);
        Thread t3 = new Thread(customer);
        Thread t4 = new Thread(customer);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Resource{
    private String name;
    private int count = 1;
    private boolean flag = false;

    private Lock lock = new ReentrantLock();
    private Condition condition_pro = lock.newCondition();
    private Condition condition_cus = lock.newCondition();

    //������
    public void set(String name) throws InterruptedException {
        lock.lock();
        try{
            while(flag) {
                condition_pro.await();
            }
            this.name = name + "--------" + count++;
            System.out.println(Thread.currentThread().getName()+ ".......������........" + this.name);
            flag = true;
            condition_cus.signal();
        }finally {
            lock.unlock();
        }

    }
    //������
    public void out() throws InterruptedException {
        lock.lock();
        try{
            while (!flag){
                condition_cus.await();
            }
            System.out.println(Thread.currentThread().getName()+"....������...."+this.name);
            flag = false;
            condition_pro.signal();
        }finally {
            lock.unlock();
        }

    }
}

class Producer implements Runnable{
    private Resource resource;
    public Producer(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        try {
            resource.set("+��Ʒ+");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Conustom implements Runnable{
    private Resource resource;
    public Conustom(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        try {
            resource.out();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
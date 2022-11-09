package cn.lxh.java.ManyThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by starlin
 * on 2022/8/7 17:53.
 * 利用ThreadFactory线程的创建
 */
public class ThreadCreate {
    public static void main(String[] args) {
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadFactory.newThread(new Printer()).start();
    }



}

class Printer implements Runnable{

    @Override
    public void run() {

    }
}
package cn.lxh.java.ManyThread.Demo;

/**
 * 多线程实现方式二 实现Runnable接口
 * 实现多线程用Runnable，启动多线程用Thread
 * Created by 1762 on 2015/09/05.
 */
class MyThread implements Runnable {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(this.name + " ,i" + i);
        }

    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        MyThread mtA = new MyThread("线程A");
        MyThread mtB = new MyThread("线程B");
        MyThread mtC = new MyThread("线程C");
     //   mtA.run();
        new Thread(mtA).start();
        new Thread(mtB).start();
        new Thread(mtC).start();
    }
}

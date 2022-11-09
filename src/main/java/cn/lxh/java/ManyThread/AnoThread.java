package cn.lxh.java.ManyThread;

/**
 * 匿名内部类运行线程
 * Created by starlin
 * on 2016/06/16 16:21.
 */
public class AnoThread {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            public void run(){
                System.out.println("Thread in Running");
            }
        };
        thread.start();
    }
}

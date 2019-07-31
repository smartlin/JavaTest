package cn.lxh.java.ManyThread;

/**
 * 取得当前线程正在运行的名字
 * Created by starlin
 * on 2016/06/16 16:35.
 */
public class GetThreadName {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        for(int i=0;i<10;i++){
            new Thread(""+ i){//定义线程的名称i
                public void run(){
                    System.out.println("Thread " + getName() + " running");
                }
            }.start();
        }
    }
}

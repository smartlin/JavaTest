package cn.lxh.java.ManyThread;

/**
 * 匿名内部类实现Runnable
 * Created by starlin
 * on 2016/06/16 16:25.
 */
public class AnoRunable{
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable is Runnning");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

}

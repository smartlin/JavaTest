package cn.lxh.java.ManyThread.ThreadLocal;

/**
 * Created by starlin
 * on 2016/08/21 15:21.
 */
public class ThreadA extends Thread{
    @Override
    public void run(){
        try{
            for(int i=0;i<10;i++){
                System.out.println("在ThreadA线程中的取值=" + new ThreadLocalExt().get());
            }
        }catch (Exception e){

        }
    }
}

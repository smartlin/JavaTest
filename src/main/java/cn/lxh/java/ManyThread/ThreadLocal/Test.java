package cn.lxh.java.ManyThread.ThreadLocal;

/**
 * Created by starlin
 * on 2016/08/21 15:25.
 * 验证线程变量的隔离性
 */
public class Test {
    public static void main(String[] args) {
        try{
            for(int i=0;i<20;i++){
                System.out.println(" Main线程中的取值=" + new ThreadLocalExt().get());
                Thread.sleep(1000);
            }
            Thread.sleep(5000);
            ThreadA threadA = new ThreadA();
            threadA.start();
        }catch (Exception e){

        }
    }
}

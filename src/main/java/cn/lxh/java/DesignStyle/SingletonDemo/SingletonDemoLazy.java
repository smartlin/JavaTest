package cn.lxh.java.DesignStyle.SingletonDemo;

/**
 * 单例设计--懒汉模式 设计的时候先不实例化（会存在线程安全问题）
 * Created by starlin
 * on 2015/09/21 20:13.
 */
class SingletonDemoL{
    private static SingletonDemoL instance = null;
    private SingletonDemoL(){

    }
    public static SingletonDemoL getInstance(){
        if(instance==null) {//提供了代码的效率
            synchronized (SingletonDemoL.class) {//静态方法中用的同步锁
                if (instance == null) {
                    instance = new SingletonDemoL();
                }
            }
        }
        return instance;

    }
    public void print(){
        System.out.println("Hello World!!");
    }
}
public class SingletonDemoLazy {
    public static void main(String[] args) {
        SingletonDemoL sd = SingletonDemoL.getInstance();
        sd.print();
    }
}


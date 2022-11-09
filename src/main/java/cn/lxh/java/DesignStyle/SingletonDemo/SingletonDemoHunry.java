package cn.lxh.java.DesignStyle.SingletonDemo;

/**
 * 单例设计模式--饿汉模式
 * 无论实例化多少个SingleTon对象（如sd1和sd2两个对象），但是本质上永远只有一个实例化对象
 * Created by starlin
 * on 2015/09/21 20:02.
 */
class SingletonDemo{
    private static final SingletonDemo INSTANCE = new SingletonDemo();//在类的内部创建一个类的实例
    private SingletonDemo(){//构造方法私有化
    }
    public static SingletonDemo getInstance(){
        return INSTANCE;
    }
    public void print(){
        System.out.println("Hello World!!");
    }
}
public class SingletonDemoHunry {
    public static void main(String[] args) {
        SingletonDemo sd1 = SingletonDemo.getInstance();
        SingletonDemo sd2 = SingletonDemo.getInstance();
        System.out.println(sd1 == sd2);
        sd1.print();
    }
}

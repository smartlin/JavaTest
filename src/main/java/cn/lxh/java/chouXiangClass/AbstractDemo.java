package cn.lxh.java.chouXiangClass;

/**
 * 抽象类不能被实例化，但是有构造方法
 * Created by starlin
 * on 2015/10/07 17:52.
 */
abstract class A{
    public void fun(){
        System.out.println("A");
    }
    public abstract void print();//abstract方法没有方法体，抽象方法所在的类必须是抽象类
}
class B extends A{

    @Override
    public void print() {
        System.out.println("demo");
    }
}
public class AbstractDemo {
    public static void main(String[] args) {
        A a = new B();//向上转型
        a.print();//被子类所复写过的方法
    }
}

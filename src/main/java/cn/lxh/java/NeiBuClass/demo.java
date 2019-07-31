package cn.lxh.java.NeiBuClass;

/**
 * �����ڲ���
 * Created by starlin
 * on 2015/10/23 21:08.
 */
interface IDemo{
    public void fun();
    public void function();
}
class A implements IDemo{
    public A(IDemo iDemo){

    }
    @Override
    public void fun() {
        System.out.println("demo world fun");
    }

    @Override
    public void function() {
        System.out.println("function");
    }
}
public class demo {
    public static void main(String[] args) {
       A a = new A(new IDemo() {
           @Override
           public void fun() {
           }

           @Override
           public void function() {
           }
       });
        a.fun();
        a.function();
    }
}

package cn.lxh.java.Object;

/**
 * object接收接口对象
 * Created by starlin
 * on 2015/10/07 21:21.
 */
interface A{
    public void fun();
}
class B implements A{

    @Override
    public void fun() {
        System.out.println("demo");
    }
}
public class ObjectDemo1 {
    public static void main(String[] args) {
        A a = new B();
        Object obj = a;//object接收接口对象
        B temp = (B) a;//向下转型
        temp.fun();
    }
}

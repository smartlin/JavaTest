package cn.lxh.java.DuoTai;

/**
 * 多态：父类的引用指向了自己的子类对象，多态自始至终都是子类的对象在变化;
 * 非静态方法在多态调用时，编译看左边，运行看右边，静态方法在多态中，无论编译或运行都看左边；
 * 属性在多态调用时，都看左边
 * 多态前提：要有类的继承、要有子类对父类方法的重写
 * 对象的多态性：指的是发生在继承关系中，子类和父类之间的转换
 * 向上转型（自动完成）： 父类 父类对象 = 子类实例
 * 向下转型（强制完成）： 子类 子类对象 = （子类）父类实例
 * 为保证转型的顺利，java里面有提供一个关键字instanceof 返回boolean型
 * Created by starlin
 * on 2015/10/07 15:58.
 */
class A{
    public void print(){
        System.out.println("A");
    }
}
class B extends A{
    public void print(){
        System.out.println("B");
    }
    public void fun(){
        System.out.println("B中的fun方法");
    }
}
public class TestDuoTai {
    public static void main(String[] args) {
        A a = new B();//向上转型
        a.print();//一定是输出的是B中的print，看new的是那个子类，子类是否复写了父类的方法
        B b = (B) a;//向下转型 调用子类的的特俗功能
        b.fun();

        fun(new B());
        System.out.println(a instanceof A);
        System.out.println(b instanceof B);
    }
    public static void fun(A a){
        B b = (B) a;//调用子类的的特俗功能
        b.fun();
    }
}

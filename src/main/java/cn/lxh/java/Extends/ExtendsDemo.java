package cn.lxh.java.Extends;

/**
 * 继承：对子类对象进行初始化时，父类的构造方法也会运行
 * 因为子类的构造方法中默认第一个行有个super()，必须放在第一行
 * Created by starlin
 * on 2015/10/22 20:45.
 */
class Person{
    public Person(){
        System.out.println("Person");
    }
}
class Students extends Person{
    public Students(){
        System.out.println("student");
    }
}
public class ExtendsDemo {
    public static void main(String[] args) {
        Students s = new Students();
    }
}

package cn.lxh.java.NeiBuClass;

/**
 * 内部类被static修饰后，只能访问外部类的static成员
 * 当内部类中定义的static成员，该内部类必须是static
 * 当外部类中的static方法访问内部类时，内部类必须是static的
 * Created by starlin
 * on 2015/10/05 15:37.
 */
class Outer1{
    private static String msg = "Hello World";
    static class Inner{
        public void print(){
            System.out.println(msg);
        }
    }
}
public class StaticNeiBuClass {
    public static void main(String[] args) {
        Outer1.Inner in = new Outer1.Inner();//static内部类定义方式为 外部类.内部类 对象= new 外部类.内部类();
        in.print();
    }
}

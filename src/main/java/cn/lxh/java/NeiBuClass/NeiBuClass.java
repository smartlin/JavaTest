package cn.lxh.java.NeiBuClass;

/**
 * 定义内部类
 * 内部类直接访问外部类中的成员，是因为内部类中持有了外部类的引用 格式：外部类.this.外部类成员
 * Created by starlin
 * on 2015/10/05 15:01.
 */
class Outer{
    private String msg = "Hello World";
    class Inner{
        public void print(){
            System.out.println(Outer.this.msg);
        }
    }
//    public void fun(){
//        new Inner().print();
//    }
}
public class NeiBuClass {
    public static void main(String[] args) {
//        Outer out = new Outer();
      //  out.fun();
        //不调用fun方法直接通过以下方式可以调用内部类的方法
        Outer.Inner in = new Outer().new Inner();//外部类.内部类 对象= new 外部类().new 内部类();
        in.print();
    }
}

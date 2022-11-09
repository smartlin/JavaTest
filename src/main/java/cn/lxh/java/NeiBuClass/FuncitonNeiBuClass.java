package cn.lxh.java.NeiBuClass;

/**
 * 方法中定义内部类
 * Created by starlin
 * on 2015/10/05 16:05.
 */
class Outer2{
    private String msg = "Hello world";
    public void fun(final int num){//JDK1.8之后不需要再使用final
        final double score = 99.9;//内部类定义在方法内，访问方法中的属性时，需要定义为final
        class Inner{
            public void print(){
                System.out.println("属性：" + Outer2.this.msg);
                System.out.println("方法参数：" + num);
                System.out.println("方法变量" + score);
            }
        }
        new Inner().print();
    }
}
public class FuncitonNeiBuClass {
    public static void main(String[] args) {
        Outer2 out = new Outer2();
        out.fun(100);
    }
}

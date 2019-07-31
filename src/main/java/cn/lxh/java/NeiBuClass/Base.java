package cn.lxh.java.NeiBuClass;

public class Base {

    private String baseName = "base";

    //构造方法

    public Base() {
        callName();
    }

    //对象方法
    public void callName() {

        System.out.println(baseName);

    }

    //静态内部类

    static class Sub extends Base {

//静态内部类的字段

        private String baseName = "sub";

        //静态类中的方法，可以发现，是对父类中方法的重写

        public void callName() {

            System.out.println(baseName);

        }

    }

//程序的入口

    public static void main(String[] args) {

        Base b = new Sub();

    }

}
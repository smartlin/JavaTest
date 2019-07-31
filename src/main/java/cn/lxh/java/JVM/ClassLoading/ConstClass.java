package cn.lxh.java.JVM.ClassLoading;

/**
 * Created by starlin
 * on 2018/8/26 23:26.
 */
public class ConstClass {
    static {
        System.out.println("ConstClass inti");
    }

    public static final String VALUE = "Hello World";
}

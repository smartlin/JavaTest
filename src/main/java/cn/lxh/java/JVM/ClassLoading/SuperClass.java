package cn.lxh.java.JVM.ClassLoading;

/**
 * Created by starlin
 * on 2018/8/26 23:20.
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init");
    }

    public static int value = 3;
}

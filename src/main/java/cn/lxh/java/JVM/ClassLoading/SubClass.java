package cn.lxh.java.JVM.ClassLoading;

/**
 * Created by starlin
 * on 2018/8/26 23:21.
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }
}

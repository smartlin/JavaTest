package cn.lxh.java.reflection.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by starlin
 * on 2019/9/21 15:48.
 */
public class TestSubject {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        InvocationHandler handler = new SubjectHandle(subject);
        ClassLoader cl = subject.getClass().getClassLoader();
        //¶¯Ì¬´úÀí
        Subject proxy = (Subject) Proxy.newProxyInstance(cl, subject.getClass().getInterfaces(), handler);
        proxy.request();
    }
}

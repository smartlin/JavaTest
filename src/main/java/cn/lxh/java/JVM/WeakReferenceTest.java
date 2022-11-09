package cn.lxh.java.JVM;

import cn.lxh.java.redis.springRedis.User;

import java.lang.ref.WeakReference;

/**
 * Created by starlin
 * on 2019/9/10 13:58.
 * 弱引用
 * 只要发生垃圾回收，若这个对象只被弱引用指向，那么就会被回收
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        WeakReference<User> weakReference = new WeakReference<User>(new User("zhangsna", "123456"));
        System.gc();
        System.out.println("手动触发gc：" + weakReference.get());
    }
}

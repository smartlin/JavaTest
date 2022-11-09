package cn.lxh.java.JVM;


import cn.lxh.java.redis.springRedis.User;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * Created by starlin
 * on 2019/9/10 14:02.
 * 虚引用
 * 虚引用是最弱的引用，也就是你定义了虚引用根本无法通过虚引用获取到这个对象，更别谈影响这个对象的生命周期了。
 * 在虚引用中唯一的作用就是用队列接收对象即将死亡的通知
 */
public class PhantomReferenceTest {
    public static void main(String[] args) {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference<User> phantomReference = new PhantomReference<User>(new User("zhangshan","123455"),referenceQueue);
        System.out.println("什么也不做，获取："+ phantomReference.get());
    }
}

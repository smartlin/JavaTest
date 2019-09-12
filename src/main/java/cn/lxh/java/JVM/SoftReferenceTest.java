package cn.lxh.java.JVM;


import cn.lxh.java.redis.springRedis.User;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * Created by starlin
 * on 2019/9/10 9:34.
 * 软引用
 * 通过 -Xmx10m 设置我们堆内存大小为 10，造成内存不足，可以看出system.gc并没有回收软引用的对象
 * 只有在内存不足的情况下才触发
 */
public class SoftReferenceTest {

    private static void makeHeapNotEnough() {
        SoftReference softReference = new SoftReference(new byte[1024 * 1024 * 5]);
        byte[] bytes = new byte[1024 * 1024 * 5];
    }
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<User> referenceQueue = new ReferenceQueue();
        SoftReference softReference = new SoftReference(new User("zhangshan", "123456"),referenceQueue);
        //手动gc
        System.gc();
        Thread.sleep(1000);
        System.out.println("手动触发GC：" + softReference.get());
        System.out.println("手动触发的队列：" + referenceQueue.poll());
        //设置堆内存不足触发gc
        makeHeapNotEnough();
        System.out.println("通过堆内存不足触发GC：" + softReference.get());
        System.out.println("通过堆内存不足触发GC,队列：" + referenceQueue.poll());
    }
}

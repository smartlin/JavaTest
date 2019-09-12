package cn.lxh.java.JVM;


import cn.lxh.java.redis.springRedis.User;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * Created by starlin
 * on 2019/9/10 9:34.
 * ������
 * ͨ�� -Xmx10m �������Ƕ��ڴ��СΪ 10������ڴ治�㣬���Կ���system.gc��û�л��������õĶ���
 * ֻ�����ڴ治�������²Ŵ���
 */
public class SoftReferenceTest {

    private static void makeHeapNotEnough() {
        SoftReference softReference = new SoftReference(new byte[1024 * 1024 * 5]);
        byte[] bytes = new byte[1024 * 1024 * 5];
    }
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<User> referenceQueue = new ReferenceQueue();
        SoftReference softReference = new SoftReference(new User("zhangshan", "123456"),referenceQueue);
        //�ֶ�gc
        System.gc();
        Thread.sleep(1000);
        System.out.println("�ֶ�����GC��" + softReference.get());
        System.out.println("�ֶ������Ķ��У�" + referenceQueue.poll());
        //���ö��ڴ治�㴥��gc
        makeHeapNotEnough();
        System.out.println("ͨ�����ڴ治�㴥��GC��" + softReference.get());
        System.out.println("ͨ�����ڴ治�㴥��GC,���У�" + referenceQueue.poll());
    }
}

package cn.lxh.java.JVM;

import cn.lxh.java.redis.springRedis.User;

import java.lang.ref.WeakReference;

/**
 * Created by starlin
 * on 2019/9/10 13:58.
 * ������
 * ֻҪ�����������գ����������ֻ��������ָ����ô�ͻᱻ����
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        WeakReference<User> weakReference = new WeakReference<User>(new User("zhangsna", "123456"));
        System.gc();
        System.out.println("�ֶ�����gc��" + weakReference.get());
    }
}

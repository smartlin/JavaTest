package cn.lxh.java.JVM;


import cn.lxh.java.redis.springRedis.User;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * Created by starlin
 * on 2019/9/10 14:02.
 * ������
 * �����������������ã�Ҳ�����㶨���������ø����޷�ͨ�������û�ȡ��������󣬸���̸Ӱ�������������������ˡ�
 * ����������Ψһ�����þ����ö��н��ն��󼴽�������֪ͨ
 */
public class PhantomReferenceTest {
    public static void main(String[] args) {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference<User> phantomReference = new PhantomReference<User>(new User("zhangshan","123455"),referenceQueue);
        System.out.println("ʲôҲ��������ȡ��"+ phantomReference.get());
    }
}

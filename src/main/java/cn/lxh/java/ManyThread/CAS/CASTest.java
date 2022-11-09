package cn.lxh.java.ManyThread.CAS;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by starlin
 * on 2018/6/29 14:33.
 */
public class CASTest {
    private volatile int count = 0;

    private static final Unsafe UNSAFE = getUnsafe();
    private static final long offset;

    // ��� count ������ CASIntTest �е�ƫ�������ڴ��ַƫ�ƣ�
    static {
        try {
            offset = UNSAFE.objectFieldOffset(CASTest.class.getDeclaredField("count"));
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        }
    }

    // ͨ������ķ�ʽ��� Unsafe ��
    public static Unsafe getUnsafe() {
        Unsafe unsafe = null;
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return unsafe;
    }

    public void increment() {
        int previous = count;
        UNSAFE.compareAndSwapInt(this, offset, previous, previous + 1);
    }


    public static void main(String[] args) {
        CASTest casIntTest = new CASTest();
        casIntTest.increment();
        System.out.println(casIntTest.count);
    }
}

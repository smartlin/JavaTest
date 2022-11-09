package cn.lxh.java.ManyThread.ThreadLocal;

import java.util.Date;

/**
 * ʹ����InheritableThreadLocal���������߳���ȡ�ø��̼̳߳�������ֵ��
 * ���Բ�����дchildValue��Object parentValue�����������ļ̳е�ֵ
 */
public class InheriableThreadLocal {
    public static final InheritableThreadLocal<?> itl = new InheritableThreadLocal<Object>() {
        @Override
        protected Object initialValue() {
            return new Date().getTime();
        }

        @Override
        protected Object childValue(Object parentValue) {
            return parentValue + " which plus in subThread.";
        }
    };

    public static void main(String[] args) {
        System.out.println("Main: get value = " + itl.get());
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": get value = " + itl.get());
            }
        });
        a.start();
    }
}
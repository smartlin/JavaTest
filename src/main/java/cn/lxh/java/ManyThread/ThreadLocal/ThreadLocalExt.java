package cn.lxh.java.ManyThread.ThreadLocal;

import java.util.Date;

/**
 * Created by starlin
 * on 2016/08/21 15:19.
 * ��дinitialValue()�������Ϳ���ΪThreadLocal����ָ��һ����ʼ��ֵ
 */
public class ThreadLocalExt extends ThreadLocal {
    @Override
    protected Object initialValue(){
        return new Date().getTime();
    }
}

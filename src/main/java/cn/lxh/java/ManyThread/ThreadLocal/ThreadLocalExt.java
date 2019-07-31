package cn.lxh.java.ManyThread.ThreadLocal;

import java.util.Date;

/**
 * Created by starlin
 * on 2016/08/21 15:19.
 * 覆写initialValue()方法，就可以为ThreadLocal对象指定一个初始化值
 */
public class ThreadLocalExt extends ThreadLocal {
    @Override
    protected Object initialValue(){
        return new Date().getTime();
    }
}

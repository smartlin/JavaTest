package cn.lxh.java.GetFunction;

import java.lang.reflect.Method;

/**
 * 利用反射调用无返回值方法
 * Created by starlin
 * on 2015/09/29 22:35.
 */
class Message{
    public void print(String str){
        System.out.println(str);
    }
}
public class GetFunction {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("cn.lxh.java.GetFunction.Message");
        Object obj = cls.newInstance();
        Method met = cls.getMethod("print",String.class);
        met.invoke(obj,"Hello Workd");//主要使用的是invoke()
    }
}

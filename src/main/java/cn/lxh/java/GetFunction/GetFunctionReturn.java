package cn.lxh.java.GetFunction;

import java.lang.reflect.Method;

/**
 * 利用反射调用有返回值的方法
 * Created by starlin
 * on 2015/09/29 22:40.
 */
class Message1{
    public String echo(String str){
        return "echo:" + str;
    }
}
public class GetFunctionReturn {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("cn.lxh.java.GetFunction.Message1");
        Object obj = cls.newInstance();
        Method met = cls.getMethod("echo",String.class);
        Object val = met.invoke(obj,"Hello World");//有返回值的方法直接接受即可
        System.out.println(val);
    }
}

package cn.lxh.java.reflection;

import java.lang.reflect.Method;

/**
 * 利用反射实现setter,getter
 * author:1762
 * Date:2015/09/07
 * Time:22:53
 */
class Person1{
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class reflectDemo {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("cn.lxh.java.reflection.Person1");
        Object obj = cls.newInstance();//实例化对象
        Method setMthod = cls.getMethod("setName",String.class);//Method类反射实现类中的方法
        setMthod.invoke(obj,"张三");
        Method getMthod = cls.getMethod("getName");
        //System.out.println(setMthod.invoke(obj,"张三"));
        System.out.println(getMthod.invoke(obj));
    }
}

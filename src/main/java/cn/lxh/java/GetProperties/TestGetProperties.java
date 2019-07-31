package cn.lxh.java.GetProperties;

import java.lang.reflect.Field;

/**
 * 利用反射调用属性
 * Created by starlin
 * on 2015/09/30 9:48.
 */
class Dept{
    private String dname;
}
public class TestGetProperties {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("cn.lxh.java.GetProperties.Dept");
        Object obj = cls.newInstance();
        Field field = cls.getDeclaredField("dname");
        field.setAccessible(true);//通过此设置即时属性为私有，也可以访问，也就是取消封装
        field.set(obj,"信息部");
        System.out.println(field.get(obj));
    }
}

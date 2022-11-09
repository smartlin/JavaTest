package cn.lxh.java.reflection;

import java.lang.reflect.Field;

/**
 * 利用反射调用封装属性
 * author:1762
 * Date:2015/09/07
 * Time:23:02
 */
class Person2{
    private String name;
    private int age;
}

public class reflectDemo1 {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("com.study.lxh.reflection.Person2");
        Object obj = cls.newInstance();//实例化对象
        Field nameField = cls.getDeclaredField("name");//取得封装name属性 getDeclaredField取得封装属性
        nameField.setAccessible(true);//setAccessible取消封装
        nameField.set(obj, "张三");//对象.name = "张三"
        System.out.println(nameField.get(obj));

        Field ageField = cls.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(obj, 20);
        System.out.println(ageField.get(obj));
    }
}

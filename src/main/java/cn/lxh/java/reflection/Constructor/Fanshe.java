package cn.lxh.java.reflection.Constructor;

import java.lang.reflect.Constructor;

/**
 * 利用反射机制调用构造
 * author:1762
 * Date:2015/09/07
 * Time:21:18
 */
class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名：" + this.name + ",年龄：" + this.age ;
    }
}

public class Fanshe {
    public static void main(String[] args) throws Exception {
//        Class<?> cls = Class.forName("java.util.Date");
//        System.out.println(cls.getName());
//        Class<?> cls = Class.forName("cn.lxh.java.Constructor.Person");//包名.类名
//        Person per = (Person) cls.newInstance();//newInstance()返回Objec，向下转型为Person对象
//        System.out.println(per);
       // System.out.println(Class.forName("cn.lxh.java.reflection.Person").newInstance());


        Class<?> cls = Class.forName("cn.lxh.java.Constructor.Person");//包名.类名
        Constructor<?> con = cls.getConstructor(String.class, int.class);//根据构造方法的参数类型找到一个指定的构造方法getConstructor
        Person per = (Person) con.newInstance("张三", 20);
        System.out.println(per);
    }
}

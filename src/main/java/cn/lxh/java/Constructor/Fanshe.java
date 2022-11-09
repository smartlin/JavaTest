package cn.lxh.java.Constructor;

import java.lang.reflect.Constructor;

/**
 * ���÷�����Ƶ��ù���
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
        return "������" + this.name + ",���䣺" + this.age ;
    }
}

public class Fanshe {
    public static void main(String[] args) throws Exception {
//        Class<?> cls = Class.forName("java.util.Date");
//        System.out.println(cls.getName());
//        Class<?> cls = Class.forName("cn.lxh.java.Constructor.Person");//����.����
//        Person per = (Person) cls.newInstance();//newInstance()����Objec������ת��ΪPerson����
//        System.out.println(per);
       // System.out.println(Class.forName("cn.lxh.java.reflection.Person").newInstance());


        Class<?> cls = Class.forName("cn.lxh.java.Constructor.Person");//����.����
        Constructor<?> con = cls.getConstructor(String.class, int.class);//���ݹ��췽���Ĳ��������ҵ�һ��ָ���Ĺ��췽��getConstructor
        Person per = (Person) con.newInstance("����", 20);
        System.out.println(per);
    }
}

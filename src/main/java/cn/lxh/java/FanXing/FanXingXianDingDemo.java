package cn.lxh.java.FanXing;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 泛型的限定
 * ? extends E : 可以接收E类型或者E的子类型 上限
 * ? super E : 可以接收E类型或者E的父类型
 * Created by starlin
 * on 2015/10/29 20:59.
 */
class Person{
    private String name;
    private int age;
    public String getName(){
        return name;
    }
    public int getAge() {
        return age;
    }
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
}
class Student extends Person{
    public Student(String name, int age) {
        super(name, age);
    }
}
public class FanXingXianDingDemo {
    public static void main(String[] args) {
        ArrayList<Person> al = new ArrayList<Person>();
        al.add(new Person("lishi0",20));
        al.add(new Person("lishi1",21));
        al.add(new Person("lishi2",22));
        printColl(al);

        ArrayList<Student> als = new ArrayList<Student>();
        als.add(new Student("zhangsan",20));
        als.add(new Student("zhangsan1",20));
        als.add(new Student("zhangsan2",20));
        printColl(als);
    }
    public static void printColl(ArrayList< ? extends Person> al){//泛型的限定
        Iterator<? extends Person> it  = al.iterator();
        while (it.hasNext()){
            System.out.println(it.next().getName());
        }
    }
}

package cn.lxh.java.Framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ArrayList
 * Created by starlin
 * on 2015/10/28 21:20.
 */
class PersonDemo{
    private String name;
    private int age;
    public PersonDemo(String name,int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person){
            return false;
        }
        PersonDemo p = (PersonDemo)obj;
        return this.name.equals(p.name)&&this.age==p.age;
    }

    @Override
    public String toString() {
        return "PersonDemo{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
public class ArrayListDemo {
    public static void main(String[] args) {
        List<PersonDemo> al = new ArrayList<PersonDemo>();
        al.add(new PersonDemo("zhangsan1",20));
        al.add(new PersonDemo("zhangsan2",21));
        al.add(new PersonDemo("zhangsan3",22));
        al.add(new PersonDemo("zhangsan2",21));
        al.add(new PersonDemo("zhangsan5",24));
        al.add(new PersonDemo("zhangsan3",22));
        System.out.println("去除重复前：" + al);
        al = Single(al);
//        System.out.println("去除重复后：" + al);
        Iterator<PersonDemo> it = al.iterator();
        while (it.hasNext()){
//            PersonDemo p = (PersonDemo) it.next();
            PersonDemo str = it.next();
//            System.out.println( p.getName() + "======" + p.getAge());
            System.out.println("去除重复后：" + str);
        }
    }
    public static List Single(List list){//去除集合中的重复
        List newal = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            if(!newal.contains(obj)){
                newal.add(obj);
            }
        }
        return newal;
    }
}

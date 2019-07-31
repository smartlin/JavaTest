package cn.lxh.java.Framework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map集合练习
 * Created by starlin
 * on 2015/10/30 11:37.
 */
class Student implements Comparable<Student>{
    private String name;
    private int age;
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return this.name + ":" + this.age;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age*34;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Student)){
            return false;
        }
        Student s = (Student)obj;
        return this.name.equals(s.name)&&this.age == s.age;
    }

    @Override
    public int compareTo(Student o) {
        int num = new Integer(this.age).compareTo(new Integer(o.age));
        if(num ==0){
            return this.name.compareTo(o.name);
        }
        return num;
    }
}
public class MapDemo2 {
    public static void main(String[] args) {
        Map<Student,String> map = new HashMap<Student,String>();
        map.put(new Student("lishi01",20),"BeiJing");
        map.put(new Student("lishi01",20),"TianJing");
        map.put(new Student("lishi02",22),"ShangHai");
        map.put(new Student("lishi03",23),"NanJing");
        //1.使用EntrySet取数据
        Set<Map.Entry<Student,String>> set = map.entrySet();
        Iterator<Map.Entry<Student,String>> it = set.iterator();
        while (it.hasNext()){
            Map.Entry<Student,String> entrySet = it.next();
            Student stu = entrySet.getKey();
            String add = entrySet.getValue();
            System.out.println(stu + "=======>" + add);
        }
        //2.使用keySet取数据
        Set<Student> set1 = map.keySet();
        Iterator<Student> it1 = set1.iterator();
        while (it1.hasNext()){
            Student stu1 = it1.next();
            String add1 = map.get(stu1);
            System.out.println(stu1 + "=====>" + add1);
        }
    }
}

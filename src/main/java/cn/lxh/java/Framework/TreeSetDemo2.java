package cn.lxh.java.Framework;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet第二种排序方式：当元素自身不具备比较性，或者具备的比较性不是所需要的
 * Created by starlin
 * on 2015/10/29 13:34.
 */
class Person5 implements Comparable{
    private String name;
    private int age;
    public Person5(String name,int age){
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
    public int compareTo(Object o) {
        return 1;//返回1，取出来的数据按照存进去的数据顺序，返回-1 则是倒序，返回0 元素唯一
    }

    @Override
    public String toString() {
        return "Person5{" +
                "name=" + name +
                ", age='" + age + '\'' +
                '}';
    }
}

class MyCompare implements Comparator{//增加按照姓名排序
    @Override
    public int compare(Object o1, Object o2) {
        Person5 p1 = (Person5)o1;
        Person5 p2 = (Person5)o2;
        int num = p1.getName().compareTo(p2.getName());
        if(num==0){
            return new Integer(p1.getAge()).compareTo(p2.getAge());
        }
        return num;
    }
}
public class TreeSetDemo2 {
    public static void main(String[] args) {
        TreeSet<Person5> treeSet = new TreeSet<Person5>(new MyCompare());//通过姓名来排序，不需要重新修改原来的方法
//        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person5("lishi05",20));
        treeSet.add(new Person5("lishi02",23));
        treeSet.add(new Person5("lishi02",23));
        treeSet.add(new Person5("lishi03",22));
        treeSet.add(new Person5("lishi04",24));
        Iterator<Person5> it = treeSet.iterator();
        while(it.hasNext()){
            Person5 st = it.next();
            System.out.println(st);
        }
    }
}

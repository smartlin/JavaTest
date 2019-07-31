package cn.lxh.java.Framework;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet可以对Set集合中的元素进行排序，底层数据结构是二叉树
 * TreeSet保证元素唯一性的依据compareTo方法返回0
 * TreeSet排序的第一种方式，让元素自身具备比较性，元素实现Comparable接口，覆盖compareTo方法
 * Created by starlin
 * on 2015/10/29 13:13.
 */
class Person4 implements Comparable{
    private String name;
    private int age;
    public Person4(String name,int age){
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
        return "Person4{" +
                "name=" + name +
                ", age='" + age + '\'' +
                '}';
    }
}
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Person4> treeSet = new TreeSet<Person4>();
        treeSet.add(new Person4("lishi01",20));
        treeSet.add(new Person4("lishi02",23));
        treeSet.add(new Person4("lishi03",22));
        treeSet.add(new Person4("lishi03",22));
        treeSet.add(new Person4("lishi04",24));
        Iterator<Person4> it = treeSet.iterator();
        while(it.hasNext()){
            Person4 st = it.next();
            System.out.println(st);
        }
    }
}

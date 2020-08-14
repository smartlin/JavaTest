package cn.lxh.java.Clone;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by starlin
 * on 2018/9/20 23:23.
 * 浅克隆演示
 */
public class Person implements Cloneable, Serializable {
    private String name;
    private Person father;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Person father) {
        this.name = name;
        this.father = father;
    }

    /**
     * 浅拷贝
     * @return
     */
    @Override
    public Person clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        /**
         * 1.重新覆写对象实例部分的拷贝，实现深拷贝
         * 2.如果没有重写对象实例部分的拷贝，那么大儿子和小儿子的父亲会引用同一个父亲，
         * 只要任意修改一下父亲，另外一个就会被修改
         */
        //p.setFather(new Person(p.getFather().getName()));
        return p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        //定义父亲
        Person father = new Person("父亲");
        //定义大儿子
        Person son1 = new Person("大儿子", father);
        //定义小儿子，通过克隆的方式
        Person son2 = son1.clone();
        //定义小儿子的name
        son2.setName("小儿子");
        //给小儿子，找个干爹
        son2.getFather().setName("干爹");

        System.out.println(son1.getName() + " 的父亲是 " + son1.getFather().getName());
        System.out.println(son2.getName() + " 的父亲是 " + son2.getFather().getName());

        Integer in1 = new Integer(10);
        System.out.println(in1.hashCode());
        Integer in2 = new Integer(10);
        System.out.println(in2.hashCode());

        Person[] p1 = {new Person("starlin")};
        Person[] p2 = Arrays.copyOf(p1,p1.length);
        p1[0].setName("smartlin");
        System.out.println("p1--->" + p1[0].getName());
        System.out.println("p2--->" + p2[0].getName());
    }
}

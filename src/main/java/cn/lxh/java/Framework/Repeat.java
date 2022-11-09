package cn.lxh.java.Framework;

import java.util.HashSet;
import java.util.Set;

/**
 * 对象的重复判断 一定要是Hashcode 和equals
 * author:1762
 * Date:2015/09/12
 * Time:19:33
 */
class Person1{
    private String name;
    private int age;
    public Person1(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名：" + this.name + ",年龄：" + this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person1 person1 = (Person1) o;

        if (age != person1.age) return false;
        return !(name != null ? !name.equals(person1.name) : person1.name != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}

public class Repeat {
    public static void main(String[] args) throws Exception{
        Set<Person1> all = new HashSet<Person1>();
        all.add(new Person1("张三", 20));
        all.add(new Person1("李四",10));
        all.add(new Person1("李四",10));
        all.add(new Person1("王五",19));
        all.add(new Person1("赵六",11));
        System.out.println(all);
    }
}

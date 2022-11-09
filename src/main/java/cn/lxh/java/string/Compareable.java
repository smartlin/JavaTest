package cn.lxh.java.string;

import java.util.Arrays;

/**
 * 对象的大小比较 一定使用Compareable接口
 * author:1762
 * Date:2015/09/06
 * Time:22:44
 */
class Person implements Comparable<Person>{
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public  String toString() {
        return ("姓名：" + this.name + ",年龄：" + this.age );
    }


    @Override
    public int compareTo(Person o) {
        if(this.age > o.age){
            return 1;
        }else if(this.age < o.age){
            return -1;
        }
        return this.name.compareTo(o.name);//年龄相等比较姓名
    }
}

public class Compareable {
    public static void main(String[] args   ) {
        Person p [] = new Person[] {
                new Person("张三",20),
                new Person("李四",25),
                new Person("王五02",18),
                new Person("王五01",18)
        };
        Arrays.sort(p);//自动调用compareTo方法，只需要复写compareTo方法即可
        System.out.println(Arrays.toString(p));
//        for(int i = 0 ;i < p.length ; i++){
//            System.out.println(p[i]);
//        }
    }

}

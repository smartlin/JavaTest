package cn.lxh.java.Framework;

import java.util.ArrayList;
import java.util.List;

/**
 * List集合操作
 * List集合特有方法 增：add() addAll() 删：remove()  改set() 查：get() sublist()
 * 在遍历集合中用listIterator()进行增删改查
 * author:1762
 * Date:2015/09/12
 * Time:17:26
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
        return "姓名：" + this.name + ",年龄：" + this.age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Person)){
            return false;
        }
        Person per = (Person) obj;
        if(per.name.equals(this.name) && (per.age == this.age)){
            return true;
        }
        return false;
    }

    //@Override
    //public int hashCode() {
    //    return Objects.hash(name, age);
    //}
}

public class LsitDemo {
    public static void main(String[] args){
        List<Person> all = new ArrayList<Person>();
        System.out.println(all.isEmpty());
        all.add(new Person("张三", 20));//add 增加操作
        all.add(new Person("李四",20));
        all.add(new Person("王五",20));
        System.out.println(all.get(0));
        System.out.println(all.subList(0,1));
        //System.out.println(all.isEmpty());//是否为空isEmpty
        //System.out.println(all.remove(new Person("王五", 20)));//remove
        //System.out.println(all.contains(new Person("李四",20)));//contains
        //System.out.println(all.get(1));
    }

}

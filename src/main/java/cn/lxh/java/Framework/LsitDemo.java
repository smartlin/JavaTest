package cn.lxh.java.Framework;

import java.util.ArrayList;
import java.util.List;

/**
 * List���ϲ���
 * List�������з��� ����add() addAll() ɾ��remove()  ��set() �飺get() sublist()
 * �ڱ�����������listIterator()������ɾ�Ĳ�
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
        return "������" + this.name + ",���䣺" + this.age;
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
        all.add(new Person("����", 20));//add ���Ӳ���
        all.add(new Person("����",20));
        all.add(new Person("����",20));
        System.out.println(all.get(0));
        System.out.println(all.subList(0,1));
        //System.out.println(all.isEmpty());//�Ƿ�Ϊ��isEmpty
        //System.out.println(all.remove(new Person("����", 20)));//remove
        //System.out.println(all.contains(new Person("����",20)));//contains
        //System.out.println(all.get(1));
    }

}

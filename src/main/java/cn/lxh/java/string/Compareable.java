package cn.lxh.java.string;

import java.util.Arrays;

/**
 * ����Ĵ�С�Ƚ� һ��ʹ��Compareable�ӿ�
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
        return ("������" + this.name + ",���䣺" + this.age );
    }


    @Override
    public int compareTo(Person o) {
        if(this.age > o.age){
            return 1;
        }else if(this.age < o.age){
            return -1;
        }
        return this.name.compareTo(o.name);//������ȱȽ�����
    }
}

public class Compareable {
    public static void main(String[] args   ) {
        Person p [] = new Person[] {
                new Person("����",20),
                new Person("����",25),
                new Person("����02",18),
                new Person("����01",18)
        };
        Arrays.sort(p);//�Զ�����compareTo������ֻ��Ҫ��дcompareTo��������
        System.out.println(Arrays.toString(p));
//        for(int i = 0 ;i < p.length ; i++){
//            System.out.println(p[i]);
//        }
    }

}

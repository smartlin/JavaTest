package cn.lxh.java.Framework;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet�ڶ�������ʽ����Ԫ�������߱��Ƚ��ԣ����߾߱��ıȽ��Բ�������Ҫ��
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
        return 1;//����1��ȡ���������ݰ��մ��ȥ������˳�򣬷���-1 ���ǵ��򣬷���0 Ԫ��Ψһ
    }

    @Override
    public String toString() {
        return "Person5{" +
                "name=" + name +
                ", age='" + age + '\'' +
                '}';
    }
}

class MyCompare implements Comparator{//���Ӱ�����������
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
        TreeSet<Person5> treeSet = new TreeSet<Person5>(new MyCompare());//ͨ�����������򣬲���Ҫ�����޸�ԭ���ķ���
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

package cn.lxh.java.Framework;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet���Զ�Set�����е�Ԫ�ؽ������򣬵ײ����ݽṹ�Ƕ�����
 * TreeSet��֤Ԫ��Ψһ�Ե�����compareTo��������0
 * TreeSet����ĵ�һ�ַ�ʽ����Ԫ������߱��Ƚ��ԣ�Ԫ��ʵ��Comparable�ӿڣ�����compareTo����
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
        return 1;//����1��ȡ���������ݰ��մ��ȥ������˳�򣬷���-1 ���ǵ��򣬷���0 Ԫ��Ψһ
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

package cn.lxh.java.Clone;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by starlin
 * on 2018/9/20 23:23.
 * ǳ��¡��ʾ
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
     * ǳ����
     * @return
     */
    @Override
    public Person clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        /**
         * 1.���¸�д����ʵ�����ֵĿ�����ʵ�����
         * 2.���û����д����ʵ�����ֵĿ�������ô����Ӻ�С���ӵĸ��׻�����ͬһ�����ף�
         * ֻҪ�����޸�һ�¸��ף�����һ���ͻᱻ�޸�
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
        //���常��
        Person father = new Person("����");
        //��������
        Person son1 = new Person("�����", father);
        //����С���ӣ�ͨ����¡�ķ�ʽ
        Person son2 = son1.clone();
        //����С���ӵ�name
        son2.setName("С����");
        //��С���ӣ��Ҹ��ɵ�
        son2.getFather().setName("�ɵ�");

        System.out.println(son1.getName() + " �ĸ����� " + son1.getFather().getName());
        System.out.println(son2.getName() + " �ĸ����� " + son2.getFather().getName());

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

package cn.lxh.java.Extends;

/**
 * �̳У������������г�ʼ��ʱ������Ĺ��췽��Ҳ������
 * ��Ϊ����Ĺ��췽����Ĭ�ϵ�һ�����и�super()��������ڵ�һ��
 * Created by starlin
 * on 2015/10/22 20:45.
 */
class Person{
    public Person(){
        System.out.println("Person");
    }
}
class Students extends Person{
    public Students(){
        System.out.println("student");
    }
}
public class ExtendsDemo {
    public static void main(String[] args) {
        Students s = new Students();
    }
}

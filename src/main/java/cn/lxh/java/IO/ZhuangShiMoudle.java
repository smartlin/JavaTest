package cn.lxh.java.IO;

/**
 * װ�����ģʽ
 * ���������Ķ�����й�������ʱ�����Զ����࣬�����ж����룬���������࣬���ṩ���ܼ�ǿ
 * ��ô�Զ���ĸ����Ϊװ���࣬װ����ͨ����ͨ�����췽�����ձ�װ�εĶ���
 * Created by starlin
 * on 2015/11/02 21:33.
 */
class Person{
    private String name;
    public void print(){
        System.out.println("�Է�");
    }
}
class SuperPerson{//װ����
    private Person p;
    public SuperPerson(Person p){
        this.p = p;
    }
    public void print(){
        System.out.println("��θ��");
        p.print();
        System.out.println("���");
    }
}
public class ZhuangShiMoudle {
    public static void main(String[] args) {
        Person p = new Person();
   //     p.print();
        SuperPerson sp = new SuperPerson(p);
        sp.print();
    }
}

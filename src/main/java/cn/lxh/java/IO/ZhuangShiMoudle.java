package cn.lxh.java.IO;

/**
 * 装饰设计模式
 * 相对已有类的对象进行功能增加时，可以定义类，将已有对象传入，基于已有类，并提供功能加强
 * 那么自定义的该类称为装饰类，装饰类通常会通过构造方法接收被装饰的对象
 * Created by starlin
 * on 2015/11/02 21:33.
 */
class Person{
    private String name;
    public void print(){
        System.out.println("吃饭");
    }
}
class SuperPerson{//装饰类
    private Person p;
    public SuperPerson(Person p){
        this.p = p;
    }
    public void print(){
        System.out.println("开胃菜");
        p.print();
        System.out.println("甜点");
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

package cn.lxh.java.lombok;

import lombok.Data;

/**
 * Created by starlin
 * on 2020/9/21 16:14.
 */
@Data
public class Person {
    private int id;
    private String name;

    public Person(){}

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Person p1 = new Person(1, "zhangsan");
        Person p2 = new Person(1, "lishi");
        System.out.println(p1.equals(p2));
    }
    //
    //class Company extends Person {
    //    /**
    //     * ¹«Ë¾
    //     */
    //    private String company;
    //
    //    public Company(int id, String name,String company) {
    //        super(id, name);
    //        this.company = company;
    //    }
    //}
}

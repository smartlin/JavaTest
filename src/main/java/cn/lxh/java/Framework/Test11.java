package cn.lxh.java.Framework;

import java.util.HashSet;

/**
 * Created by starlin
 * on 2018/9/21 16:30.
 */
public class Test11 {
    public static void main(String[] args) {
        Person p1 = new Person("aa",10);
        Person p2 = new Person("aa",10);
        HashSet<Person> hashSet = new HashSet();
        hashSet.add(p1);
        hashSet.add(p2);
        System.out.println(hashSet);
    }
}

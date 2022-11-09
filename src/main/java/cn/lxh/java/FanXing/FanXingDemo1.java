package cn.lxh.java.FanXing;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by starlin
 * on 2015/10/29 21:48.
 */
class Person1{
    private String name;
    public Person1(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
class Student1 extends Person1{

    public Student1(String name) {
        super(name);
    }
}
class Worker extends Person1{

    public Worker(String name) {
        super(name);
    }
}
class Com implements Comparator<Person1>{//通过泛型，无需定义多个子类的比较器

    @Override
    public int compare(Person1 o1, Person1 o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
public class FanXingDemo1 {
    public static void main(String[] args) {
        TreeSet<Student1> ts = new TreeSet<Student1>(new Com());
        ts.add(new Student1("stu---lishi1"));
        ts.add(new Student1("stu---lishi3"));
        ts.add(new Student1("stu---lishi2"));
        Iterator<Student1> it = ts.iterator();
        while (it.hasNext()){
            System.out.println(it.next().getName());
        }

        TreeSet<Worker> ts1 = new TreeSet<Worker>(new Com());
        ts1.add(new Worker("wor---lishi1"));
        ts1.add(new Worker("wor---lishi3"));
        ts1.add(new Worker("wor---lishi2"));
        Iterator<Worker> it1 = ts1.iterator();
        while (it1.hasNext()){
            System.out.println(it1.next().getName());
        }
    }
}

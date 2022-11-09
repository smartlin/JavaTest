package cn.lxh.java.Framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 只能使用Compatator比较器
 * Created by starlin
 * on 2017/02/27 13:58.
 */
public class ComparableComparatorNoFinalTest implements Comparable<ComparableComparatorNoFinalTest> {
    private int age;
    private String name;

    public ComparableComparatorNoFinalTest(String name , int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ComparableComparatorTest{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(ComparableComparatorNoFinalTest o) {
        return this.age - o.age;
    }

    public static void main(String[] args) {
        ComparableComparatorNoFinalTest comparableComparatorTest1 = new ComparableComparatorNoFinalTest("zzh",18);
        ComparableComparatorNoFinalTest comparableComparatorTest2 = new ComparableComparatorNoFinalTest("jj",17);
        ComparableComparatorNoFinalTest comparableComparatorTest3 = new ComparableComparatorNoFinalTest("qq",19);
        List<ComparableComparatorNoFinalTest> list = new ArrayList<ComparableComparatorNoFinalTest>();
        list.add(comparableComparatorTest1);
        list.add(comparableComparatorTest2);
        list.add(comparableComparatorTest3);
        System.out.println("排序前------------>"+list);
        Collections.sort(list);
        System.out.println("排序后----------->"+list);
    }


}

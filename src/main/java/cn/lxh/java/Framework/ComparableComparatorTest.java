package cn.lxh.java.Framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 该类用final修饰后，无法用implements Comparable
 * 只能使用Compatator比较器
 * Created by starlin
 * on 2017/02/27 13:58.
 */
public final class ComparableComparatorTest{
    private int age;
    private String name;

    public ComparableComparatorTest(String name ,int age) {
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

    public static void main(String[] args) {
        ComparableComparatorTest comparableComparatorTest1 = new ComparableComparatorTest("zzh",18);
        ComparableComparatorTest comparableComparatorTest2 = new ComparableComparatorTest("jj",17);
        ComparableComparatorTest comparableComparatorTest3 = new ComparableComparatorTest("qq",19);
        List<ComparableComparatorTest> list = new ArrayList<ComparableComparatorTest>();
        list.add(comparableComparatorTest1);
        list.add(comparableComparatorTest2);
        list.add(comparableComparatorTest3);
        System.out.println("排序前------------>"+list);
        Collections.sort(list, new Comparator<ComparableComparatorTest>() {
            @Override
            public int compare(ComparableComparatorTest o1, ComparableComparatorTest o2) {
                if(o1 == null || o2 == null){
                    return 0;
                }
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println("排序后----------->"+list);
    }
}

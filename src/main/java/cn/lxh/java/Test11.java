package cn.lxh.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by starlin
 * on 2018/3/8 10:55.
 */
public class Test11 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);

        List<Integer> list2 = list1.subList(0, list1.size());
        list1.add(3);

        System.out.println("list1 size  " + list1.size());
        System.out.println("list2 size  " + list2.size());
    }
}

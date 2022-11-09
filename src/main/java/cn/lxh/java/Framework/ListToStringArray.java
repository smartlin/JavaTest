package cn.lxh.java.Framework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by starlin
 * on 2016/04/19 15:23.
 */
public class ListToStringArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        String[] str = new String[list.size()];
        list.toArray(str);

        System.out.println(str.length);
    }
}

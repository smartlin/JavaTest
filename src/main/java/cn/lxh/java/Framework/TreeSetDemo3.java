package cn.lxh.java.Framework;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet练习，实现字符串长度排序
 * Created by starlin
 * on 2015/10/29 15:49.
 */
class MyCompare1 implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String)o1;
        String s2 = (String)o2;
        //如下判断会导致长度一样的字符串无法排序
//        if(s1.length() > s2.length()){
//            return 1;
//        }
//        if(s1.length() < s2.length()){
//            return -1;
//        }
        int num = new Integer(s1.length()).compareTo(s2.length());
        if(num==0){
            return s1.compareTo(s2);
        }
        return num;
    }
}
public class TreeSetDemo3 {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<String>(new MyCompare1());
        treeSet.add("abcd");
        treeSet.add("cc");
        treeSet.add("cba");
        treeSet.add("aaa");
        treeSet.add("z");
        treeSet.add("hahaha");
        Iterator<String> it = treeSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}

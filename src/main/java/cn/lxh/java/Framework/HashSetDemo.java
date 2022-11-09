package cn.lxh.java.Framework;

import java.util.HashSet;
import java.util.Set;

/**
 * Set 不允许重复的子接口
 * HashSet数据结构是哈希表，线程是非同步
 * 保证元素唯一性的原理：判断元素的HashCode值是否相同
 * 如果相同，还会继续判断元素的equals方法，是否为true
 * author:1762
 * Date:2015/09/12
 * Time:17:46
 */
public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> all = new HashSet<String>(); //HashSet不能保存重复数据，保存的数据没有任何顺序，使用的时候以HashSet为主
       // Set<String> all = new TreeSet<String>(); //TreeSet 保存的数据有序
        all.add("HELLO");
        all.add("HELLO");
        all.add("world");
        all.add("outehr");
        all.add("starlin");
        System.out.println(all);
    }
}

package cn.lxh.java.Framework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 使用Iterator 输出Map集合
 * 1.使用Map集合中的entrySet()方法将Map集合变成Set集合，而此时Set集合中的每一个元素都是Map.Entry接口实例
 * 2.利用Set接口中的iterator()方法取得Iterator接口对象，同时Iterator中操作的类型依然是Map.Entry
 * 3.利用Iterator进行迭代输出，并且利用getKey()和getValue()方法取出数据
 * author:1762
 * Date:2015/09/12
 * Time:20:58
 */
public class IteratorToMap {
    public static void main(String[] args) {
        Map<Integer,String> m = new HashMap<Integer, String>();
        m.put(1,"张三");
        m.put(2,"李四");
        m.put(3,"王五");
        Set<Map.Entry<Integer,String>> set = m.entrySet();
        Iterator<Map.Entry<Integer,String>> it = set.iterator();
        while (it.hasNext()){
            Map.Entry<Integer,String> me = it.next();
            System.out.println(me.getKey() +  "--->" + me.getValue());
        }
    }
}

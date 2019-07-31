package cn.lxh.java.Framework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map集合：该集合存储键值对，而且要保证键值的唯一性
 * Map集合添加：put(K key,V value)  putAll(Map<? extends K,? extends V> m)
 * put添加元素，如果出现相同的键，那么后添加的键值会覆盖原有的键值，并put方法会返回被覆盖的值
 * Map集合删除：clear()  remove(Object key)
 * Map集合判断：containsValue(Object value)  containsKey(Object key) isEmpty()
 * Map集合获取：get(Object key)  values()  size()  entrySet()  keySet()
 * Map集合取出原理：将Map集合转换为Set集合，在通过迭代器取出Iterator
 * Map中的HashMap、 Hashtable、TreeMap,
 *          |---Hashtable：底层是哈希表数据结构，不允许存入null键null值，该结合是线程同步，效率低
 *          |---HashMap：底层是哈希表数据结构，允许存入null键null值，该结合是线程同步，效率高
 *          |---TreeMap：底层是二叉树数据结构，线程不同步，可以用于map集合中的键进行排序
 * Created by starlin
 * on 2015/10/29 22:23.
 */
public class MapDemo1 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("zhangsan","20");
        map.put("zhangsan1","21");
        map.put("zhangsan2","22");
        map.put("zhangsan3","23");
        //利用KeySet取出所有键值
        Set<String> set = map.keySet();//keySet()
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String key = it.next();
            System.out.println(key);
            String value = map.get(key);
            System.out.println(value);
        }
    }
}

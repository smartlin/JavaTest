package cn.lxh.java.Framework;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by starlin
 * on 2018/9/19 17:10.
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Map<String,String> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("a", "val_a");
        linkedHashMap.put("b", "val_b");
        linkedHashMap.put("c", "val_c");
        linkedHashMap.get("a");
        Iterator<Map.Entry<String, String>> iterator = linkedHashMap.entrySet().iterator();
        System.out.println("不设置accessOrder");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        linkedHashMap = new LinkedHashMap(10,0.75f,true);
        linkedHashMap.put("a", "val_a");
        linkedHashMap.put("b", "val_b");
        linkedHashMap.put("c", "val_c");

        linkedHashMap.get("a");
        linkedHashMap.get("b");
        linkedHashMap.put("d", "val_d");
        iterator = linkedHashMap.entrySet().iterator();
        System.out.println("设置accessOrder为true");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

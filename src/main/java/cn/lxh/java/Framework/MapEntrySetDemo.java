package cn.lxh.java.Framework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map集合取出数据的第二种方法EntrySet()
 * Created by starlin
 * on 2015/10/30 10:39.
 */
public class MapEntrySetDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("zhangsan","20");
        map.put("zhangsan1","21");
        map.put("zhangsan2","22");
        map.put("zhangsan3","23");
        Set<Map.Entry<String,String>> st = map.entrySet();//entrySet()
        Iterator<Map.Entry<String,String>> it = st.iterator();
        while(it.hasNext()){
            Map.Entry<String,String> me = it.next();
            String key = me.getKey();
            String value = me.getValue();
            System.out.println(key + ":" + value);
        }
    }
}

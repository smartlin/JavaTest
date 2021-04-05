package cn.lxh.java.redis;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by starlin
 * on 2021/3/8 17:55.
 * 实现redis里面的LRU算法
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private final int CACHE_SIZE;

    public LRUCache(int cacheSize) {
        super((int) Math.ceil(cacheSize / 0.75 + 1),0.75f,true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > CACHE_SIZE;
    }
}

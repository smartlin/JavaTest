package cn.lxh.java.ManyThread.ProducerAndConsumer;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by starlin
 * on 2018/5/10 13:33.
 */
public class ConcureentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap concureentHashMap = new ConcurrentHashMap();
        int ssize = 1;
        int sshift = 0;
        // 计算并行级别 ssize，因为要保持并行级别是 2 的 n 次方
        while (ssize < 16) {
            ++sshift;
            ssize <<= 1;
        }
    }
}

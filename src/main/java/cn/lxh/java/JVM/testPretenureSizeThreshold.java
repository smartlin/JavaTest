package cn.lxh.java.JVM;

/**
 * Created by starlin
 * on 2018/9/4 15:22.
 * vm参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 */
public class testPretenureSizeThreshold {
    private static final int _1MB = 1024*1024;

    public static void main(String[] args) {
        byte[] allocation;
        //直接分配到老年代
        allocation = new byte[4 * _1MB];
    }
}

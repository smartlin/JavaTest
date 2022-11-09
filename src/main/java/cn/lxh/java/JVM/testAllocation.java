package cn.lxh.java.JVM;

/**
 * Created by starlin
 * on 2018/9/4 14:24.
 * vm参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 */
public class testAllocation {
    private static final int _1MB = 1024*1024;

    /**
     * 尝试分配3个2MB大小和1个4MB大小的对象，在运行时通过-Xms20M、-Xmx20M、-Xmn10M这3个参数限制了Java堆大小为20M，不可扩展，
     * 其中10M分配给新生代，剩下的10M分配给老年代
     * -XX:SurvivorRatio=8决定了新生代中Eden区与一个Survivor区的空间比例是8:1
     *
     * @param args
     */
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
}

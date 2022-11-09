package cn.lxh.java.JVM;

/**
 * Created by starlin
 * on 2018/9/4 14:24.
 * vm������-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 */
public class testAllocation {
    private static final int _1MB = 1024*1024;

    /**
     * ���Է���3��2MB��С��1��4MB��С�Ķ���������ʱͨ��-Xms20M��-Xmx20M��-Xmn10M��3������������Java�Ѵ�СΪ20M��������չ��
     * ����10M�������������ʣ�µ�10M����������
     * -XX:SurvivorRatio=8��������������Eden����һ��Survivor���Ŀռ������8:1
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

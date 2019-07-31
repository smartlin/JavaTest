package cn.lxh.java.JVM;

/**
 * Created by starlin
 * on 2018/9/4 15:50.
 * vm������-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1����-XX:MaxTenuringThreshold=15
 */
public class testTenuringThreshold {
    private static final int _1MB = 1024*1024;

    /**
     * ���Է���3��2MB��С��1��4MB��С�Ķ���������ʱͨ��-Xms20M��-Xmx20M��-Xmn10M��3������������Java�Ѵ�СΪ20M��������չ��
     * ����10M�������������ʣ�µ�10M����������
     * -XX:SurvivorRatio=8��������������Eden����һ��Survivor���Ŀռ������8:1
     *
     * @param args
     */
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3;
        allocation1 = new byte[_1MB / 4];
        //ʲôʱ����������ȡ����-XX:MaxTenuringThreshold������
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
}

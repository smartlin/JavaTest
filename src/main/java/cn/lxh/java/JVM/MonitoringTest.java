package cn.lxh.java.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * �ڴ���
 * Created by starlin
 * on 2018/8/25 16:57.
 * vm options
 * -Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class MonitoringTest {
    static class OOMObject {
        public byte[] placeHolder = new byte[64 * 1024];
    }
    //��δ���������ǣ���64KB/50������ٶ���Java����������ݣ�һ��1000�Σ�����JConsole�ġ��ڴ桱ҳǩ���м��ӣ��۲����ߺ���״ָʾͼ�ı仯
    public static void fileHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fileHeap(10000);
    }
}

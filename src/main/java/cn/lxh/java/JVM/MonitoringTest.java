package cn.lxh.java.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * 内存监控
 * Created by starlin
 * on 2018/8/25 16:57.
 * vm options
 * -Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class MonitoringTest {
    static class OOMObject {
        public byte[] placeHolder = new byte[64 * 1024];
    }
    //这段代码的作用是，以64KB/50毫秒的速度往Java堆中填充数据，一共1000次，是用JConsole的“内存”页签进行监视，观察曲线和柱状指示图的变化
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

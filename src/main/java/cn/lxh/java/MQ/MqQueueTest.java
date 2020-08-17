package cn.lxh.java.MQ;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by starlin
 * on 2020/8/17 16:38.
 * 使用 Queue 的子类 LinkedList 实现了自定义消息队列
 * 消息以先进先出进行消费
 */
public class MqQueueTest {
    private static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        producer();
        conusmer();
    }

    /**
     * 消费者
     */
    private static void conusmer() {
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    /**
     * 生产者
     */
    public static void producer() {
        queue.add("消息1");
        queue.add("消息2");
        queue.add("消息3");
    }
}

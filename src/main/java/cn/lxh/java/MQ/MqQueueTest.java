package cn.lxh.java.MQ;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by starlin
 * on 2020/8/17 16:38.
 * ʹ�� Queue ������ LinkedList ʵ�����Զ�����Ϣ����
 * ��Ϣ���Ƚ��ȳ���������
 */
public class MqQueueTest {
    private static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        producer();
        conusmer();
    }

    /**
     * ������
     */
    private static void conusmer() {
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    /**
     * ������
     */
    public static void producer() {
        queue.add("��Ϣ1");
        queue.add("��Ϣ2");
        queue.add("��Ϣ3");
    }
}

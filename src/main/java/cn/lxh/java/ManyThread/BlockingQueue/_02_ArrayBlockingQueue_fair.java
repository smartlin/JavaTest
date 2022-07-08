package cn.lxh.java.ManyThread.BlockingQueue;


import cn.lxh.java.ManyThread.CompletableFuture.SmallTool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ArrayBlockingQueue ��ƽ����
 * ��������е�������������Զ��������������ձ�
 * ����Ĺ�ƽ���������������߹�ƽ��������Ҳ�ǹ�ƽ��
 * ����һ����ƽ���У�������������һ����ȡ����������������һ���ȷŽ�ȥ
 */
public class _02_ArrayBlockingQueue_fair {
    private static BlockingQueue<String> shaobingQueue = new ArrayBlockingQueue<>(3,true);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                SmallTool.printTimeAndThread("�����ձ�");
                String shaobing = shaobingQueue.poll(1, TimeUnit.SECONDS);
                String tag = shaobing == null ? "�ټ�, �Ժ�����" : "���ձ���";
                SmallTool.printTimeAndThread(tag);
            } catch (InterruptedException e) {
                SmallTool.printTimeAndThread("���ж�" + e.getMessage());
            }
        }, "����").start();

        SmallTool.sleepMillis(100);     // ģ�������ȵ�

        new Thread(() -> {
            try {
                SmallTool.printTimeAndThread("�����ձ�");
                String shaobing = shaobingQueue.poll(1, TimeUnit.SECONDS);
                String tag = shaobing == null ? "��, ����������ڵ�̯��! " : "���ձ���";
                SmallTool.printTimeAndThread(tag);
            } catch (InterruptedException e) {
                SmallTool.printTimeAndThread("���ж�" + e.getMessage());
            }
        }, "����").start();

        shaobingQueue.offer("֥���ձ�");
    }
}

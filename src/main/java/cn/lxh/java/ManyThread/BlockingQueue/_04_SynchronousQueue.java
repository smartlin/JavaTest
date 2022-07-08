package cn.lxh.java.ManyThread.BlockingQueue;


import cn.lxh.java.ManyThread.CompletableFuture.SmallTool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * SynchronousQueue֧�ֶ������ߣ��������ߣ����л���
 * ���������Ƿ�ƽ
 */
public class _04_SynchronousQueue {
    public static void main(String[] args) {
        BlockingQueue<String> shaobingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                SmallTool.printTimeAndThread("׼����ʼ���ձ�");
                shaobingQueue.put("֥���ձ�1��");
                SmallTool.printTimeAndThread("����ȥ�˵�1���ձ�");

                SmallTool.sleepMillis(2000);    // ��Ϣ������ �ټ�����

                shaobingQueue.put("֥���ձ�2��");
                SmallTool.printTimeAndThread("����ȥ�˵�2���ձ�");
            } catch (InterruptedException e) {
                SmallTool.printTimeAndThread("���ж�" + e.getMessage());
            }
        }, "С��").start();

        new Thread(() -> {
            try {
                SmallTool.sleepMillis(1000);    // ���������ȵ�һ��

                SmallTool.printTimeAndThread("����" + shaobingQueue.take());
                SmallTool.printTimeAndThread("˲����꣬������");
                SmallTool.printTimeAndThread("����" + shaobingQueue.take());
            } catch (InterruptedException e) {
                SmallTool.printTimeAndThread("���ж�" + e.getMessage());
            }
        }, "����").start();

    }
}

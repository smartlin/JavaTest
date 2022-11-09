package cn.lxh.java.ManyThread.BlockingQueue;


import cn.lxh.java.ManyThread.CompletableFuture.SmallTool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * LinkedBlockingQueue �ǹ�ƽ�ģ�֧��ͬʱ��ȡ��Դ��������2����takeLock��putLock��
 * ����Ĵ������еĽ���ǲ�ȷ����
 * �п��ܺ��������ı����������ձ�
 */
public class _01_LinkedBlockingQueue_unfair {

    public static void main(String[] args) {
        BlockingQueue<String> shaobingQueue = new LinkedBlockingQueue<>(3);

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
                String tag = shaobing == null ? "��, ��̯��! " : "���ձ���";
                SmallTool.printTimeAndThread(tag);
            } catch (InterruptedException e) {
                SmallTool.printTimeAndThread("���ж�" + e.getMessage());
            }
        }, "����").start();

        shaobingQueue.offer("֥���ձ�");
    }
}

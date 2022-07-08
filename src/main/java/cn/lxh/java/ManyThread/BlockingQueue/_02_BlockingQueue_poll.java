package cn.lxh.java.ManyThread.BlockingQueue;


import cn.lxh.java.ManyThread.CompletableFuture.SmallTool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * LinkedBlockingQueue poll������ʾ
 * ������С���������ձ���·����׼��ȥ���ձ�������С��ͻȻ���²��ܼ������ձ��ˣ����ʱ��·�˼ײ�����һֱ�ȴ�
 * ���ʱ�����poll���������ϵȴ���ʱ��
 * �����ȴ��õ���ֵΪnull�����������еĽ��Ϊnull��
 * LinkedBlockingQueue���в��ò���nullֵ�����׳�NPE�쳣��Դ�����н���
 */
public class _02_BlockingQueue_poll {
    public static void main(String[] args) {
        BlockingQueue<String> shaobingQueue = new LinkedBlockingQueue<>(3);

        Thread xiaoBai = new Thread(() -> {
            SmallTool.printTimeAndThread("С�� ��ʰ������׼������");
            SmallTool.printTimeAndThread("С�� �ӵ��绰 ��������");

        });

        Thread roadPeopleA = new Thread(() -> {
            SmallTool.printTimeAndThread("·�˼� �����ձ�");
            try {
                String shaobing = shaobingQueue.poll(2, TimeUnit.SECONDS);
                SmallTool.printTimeAndThread("·�˼� �����ձ�: " + shaobing);
            } catch (InterruptedException e) {
                SmallTool.printTimeAndThread("·�˼� ���ж�" + e.getMessage());
            }
        });

        xiaoBai.start();
        try {
            Thread.sleep(10);   // �ȵ�С����ʰһ�£�����·�˼׳���
        } catch (InterruptedException e) {
            SmallTool.printTimeAndThread("���߳� ���ж�" + e.getMessage());
        }
        roadPeopleA.start();
    }
}

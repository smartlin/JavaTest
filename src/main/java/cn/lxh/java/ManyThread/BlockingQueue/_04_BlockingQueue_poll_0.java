package cn.lxh.java.ManyThread.BlockingQueue;

import cn.lxh.java.ManyThread.CompletableFuture.SmallTool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * poll�����κβ����ķ������൱��poll�����������������ʱ�䳤��Ϊ0
 * poll���������ķ����������׳�InterruptedException�쳣
 */
public class _04_BlockingQueue_poll_0 {
    public static void main(String[] args) {
        BlockingQueue<String> shaobingQueue = new LinkedBlockingQueue<>(3);

        Thread xiaoBai = new Thread(() -> {
            SmallTool.printTimeAndThread("С�� ��ʰ������׼������");
            SmallTool.printTimeAndThread("С�� �ӵ��绰 ��������");
        });

        Thread roadPeopleA = new Thread(() -> {
            SmallTool.printTimeAndThread("·�˼� �����ձ�");
            String shaobing = shaobingQueue.poll();
            if (shaobing == null) {
                SmallTool.printTimeAndThread("·�˼� û�����ձ�");
            } else {
                SmallTool.printTimeAndThread("·�˼� �����ձ�: " + shaobing);
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

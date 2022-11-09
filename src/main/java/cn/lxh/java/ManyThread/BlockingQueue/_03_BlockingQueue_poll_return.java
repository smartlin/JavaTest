package cn.lxh.java.ManyThread.BlockingQueue;

import cn.lxh.java.ManyThread.CompletableFuture.SmallTool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * �����ȴ��õ���ֵΪnull
 * �������ж�poll��ֵ�Ƿ�Ϊnull
 */
public class _03_BlockingQueue_poll_return {
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
                if (shaobing == null) {
                    SmallTool.printTimeAndThread("·�˼� û�����ձ�");
                } else {
                    SmallTool.printTimeAndThread("·�˼� �����ձ�: " + shaobing);
                }
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

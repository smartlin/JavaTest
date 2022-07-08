package cn.lxh.java.ManyThread.BlockingQueue;

import cn.lxh.java.ManyThread.CompletableFuture.SmallTool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/**
 * ������
 * 1�����г���Ϊ3
 * 2��С�׺ͳ�ʦA ÿ��ֻ��5���ձ�
 * 3��·�˼׺��� ÿ�˹���5���ձ�
 * 4�������ձ��϶���������
 * ���ÿ��Ƕ��̣߳����ÿ��Ǳ������������������������Ⱦ
 */
public class _07_LinkedBlockingQueue_Scenes {
    public static void main(String[] args) {
        BlockingQueue<String> shaobingQueue = new LinkedBlockingQueue<>(3);

        List<String> xiaoBaiMsg = new LinkedList<>();
        List<String> chefAMsg = new LinkedList<>();
        List<String> roadPeopleAMsg = new LinkedList<>();
        List<String> roadPeopleBMsg = new LinkedList<>();

        Thread xiaoBai = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String shaobing = String.format("С�׵� ��%d���ձ�", i + 1);
                try {
                    shaobingQueue.put(shaobing);
                } catch (InterruptedException e) {
                    SmallTool.printTimeAndThread("С�ױ��ж�" + e.getMessage());
                }
                xiaoBaiMsg.add(String.format("%d С�������� [%s]", System.currentTimeMillis(), shaobing));
            }
        });
        Thread chushiA = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String shaobing = String.format("��ʦA�� ��%d���ձ�", i + 1);
                try {
                    shaobingQueue.put(shaobing);
                } catch (InterruptedException e) {
                    SmallTool.printTimeAndThread("��ʦA���ж�" + e.getMessage());
                }
                chefAMsg.add(String.format("%d ��ʦA������ [%s]", System.currentTimeMillis(), shaobing));
            }
        });

        Thread roadPeopleA = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String shaobing = null;
                try {
                    shaobing = shaobingQueue.take();
                } catch (InterruptedException e) {
                    SmallTool.printTimeAndThread("·�˼ױ��ж�" + e.getMessage());
                }
                roadPeopleAMsg.add(String.format("%d  ·�˼� ���� [%s]", System.currentTimeMillis(), shaobing));
            }
        });

        Thread roadPeopleB = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String shaobing = null;
                try {
                    shaobing = shaobingQueue.take();
                } catch (InterruptedException e) {
                    SmallTool.printTimeAndThread("·���ұ��ж�" + e.getMessage());
                }
                roadPeopleBMsg.add(String.format("%d  ·���� ���� [%s]", System.currentTimeMillis(), shaobing));
            }
        });

        xiaoBai.start();
        chushiA.start();
        roadPeopleA.start();
        roadPeopleB.start();

        try {
            xiaoBai.join();
            chushiA.join();
            roadPeopleA.join();
            roadPeopleB.join();
        } catch (InterruptedException e) {
            SmallTool.printTimeAndThread("join �����ж�" + e.getMessage());
        }

        System.out.println(xiaoBaiMsg.stream().collect(Collectors.joining("\n")));
        System.out.println(chefAMsg.stream().collect(Collectors.joining("\n")));
        System.out.println("--------------------------");   // �ָ���
        System.out.println(roadPeopleAMsg.stream().collect(Collectors.joining("\n")));
        System.out.println(roadPeopleBMsg.stream().collect(Collectors.joining("\n")));
    }
}

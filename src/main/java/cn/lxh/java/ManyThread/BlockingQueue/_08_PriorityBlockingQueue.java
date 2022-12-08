package cn.lxh.java.ManyThread.BlockingQueue;

import cn.lxh.java.ManyThread.CompletableFuture.SmallTool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by starlin
 * on 2022/12/7 17:59.
 * ������С������3���ձ�������ζ����Ϊ�óԵġ�һ�㡢�ѳԵ����֣��˿�С�׹��������ձ���ʹ��PriorityBlockingQueue��������֤�˿�ÿ�ζ��������ζ����õ��ձ�[DELICIOUS]
 * ȡ�����Ľ���ǰ��������˳�򣬵��Ǳ������еĽ���������
 * PriorityBlockingQueue�����ȼ����У�PriorityBlockingQueue���е�Ԫ����Ҫʵ��Comparable�ӿڣ���ɶ��е�����
 */
public class _08_PriorityBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<PanCake> blockingQueue = new PriorityBlockingQueue<PanCake>(
                5
        );
        Thread xb = new Thread(() -> {
            blockingQueue.add(new PanCake(Flavor.EDIBLE));
            SmallTool.printTimeAndThread("���õ�1���ձ�");
            blockingQueue.add(new PanCake(Flavor.DELICIOUS));
            SmallTool.printTimeAndThread("���õ�2���ձ�");
            blockingQueue.add(new PanCake(Flavor.UNPALATABLE));
            SmallTool.printTimeAndThread("���õ�3���ձ�");
        }, "С��");

        xb.start();

        try {
            xb.join();     // ��С��˳������ 3���ձ�
        } catch (InterruptedException e) {
            SmallTool.printTimeAndThread("���ж�" + e.getMessage());
        }

        new Thread(() -> {
            SmallTool.printTimeAndThread("���ձ�" + blockingQueue.poll().flavor);
        }, "����").start();
    }

    private static class PanCake implements Comparable<PanCake> {
        private Flavor flavor;
        public PanCake(Flavor flavor) {
            this.flavor = flavor;
        }
        @Override
        public int compareTo(PanCake o) {
            return this.flavor.compareTo(Flavor.EDIBLE);
        }
    }
}


enum Flavor {
    DELICIOUS, // �ó�
    EDIBLE,     // һ��(���¿�)
    UNPALATABLE // �ѳ�
}

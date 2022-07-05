package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * Created by starlin
 * on 2022/7/1 14:50.
 * CompletableFuture����
 */
public class CompletableFutureTest2 {
    /**
     * ����2���ڳ���1�У���ʦҪ���˺��������ڸó����У��ѳ�ʦ�����Ľ�������Ա������
     * �̣߳����ӷ���Ա�̣߳���ʦ�̣߳�С���߳�
     * @param args
     */
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("�������");
        SmallTool.printTimeAndThread("��ʼ���");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("��ʦ����");
            SmallTool.sleepMillis(1000);
            CompletableFuture<String> race = CompletableFuture.supplyAsync(() -> {
                SmallTool.printTimeAndThread("����Ա��");
                SmallTool.sleepMillis(1000);
                return " + �׷��Ѻ�";
            });
            return "���ѳ���" + race.join();
        });

        SmallTool.printTimeAndThread("�Ȳ˵Ĺ����У�����Ϸ");
        //�����join()����Ҳ���Ի���get()������Ψһ������get()������Ҫ�����쳣
        SmallTool.printTimeAndThread(String.format("%s,�˷��Ѻã�����",cf1.join()));
    }
}

package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * Created by starlin
 * on 2022/6/15 18:29.
 * CompletableFuture����
 */
public class CompletableFutureTest1 {
    /**
     * ����1��С�׽�������Է�����ʦ���ˣ��Ȳ˺õĹ�����������Ϸ���˺��ˣ�����
     * �̣߳�����Ա�̡߳�С���߳�
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SmallTool.printTimeAndThread("�������");
        SmallTool.printTimeAndThread("��ʼ���");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("��ʦ����");
            SmallTool.sleepMillis(200);
            SmallTool.printTimeAndThread("��ʦ��");
            SmallTool.sleepMillis(100);
            return "�˺��׷��Ѿ�����";
        });
        SmallTool.printTimeAndThread("�Ȳ˵Ĺ����У�����Ϸ");
        //�����join()����Ҳ���Ի���get()������Ψһ������get()������Ҫ�����쳣
        SmallTool.printTimeAndThread(String.format("%s,�˷��Ѻã�����",cf1.join()));
    }

}

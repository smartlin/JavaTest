package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * Created by starlin
 * on 2022/7/1 19:23.
 */
public class ApplyToEitherDemo {
    /**
     * ������С�״Ӳ������극��׼�����������ؼң�����·����������ѡ��700·��800·������һ·�������ȵ������ϳ�
     * applyToEither���þ�����һ����������ɣ�����������еı���firstBusCome�������������ķ���ֵ
     * ������ĳ����У����п��ܷ����쳣������ʹ��exceptionally�������쳣��
     * @param args
     */
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("���극���߳�����");
        SmallTool.printTimeAndThread("�ȴ�700·����800·����������");
        CompletableFuture<String> bus = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("700·���������ڸ���");
            SmallTool.sleepMillis(100);
            return "700·����������";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("800·���������ڸ���");
            SmallTool.sleepMillis(200);
            return "800·����������";
        }), firstBusCome -> {
            SmallTool.printTimeAndThread(firstBusCome);
            if (firstBusCome.startsWith("700")) {
                throw new RuntimeException("700·����������·��������");
            }
            return firstBusCome;
        }).exceptionally(e ->{
            SmallTool.printTimeAndThread(e.getMessage());
            SmallTool.printTimeAndThread("С�׽��˳��⳵");
            return "���⳵����";
        });

        SmallTool.printTimeAndThread(String.format("%s,С�������ؼ�", bus.join()));
    }
}

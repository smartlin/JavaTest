package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * Created by starlin
 * on 2022/7/1 14:50.
 * CompletableFuture����
 */
public class ThenCombineDemo {
    /**
     * ����4��ǰ��3�������У�������ǰ���õģ����ڵĳ����Ƿ�û�����ã���С�׽����������ʦ��ʼ���˺ͷ���Ա��ʼ���� ��ͬʱ���еģ������Ƕ���ɺ�С�ײſ�ʼ�Է�
     * ����ʹ��supplyAsync(),ͬʱ���� ��ʦ���� �� ����Ա���� �����첽����
     * CompletableFuture�ṩ������һ��д��thenCombine
     * @param args
     */
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("�������");
        SmallTool.printTimeAndThread("��ʼ���");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("��ʦ����");
            SmallTool.sleepMillis(1000);
            return "���ѳ���";
            //thenCompose�� ǰһ��������ɣ����ˣ�����������񣨴򷹣����ܽ���
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            SmallTool.printTimeAndThread("����Ա����");
            SmallTool.sleepMillis(1000);
            return "�׷�";
        }),(dish,rice) -> {
            SmallTool.printTimeAndThread("����Ա��");
            SmallTool.sleepMillis(1000);
            return String.format("%s + %s ����", dish, rice);
        });

        SmallTool.printTimeAndThread("�Ȳ˵Ĺ����У�����Ϸ");
        //�����join()����Ҳ���Ի���get()������Ψһ������get()������Ҫ�����쳣
        SmallTool.printTimeAndThread(String.format("%s,�˷��Ѻã�����",cf1.join()));
    }
}

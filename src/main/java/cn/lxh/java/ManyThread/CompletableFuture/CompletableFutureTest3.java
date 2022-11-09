package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * Created by starlin
 * on 2022/7/1 14:50.
 * CompletableFuture����
 */
public class CompletableFutureTest3 {
    /**
     * ����3����ʦ�ͷ���Ա���ǵ������̣߳��Ѳ˺ͷ��������Ժ���һ���С��
     * ǰ�᣺��ʦ���� �ڷ���Ա�� ǰ��
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
        }).thenCompose(dish -> CompletableFuture.supplyAsync(()->{
            SmallTool.printTimeAndThread("����Ա��");
            SmallTool.sleepMillis(1000);
            return dish + " + �׷�";
        }));

        SmallTool.printTimeAndThread("�Ȳ˵Ĺ����У�����Ϸ");
        //�����join()����Ҳ���Ի���get()������Ψһ������get()������Ҫ�����쳣
        SmallTool.printTimeAndThread(String.format("%s,�˷��Ѻã�����",cf1.join()));
    }
}

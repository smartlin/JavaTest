package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by starlin
 * on 2022/6/15 18:29.
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> cf = new CompletableFuture<>();
        cf.complete("����");
        //�������������ȴ��������
        String result = cf.get();
        System.out.println("cf get ����ֵ" + result);

        //System.out.println("===============�ύ����runAsync()������supplyAsync()����===================start================");
        //�ύ����runAsync���޷���ֵVoid
        //CompletableFuture.runAsync��..���������һ�� Runnable �ӿڣ�
        //ʹ���� Java 8 �� lambda ���ʽ��д�����Ͷ���һ�� Runnable �����ǵȼ۵�
        CompletableFuture<Void> cf1 = CompletableFuture.runAsync(() ->{
            System.out.println("ģ��������������");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        //���߳��������ȴ��������
        System.out.println("cf1 get ����ֵ" + cf1.get());

        //�ύ����supplyAsync���з���ֵ
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() ->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "����ִ�����";
        });
        String result2 = cf2.get();
        System.out.println("cf2 get ����ֵ��" + cf2.get());

        // ����CompletableFuture����������ͨ��thenApply��thenAccept��thenCompose�ȷ�����ʵ��
        //��Ԫ��������ͨ��thenCombine�Ȼص���ʵ��
        //��Ԫ��������ͨ��allOf��anyOf������ʵ�֣������ǵ���Ҫ�������ȫ�����ʱʹ��allOf������������е�����һ����ɼ���ʱʹ��anyOf

        //System.out.println("===============��ʽ����thenRun��thenAccept ��thenApply===================start================");

        // thenRun ���������һ���޲������޷���ֵ�ķ��� ��Ϊ Consumer
        CompletableFuture<Void> cf3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "���Խ��";
        }).thenRun(() ->{
            System.out.println("���������");
        });

        // thenAccept t ���������һ���в������޷���ֵ�ķ�������Ϊ Consumer
        CompletableFuture<Void> cf4 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "���Խ��";
        }).thenAccept(System.out::println);

        //System.out.println("===============��ʽ����thenRun��thenAccept ��thenApply===================end================");
    }
    //����thenApply
    public void testThenApply() {
        // thenApply ���������һ���в������з���ֵ�ķ�������Ϊ Function
        CompletableFuture<String> cf5 = CompletableFuture.supplyAsync(() ->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "���Խ��";
        }).thenApply(result2 -> {
            return result2 + "after + thenApply";
        });
    }
}

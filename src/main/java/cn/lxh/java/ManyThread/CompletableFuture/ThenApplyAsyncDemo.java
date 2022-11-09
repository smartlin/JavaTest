package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * Created by starlin
 * on 2022/7/1 14:50.
 * CompletableFuture����
 */
public class ThenApplyAsyncDemo {
    /**
     * ����5��С�׳Ժ÷�������Ա�պ�Ǯ����Ҫ������һ������Ա����Ʊ
     * ����ʹ��supplyAsync(),ͬʱ���� ��ʦ���� �� ����Ա���� �����첽����
     * CompletableFuture�ṩ������һ��д��thenCombine
     * @param args
     */
    public static void main(String[] args) {
        SmallTool.printTimeAndThread("С�׳Ժ���");
        SmallTool.printTimeAndThread("С�׽��ˡ���Ҫ�󿪷�Ʊ");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("����Ա1���տ�500Ԫ");
            SmallTool.sleepMillis(1000);
            return "500";
        }).thenApplyAsync(money ->{
            SmallTool.printTimeAndThread(String.format("����Ա2������Ʊ����� %sԪ", money));
            SmallTool.sleepMillis(200);
            return String.format("%sԪ��Ʊ", money);
        });

        SmallTool.printTimeAndThread("С�׽ӵ绰");
        SmallTool.printTimeAndThread(String.format("С���õ�%s,׼���ؼ�",cf1.join()));
    }
}

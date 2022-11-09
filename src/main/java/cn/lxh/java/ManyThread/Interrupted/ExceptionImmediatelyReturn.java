package cn.lxh.java.ManyThread.Interrupted;

import cn.lxh.java.ManyThread.CompletableFuture.SmallTool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * �����������쳣������
 * ���û�����쳣
 *  A �� B ����ִ��
 *  B ִ�����ִ�� C
 *
 *  ��������쳣�����̷����쳣
 *  ��������3��ע�ͣ�ģ�� �����쳣�����
 */
public class ExceptionImmediatelyReturn {
    public static void main(String[] args) {

        try {
            String result = getABCResult();
            SmallTool.printTimeAndThread(result);
        } catch (Exception e) {
            SmallTool.printTimeAndThread("�����쳣 " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String getABCResult() {
        CompletableFuture<String> a = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("start A");
            SmallTool.sleepMillis(1000);
//            if (true) {
//                throw new RuntimeException("a error");
//            }
            SmallTool.printTimeAndThread("end A");
            return "A";
        });

        CompletableFuture<String> bAndC = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("start B");
            SmallTool.sleepMillis(2000);
//            if (true) {
//                throw new RuntimeException("b error");
//            }
            SmallTool.printTimeAndThread("end B");
            return "B";
        }).thenCompose(resultB -> CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("start C");
            SmallTool.sleepMillis(1000);
//            if (true) {
//                throw new RuntimeException("c error");
//            }
            SmallTool.printTimeAndThread("end C");
            return resultB + " C";
        }));


        List<CompletableFuture> cfList = new LinkedList<>();
        cfList.add(a);
        cfList.add(bAndC);

        while (cfList.size() > 0) {
            CompletableFuture.anyOf(cfList.toArray(new CompletableFuture[cfList.size()])).join();
            cfList.removeIf(completableFuture -> completableFuture.isDone());
        }

        /**
         * ƴװ���
         */
        return "����ִ����� -->" + a.join() + " " + bAndC.join();
    }


}
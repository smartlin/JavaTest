package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

/**
 * Created by starlin
 * on 2022/7/4 11:41.
 * Completable��������
 * ������С�׽������Է�������12���ˣ�������Ҫ12������Ҫ�����
 * һ̨�������ܺû���CPU�����йأ���Ȼ���ڴ棬������Ӳ��֮����豸Ҳ�й�ϵ
 * ���Ե�����8����16�̣߳�һ˲�����ͬʱ���������������16��
 */
public class CompletableTerribleDemo {
    public static void main(String[] args) {
        //testError();
        //testCorrect();
        testStream();
    }

    /**
     * ����ʾ��������һ���첽�����ʱ��һ��һ����ȥjoin��ֱ�Ӱ��첽�������˴���
     * ����ʱ�䣺10102ms
     */
    public static void testError() {
        SmallTool.printTimeAndThread("С�׺����ѽ���������");
        long startTime = System.currentTimeMillis();
        List<Dish> dishes = new ArrayList<>();
        //���
        for (int i = 0; i < 10; i++) {
            Dish dish = new Dish("��" + i, 1);
            dishes.add(dish);
        }
        //����
        for (Dish dish : dishes) {
            CompletableFuture.runAsync(() -> dish.make()).join();
        }
        long endTime = System.currentTimeMillis();

        SmallTool.printTimeAndThread("�˶������ˣ����Գ��� " + (endTime - startTime));
    }


      /**
       * ��ȷʾ��������һ���첽�����ʱ���ȷ���list���ȴ���������ִ�����
       * ����ʱ�䣺1078ms
       */
    public static void testCorrect() {
        SmallTool.printTimeAndThread("С�׺����ѽ���������");
        long startTime = System.currentTimeMillis();
        List<Dish> dishes = new ArrayList<>();
        //���
        for (int i = 0; i < 10; i++) {
            Dish dish = new Dish("��" + i, 1);
            dishes.add(dish);
        }
        //����
        List<CompletableFuture> completableFutureList = new ArrayList<>();
        for (Dish dish : dishes) {
            CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> dish.make());
            completableFutureList.add(cf);
        }
        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[completableFutureList.size()])).join();
        long endTime = System.currentTimeMillis();

        SmallTool.printTimeAndThread("�˶������ˣ����Գ��� " + (endTime - startTime));
    }

    public static void testStream() {
        SmallTool.printTimeAndThread("С�׺����ѽ���������");
        long startTime = System.currentTimeMillis();
        CompletableFuture[] dishes = IntStream.rangeClosed(1, 15)
                .mapToObj(i -> new Dish("��" + i, 1))
                .map(dish -> CompletableFuture.runAsync(dish::make))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(dishes).join();

        long endTime = System.currentTimeMillis();
        SmallTool.printTimeAndThread("�˶������ˣ����Գ��� " + (endTime - startTime));
    }
}

package cn.lxh.java.ManyThread.Callable;

import java.util.concurrent.*;

public class CompletableFutureTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CompletableFuture<String> xiaoMei = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "-С�����ҿ�ʼ��ױ�ˣ������ҽ��㡣");
            try {
                int time = ThreadLocalRandom.current().nextInt(5);
                TimeUnit.SECONDS.sleep(time);
                System.out.println(Thread.currentThread().getName() + "-С��,��ױ��ʱ:" + time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "С������ױ����ˡ�";
        }, executorService);

        CompletableFuture<String> xiaoGuai = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "-С�ԣ��ҿ�ʼ��ױ�ˣ������ҽ��㡣");
            try {
                int time = ThreadLocalRandom.current().nextInt(5);
                TimeUnit.SECONDS.sleep(time);
                System.out.println(Thread.currentThread().getName() + "-С��,��ױ��ʱ:" + time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "С�ԣ���ױ����ˡ�";
        }, executorService);

        CompletableFuture<Object> girl = CompletableFuture.anyOf(xiaoMei, xiaoGuai);
        girl.thenAccept(result -> {
            System.out.println("�ҿ������˭�Ȼ����� = " + result);
        });

        CompletableFuture<String> eatChooseOne = girl.thenApplyAsync((result) -> {
            try {
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result + "��������,����ȥ��ɳ��С�԰�!";
        }, executorService);

        CompletableFuture<String> eatChooseTwo = girl.thenApplyAsync((result) -> {
            try {
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result + "��������,����ȥ�Ի��˼���!";
        }, executorService);

        CompletableFuture.allOf(eatChooseOne, eatChooseTwo).thenAccept(result -> {
            System.out.println("���ս����" + result);
        });
    }
}
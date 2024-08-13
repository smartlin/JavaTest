package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.*;

/**
 * Created by starlin
 * on 2024/8/13 14:46.
 * ��Ҫ�������������������̳߳ظ��룬������������ͬ���̳߳أ�����ѭ���������µ�����
 * doGet����������ͨ��supplyAsync��threadPool1�����̣߳������ڲ�����������threadPool1�����̡߳�threadPool1��СΪ10��
 * ��ͬһʱ����10�����󵽴��threadPool1�������������������߳�ʱ�������������Ŷӣ�
 * ���Ǹ�������������������������ʱ����������ò����̣߳��������޷���ɡ����߳�ִ��cf1.join()��������״̬��������Զ�޷��ָ�
 */
public class WrongCompletableFutureDemo {
    public static void main(String[] args) {
        doGet();
    }

    public static Object doGet() {
        ExecutorService threadPool1 = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));

        CompletableFuture cf1 = CompletableFuture.supplyAsync(() -> {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("child");
                return "child";
            }, threadPool1).join();//������
        }, threadPool1);// ������
        return cf1.join();
    }
}

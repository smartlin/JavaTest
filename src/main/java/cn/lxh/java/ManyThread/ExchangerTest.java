package cn.lxh.java.ManyThread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchanger��һ�������̼߳�Э���Ĺ�����,�̼߳佻������
 * �����ͬ���㣬�����߳̿��Խ����˴˵����ݡ�
 * �������߳�ͨ��exchange�����������ݣ������һ���߳���ִ��exchange()����������һֱ�ȴ��ڶ����߳�Ҳִ��exchange������
 * �������̶߳�����ͬ����ʱ���������߳̾Ϳ��Խ������ݣ������ֳ��������������ݴ��ݸ��Է�
 * ��������߳���һ��û��ִ��exchange(V x)���������һֱ�ȴ���
 * ��������������������������һֱ�ȴ�������ʹ��exchange(V x, long timeout, TimeUnit unit)�������ȴ�ʱ��
 * Created by starlin
 * on 2017/02/27 22:29.
 */
public class ExchangerTest {
    private static final Exchanger<String> EXCHANGER = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String A = "I am A";
                try{
                    String B = EXCHANGER.exchange(A);
                    System.out.println("In 1-" + Thread.currentThread().getName() + ": " + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String B = "I am B";
                try{
                    String A = EXCHANGER.exchange(B);
                    System.out.println("In 2-" + Thread.currentThread().getName() +": " + A);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.shutdown();
    }
}

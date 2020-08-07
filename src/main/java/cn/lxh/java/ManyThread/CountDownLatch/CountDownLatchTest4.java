package cn.lxh.java.ManyThread.CountDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by starlin
 * on 2019/9/21 22:17.
 * ����CountDownLatch ģ���˶�Ա��������������ƽ��ʱ��
 */
public class CountDownLatchTest4 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //�μ��ܲ�����
        int num = 10;
        //����ǹֻ��һ��
        CountDownLatch begin = new CountDownLatch(1);
        //�����ܲ��ж���
        CountDownLatch end = new CountDownLatch(num);
        //ÿ���ܲ���һ���������൱��һ���߳�
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        //��¼�����ɼ�
        List<Future<Integer>> futures = new ArrayList<>();
        //�ܲ��߾�λ�������̴߳��ڵȴ�״̬
        for (int i = 0; i < num; i++) {
            futures.add(executorService.submit(new Runner(begin, end)));
        }
        //����ǹ�����ܲ��߿�ʼ�ܲ�
        begin.countDown();
        //�ȴ������ܲ��߽���
        end.await();
        //ͳ���ܷ�
        int count = 0;
        for (Future<Integer> f : futures) {
            count += f.get();
        }
        System.out.println("ƽ��ʱ�䣺 {}" + count);
    }
}

class Runner implements Callable<Integer> {

    //��ʼ�ź�
    private CountDownLatch begin;

    //�����ź�
    private CountDownLatch end;

    public Runner(CountDownLatch begin, CountDownLatch end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        //�ܲ��ɼ�
        int score = new Random().nextInt(25);
        //�ȴ�����ָ��
        begin.await();
        //�ܲ���
        TimeUnit.MILLISECONDS.sleep(score);
        //�ܲ�����
        end.countDown();
        return score;
    }
}

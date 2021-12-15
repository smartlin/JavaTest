package cn.lxh.java.ManyThread.Callable;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by starlin
 * on 2021/4/19 23:12.
 * ListenableFuture ��� Future �ǲ���Ҫ֪�� ִ�н��������¾Ϳ��Խ� �ɹ�����ʧ�ܵ�ҵ����� ͨ���ص��ķ�ʽ Ԥ�񣬴����ĺô������첽������Ҫ������ǰ�̣߳��Ӷ��������ϵͳ��������
 * Future ��Ҫͨ�� get() ����������ǰ�̣߳��ڻ�ȡ�̵߳�ִ�н�����ٸ���ִ�н����д��ص�ҵ�����
 */
public class SubmitTest {
    public static void main(String[] args) {
        ThreadPoolTaskExecutor executorService = new ThreadPoolTaskExecutor();
        executorService.setCorePoolSize(1);
        executorService.setMaxPoolSize(1);
        executorService.initialize();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Future<Boolean> future = executorService.submit(() -> {
                try {
                    // ��Ϣ5���룬ģ��ִ��
                    TimeUnit.MILLISECONDS.sleep(5);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            });

            try {
                // �������ķ�ʽ��ȡִ�н��
                Boolean result = future.get();
                // logger.info(String.format("ִ�н����%s", result));
                // ��Ϣ3����ģ���ȡ��ִ�н����Ĳ���
                TimeUnit.MILLISECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println(String.format("�ܽ��ʱ��%s", System.currentTimeMillis() - start));
    }
}

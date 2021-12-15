package cn.lxh.java.ManyThread.Callable;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.TimeUnit;

/**
 * Created by starlin
 * on 2021/4/19 23:10.
 * ListenableFuture ��� Future �ǲ���Ҫ֪�� ִ�н��������¾Ϳ��Խ� �ɹ�����ʧ�ܵ�ҵ����� ͨ���ص��ķ�ʽ Ԥ�񣬴����ĺô������첽������Ҫ������ǰ�̣߳��Ӷ��������ϵͳ��������
 * Future ��Ҫͨ�� get() ����������ǰ�̣߳��ڻ�ȡ�̵߳�ִ�н�����ٸ���ִ�н����д��ص�ҵ�����
 */
@Slf4j
public class SubmitListenableTest {
    public static void main(String[] args) {
        ThreadPoolTaskExecutor executorService = new ThreadPoolTaskExecutor();
        executorService.setCorePoolSize(1);
        executorService.setMaxPoolSize(1);
        executorService.initialize();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            ListenableFuture<Boolean> asyncResult = executorService.submitListenable(() -> {

                // ��Ϣ5���룬ģ��ִ��
                TimeUnit.MILLISECONDS.sleep(5);
                //throw new RuntimeException("�����쳣");
                return true;

            });
            asyncResult.addCallback(data -> {
                try {
                    // ��Ϣ3����ģ���ȡ��ִ�н����Ĳ���
                    TimeUnit.MILLISECONDS.sleep(3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, ex -> log.info("**�쳣��Ϣ**��{}", ExceptionUtils.getThrowableList(ex)));
        }
        System.out.println(String.format("�ܽ��ʱ��%s", System.currentTimeMillis() - start));
    }
}

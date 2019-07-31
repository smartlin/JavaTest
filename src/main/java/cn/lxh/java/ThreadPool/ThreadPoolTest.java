package cn.lxh.java.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by starlin
 * on 2018/4/12 21:33.
 */
public class ThreadPoolTest {
    //newFixedThreadPool����һ��ָ�������߳��������̳߳ء�
    //ÿ���ύһ������ʹ���һ�������̣߳���������߳������ﵽ�̳߳س�ʼ������������ύ��������뵽�ض����С�
    public static void newFixedThreadPoolTest() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    //newCachedThreadPool����һ���ɻ�����̳߳ء��������͵��̳߳��ص��ǣ�
    //1).�����̵߳Ĵ�����������û������(��ʵҲ�����Ƶ�,��ĿΪInterger. MAX_VALUE), �������������̳߳�������̡߳�
    //2).�����ʱ��û�����̳߳����ύ���񣬼���������߳̿�����ָ����ʱ��(Ĭ��Ϊ1����)����ù����߳̽��Զ���ֹ����ֹ����������ύ���µ��������̳߳����´���һ�������߳�
    public static void newCachedThreadPoolTest() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }

    //newSingleThreadExecutor����һ�����̻߳���Executor����ֻ����Ψһ�Ĺ������߳���ִ�������������߳��쳣������������һ��ȡ��������֤˳��ִ��(�Ҿ��������������ɫ)��
    // �������߳������ص��ǿɱ�֤˳���ִ�и������񣬲��������������ʱ�䲻���ж���߳��ǻ��
    public static void newSingleThreadExecutor() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    //newScheduleThreadPool����һ���������̳߳أ�����֧�ֶ�ʱ���Լ������Ե�����ִ�У�������Timer��
    public static void newScheduleThreadPool() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
    }

}

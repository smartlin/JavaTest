package cn.lxh.java.ManyThread.join;

import java.util.concurrent.TimeUnit;

/**
 * Created by starlin
 * on 2017/02/25 22:58.
 * ���һ���߳�Aִ����thread.join()��䣬�京���ǣ���ǰ�߳�A�ȴ�thread�߳���ֹ֮��Ŵ�thread.join()���ء�
 * join��synchronized�������ǣ�join���ڲ�ʹ��wait()�������еȴ�����synchronized�ؼ���ʹ�õ��ǡ��������������Ϊͬ����
 * join�ṩ����������ʵ�ַ�����join(long millis)��join(long millis, int nanos)��
 * ����ȴ��೤ʱ����˳��ȴ�(�ͷ���)���˳��ȴ�֮�󻹿��Լ������С�
 * �ڲ���ͨ��wait������ʵ�ֵ�
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("method main begin");
        Thread thread = new Thread(new Runnable() {
            int i = 0;
            @Override
            public void run() {
                while (true){
                    System.out.println(i++);
                    try{
                        TimeUnit.MILLISECONDS.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        thread.join(2000);
        System.out.println("method main end");
    }
}

package cn.lxh.java.ManyThread.join;

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
        Thread thread = new Thread(new JoinDemo() {});
        thread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("���̵߳�"+ i +"��ִ��");
            if (i > 2) {
                thread.join();
            }
        }
        //thread.join(50000);
        //thread.wait();
        //Thread.sleep(2000);
        //Thread.yield();
        System.out.println("method main end");
    }
}

class JoinDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("�߳�1��" + i + "��ִ��");
        }
    }
}

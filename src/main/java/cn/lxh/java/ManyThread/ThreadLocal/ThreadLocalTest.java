package cn.lxh.java.ManyThread.ThreadLocal;

/**
 * Created by starlin
 * on 2019/7/3 15:57.
 * ThreadLocal�����ʵ��
 *
 * �����̵߳��������ںܳ������������ThreadLocal����set�˺ܴ�ܴ��Object����
 * ��Ȼset��get�ȵȷ������ض�����������ý��ж������������ThreadLocal���������պ�
 * ��ThreadLocalMap���Ӧ��Entry�ļ�ֵ����null�����Ǻ�����Ҳû�в���set��get�ȷ����ˡ�
 * �������ʵ����Ӧ�������ǲ�ʹ�õ�ʱ����������remove������������
 *
 * ��ThreadLocal����Ϊstatic����һ���ô����ǣ�����ThreadLocal��ǿ�����ڣ�
 * ��ô��ThreadLocalMap���Ӧ��Entry�ļ�����Զ���ڣ�
 * ��ôִ��remove��ʱ��Ϳ�����ȷ���ж�λ������ɾ��������
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    threadLocal.set(i);
                    System.out.println(Thread.currentThread().getName() + "--->" + threadLocal.get());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                // ��������remove������������
                threadLocal.remove();
            }
        },"thread1").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "--->" + threadLocal.get());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                // ��������remove������������
                threadLocal.remove();
            }
        },"thread2").start();
    }
}

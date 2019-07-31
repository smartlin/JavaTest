package cn.lxh.java.ManyThread.Demo;

/**
 * ����Runnableʵ�������߳���Ʊ
 * ����̷߳���ͬһ��Դһ��Ҫ�����߳�ͬ��������ͬ����Ӱ���������ܣ�ͬʱ���������ݵİ�ȫ��
 * ���ǹ����ͬ��(synchronized)���п��ܳ�������
 * ManyThread.currentThread()ȡ�õ�ǰ�̶߳���Ȼ����getName()������ȡ�߳�����
 * ��static��ͬ������ʹ�ö�����this��static��ͬ������ʹ�õĶ����� ����.class
 * Created by 1762 on 2015/09/05.
 */
class MYThread implements Runnable{
    private int tickets = 8;
    public void run(){
        for(int i = 0;i<20;i++){
            this.sale();
        }
//            synchronized (this) {//ͬ�������첽����ʹ��synchronized ��һ��Ҳ��Ϊͬ�������synchronized(����){}
//                                 //synchronized (this)��ʾ��ǰ����ÿ��ֻ����һ���������
//                if (this.tickets > 0) {
//                    try {
//                        ManyThread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(ManyThread.currentThread().getName() + ",ʣ��Ʊ��:" + this.tickets--);
//                }
//            }
//        }
    }

    public synchronized void sale(){//����ͬ������ �������ͬ�������һ��
        if (this.tickets > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ",ʣ��Ʊ��:" + this.tickets--);//ManyThread.currentThread()ȡ�õ�ǰ�̶߳���
        }
    }
    public static void test(){
        MYThread mt = new MYThread();
        new Thread(mt,"Ʊ��1").start();//һ���߳�  ����̶߳���ֻ��һ��MYThread����
        new Thread(mt,"Ʊ��2").start();//�����߳�
        new Thread(mt,"Ʊ��3").start();//�����߳�
        new Thread(mt,"Ʊ��4").start();//�����߳�
        new Thread(mt,"Ʊ��5").start();//�����߳�
        new Thread(mt,"Ʊ��6").start();//�����߳�

    }
}



public class RunnableDemo1 {
    public static void main(String[] args) {
        MYThread.test();
    }
}

package cn.lxh.java.ManyThread.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier��һ���̴߳ﵽһ������ʱ��������֪�����һ���̵߳�������ʱ�����ϲŻῪ�ţ����б��������ص��̲߳Ż�������С�
 * CyclicBarrierĬ�ϵĹ��췽����CyclicBarrier(int parties)���������ʾ�������ص��߳�������ÿ���̵߳���await��������CyclicBarrier���Ѿ��ﵽ�����ϣ�Ȼ��ǰ�̱߳�������
 * CyclicBarrier���ṩ��һ�����߼��Ĺ��캯��CyclicBarrier(int parties, Runnable barrierAction)�������̴߳ﵽ����ʱ������ִ��barrierAction
 * Created by starlin
 * on 2017/02/27 16:18.
 */
public class CyclicBarrierTest {
    //ԭ��ʹ��new CyclicBarrier(2)���˳��Ϊ3142
    //ʹ��new CyclicBarrier(2,new A())���˳��Ϊ31542
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2,new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println(1);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(2);
            }
        }).start();

        try{
            System.out.println(3);
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(4);
    }

    static class A implements Runnable{

        @Override
        public void run() {
            System.out.println(5);
        }
    }
}

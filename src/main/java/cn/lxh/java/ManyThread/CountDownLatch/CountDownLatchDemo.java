package cn.lxh.java.ManyThread.CountDownLatch;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by starlin
 * on 2017/09/21 13:54.
 * CountDownLatch��һ��ͬ�������࣬������һ�������߳�һֱ�ȴ���ֱ�������̵߳Ĳ���ִ�������ִ��
 * ���͵��÷��ǽ�һ�������Ϊn����������Ŀɽ�����񣬲�����ֵΪn��CountDownLatch��
 * ��ÿһ���������ʱ������������������ϵ���countDown��
 * �ȴ����ⱻ�����������������������await���������Լ���ס��ֱ������������������
 */
public class CountDownLatchDemo {
    private int theadNum = 5;//ִ�����̵߳�����
    private int workNum = 20;//��������
    private ExecutorService executorService;
    private ArrayBlockingQueue<String> arrayBlockingQueue;
    private CountDownLatch downLatch;

    @Before
    public void setUp(){
        executorService = Executors.newFixedThreadPool(theadNum, new ThreadFactoryBuilder().setNameFormat("WorkThread-%d").build());
        arrayBlockingQueue = new ArrayBlockingQueue<String>(workNum);
        for(int i=0;i<workNum;i++){
            arrayBlockingQueue.add("����--" + i);
        }
        downLatch = new CountDownLatch(workNum);
    }

    @Test
    public void test() throws Exception{
        System.out.println("���߳̿�ʼ����");
        for(int i=0;i<workNum;i++){
            executorService.execute(new WorkRunnable());
        }
        downLatch.await();//�ȴ����̵߳������������
        System.out.println("���߳�ȥ����������");
    }

    public String getWork(){
        return arrayBlockingQueue.poll();
    }

    class WorkRunnable implements Runnable{

        @Override
        public void run() {
            String work = getWork();
            perforWork(work);
            downLatch.countDown();//���һ���������һ��
        }
    }

    private void perforWork(String work){
        System.out.println("��������" + work);
        try{
            //ģ�������ʱ
            Thread.currentThread().sleep(60);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

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
 * CountDownLatch是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行
 * 典型的用法是将一个程序分为n个互相独立的可解决任务，并创建值为n的CountDownLatch。
 * 当每一个任务完成时，都会在这个锁存器上调用countDown，
 * 等待问题被解决的任务调用这个锁存器的await，将他们自己拦住，直至锁存器计数结束。
 */
public class CountDownLatchDemo {
    private int theadNum = 5;//执行子线程的数量
    private int workNum = 20;//任务数量
    private ExecutorService executorService;
    private ArrayBlockingQueue<String> arrayBlockingQueue;
    private CountDownLatch downLatch;

    @Before
    public void setUp(){
        executorService = Executors.newFixedThreadPool(theadNum, new ThreadFactoryBuilder().setNameFormat("WorkThread-%d").build());
        arrayBlockingQueue = new ArrayBlockingQueue<String>(workNum);
        for(int i=0;i<workNum;i++){
            arrayBlockingQueue.add("任务--" + i);
        }
        downLatch = new CountDownLatch(workNum);
    }

    @Test
    public void test() throws Exception{
        System.out.println("主线程开始运行");
        for(int i=0;i<workNum;i++){
            executorService.execute(new WorkRunnable());
        }
        downLatch.await();//等待子线程的所有任务完成
        System.out.println("主线程去做其他事情");
    }

    public String getWork(){
        return arrayBlockingQueue.poll();
    }

    class WorkRunnable implements Runnable{

        @Override
        public void run() {
            String work = getWork();
            perforWork(work);
            downLatch.countDown();//完成一个任务调用一次
        }
    }

    private void perforWork(String work){
        System.out.println("处理任务：" + work);
        try{
            //模拟任务耗时
            Thread.currentThread().sleep(60);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

package cn.lxh.java.ManyThread.CountDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by starlin
 * on 2019/9/21 22:17.
 * 利用CountDownLatch 模拟运动员比赛，并他共计平均时间
 */
public class CountDownLatchTest4 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //参加跑步人数
        int num = 10;
        //发令枪只响一次
        CountDownLatch begin = new CountDownLatch(1);
        //参与跑步有多人
        CountDownLatch end = new CountDownLatch(num);
        //每个跑步者一个赛道，相当于一个线程
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        //记录比赛成绩
        List<Future<Integer>> futures = new ArrayList<>();
        //跑步者就位，所有线程处于等待状态
        for (int i = 0; i < num; i++) {
            futures.add(executorService.submit(new Runner(begin, end)));
        }
        //发令枪响起，跑步者开始跑步
        begin.countDown();
        //等待所有跑步者结束
        end.await();
        //统计总分
        int count = 0;
        for (Future<Integer> f : futures) {
            count += f.get();
        }
        System.out.println("平均时间： {}" + count);
    }
}

class Runner implements Callable<Integer> {

    //开始信号
    private CountDownLatch begin;

    //结束信号
    private CountDownLatch end;

    public Runner(CountDownLatch begin, CountDownLatch end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        //跑步成绩
        int score = new Random().nextInt(25);
        //等待起跑指令
        begin.await();
        //跑步中
        TimeUnit.MILLISECONDS.sleep(score);
        //跑步结束
        end.countDown();
        return score;
    }
}

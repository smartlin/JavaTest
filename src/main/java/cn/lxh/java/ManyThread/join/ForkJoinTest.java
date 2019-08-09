package cn.lxh.java.ManyThread.join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 通常情况下，我们不需要直接继承ForkJoinTask，只需要继承它的子类，Fork/Join框架提供了两个子类：
 * RecursiveAction用于没有返回结果的任务；
 * RecursiveTask用于有返回结果的任务。
 * ForkJoinTask需要通过ForkJoinPool来执行
 * Created by starlin
 * on 2017/02/27 14:41.
 */
public class ForkJoinTest extends RecursiveTask<Integer>{

    private static final int THRESHOLD = 10;
    private int start;
    private int end;

    public ForkJoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if(canCompute){
            for(int i=start;i<=end;i++){
                sum += i;
            }
        }else{
            int middle = (start + end)/2;
            ForkJoinTest leftTask = new ForkJoinTest(start, middle);
            ForkJoinTest rightTask = new ForkJoinTest(middle+1, end);
            leftTask.fork();
            rightTask.fork();
            int leftResult  = leftTask.join();
            int rightResult = rightTask.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinTest forkJoinTest = new ForkJoinTest(1, 100);
        //ForkJoinTask需要通过ForkJoinPool来执行
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Integer> future = forkJoinPool.submit(forkJoinTest);
        try{
            System.out.println(future.get());
        }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if(forkJoinTest.isCompletedAbnormally()){
            System.out.println(forkJoinTest.getException());
        }

    }
}

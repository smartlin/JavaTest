package cn.lxh.java.ManyThread.join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * ͨ������£����ǲ���Ҫֱ�Ӽ̳�ForkJoinTask��ֻ��Ҫ�̳��������࣬Fork/Join����ṩ���������ࣺ
 * RecursiveAction����û�з��ؽ��������
 * RecursiveTask�����з��ؽ��������
 * ForkJoinTask��Ҫͨ��ForkJoinPool��ִ��
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
        //ForkJoinTask��Ҫͨ��ForkJoinPool��ִ��
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

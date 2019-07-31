package cn.lxh.java.ManyThread.ThreadLocal;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * Created by starlin
 * on 2017/02/28 9:30.
 */
public class ThreadPoolExecutorTest extends ThreadPoolExecutor{

    private final ThreadLocal<Long> startTime = new ThreadLocal<>();
    private Logger logger = Logger.getAnonymousLogger();
    private final AtomicLong numTasks = new AtomicLong();
    private final AtomicLong totalTime = new AtomicLong();

    public ThreadPoolExecutorTest(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }
    //重写了父类的法
    protected void beforeExecute(Thread t,Runnable r){
        super.beforeExecute(t,r);
        logger.info(String.format("Thread %s: start %s",t,r));
        startTime.set(System.nanoTime());
    }
    //重写了父类的法
    protected void afterExecute(Runnable r ,Throwable t){
        try{
            long endTime = System.nanoTime();
            long taskTime = endTime - startTime.get();
            numTasks.incrementAndGet();
            totalTime.addAndGet(taskTime);
            logger.info(String.format("Thread %s: end %s, time=%dns",t,r,taskTime));
        }finally {
            super.afterExecute(r,t);
        }
    }
    //重写了父类的法
    protected void terminated(){
        try{
            logger.info(String.format("Terminated:avg time=%dns",totalTime.get()/numTasks.get()));
        }finally {
            super.terminated();
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor  exec = new ThreadPoolExecutorTest(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        exec.execute(new DoSomething(5));
        exec.execute(new DoSomething(4));
        exec.execute(new DoSomething(3));
        exec.execute(new DoSomething(2));
        exec.execute(new DoSomething(1));
        exec.shutdown();
    }
}

class DoSomething implements Runnable{
    private int sleepTime;

    public DoSomething(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is running");
        try{
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

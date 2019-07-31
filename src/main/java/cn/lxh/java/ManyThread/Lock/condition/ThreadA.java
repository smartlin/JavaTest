package cn.lxh.java.ManyThread.Lock.condition;

/**
 * Created by starlin
 * on 2016/08/21 16:08.
 */
public class ThreadA extends Thread {
    private UserConditionWaitNotify userConditionWaitNotify;

    public ThreadA(UserConditionWaitNotify userConditionWaitNotify) {
        this.userConditionWaitNotify = userConditionWaitNotify;
    }

    @Override
    public void run(){
        userConditionWaitNotify.await();
    }
}

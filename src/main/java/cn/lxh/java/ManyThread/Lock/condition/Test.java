package cn.lxh.java.ManyThread.Lock.condition;

/**
 * Created by starlin
 * on 2016/08/21 16:09.
 * 使用Condition实现等待/通知
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        UserConditionWaitNotify userConditionWaitNotify = new UserConditionWaitNotify();
        ThreadA a = new ThreadA(userConditionWaitNotify);
        a.start();
        Thread.sleep(3000);
        userConditionWaitNotify.singal();
    }
}

package cn.lxh.java.MQ;

import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by starlin
 * on 2020/8/17 16:42.
 * ʹ�� DelayQueue ʵ�����Զ����ӳ���Ϣ����
 */
public class MqDelayQueueTest {
    private static DelayQueue delayQueue = new DelayQueue();

    public static void main(String[] args) throws InterruptedException {
        produce();
        consumer();
    }

    public static void produce() {
        delayQueue.put(new MyDelay(1000,"��Ϣ1"));
        delayQueue.put(new MyDelay(3000,"��Ϣ2"));
    }

    public static void consumer() throws InterruptedException {
        System.out.println("��ʼִ��ʱ�䣺" +
                DateFormat.getDateTimeInstance().format(new Date()));
        while (!delayQueue.isEmpty()) {
            System.out.println(delayQueue.take());
        }
        System.out.println("����ִ��ʱ�䣺" +
                DateFormat.getDateTimeInstance().format(new Date()));
    }

    static class MyDelay implements Delayed {
        long delayTime = System.currentTimeMillis();

        @Getter
        @Setter
        private String msg;

        public MyDelay(long delayTime,String msg) {
            this.delayTime = this.delayTime + delayTime;
            this.msg = msg;
        }

        //��ȡʣ��ʱ��
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(delayTime-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        //������Ԫ�ص���������
        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
                return 1;
            } else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return this.msg;
        }
    }
}

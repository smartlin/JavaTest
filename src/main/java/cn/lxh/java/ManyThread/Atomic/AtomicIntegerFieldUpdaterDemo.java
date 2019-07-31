package cn.lxh.java.ManyThread.Atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by starlin
 * on 2018/4/15 16:11.
 * ԭ�Ӹ�������
 * ��ע��ԭ�Ӹ�������ʹ�ô��ڱȽϿ��̵��������£�
 * 1.�������ֶβ�����static����
 * 2.�������ֶβ�����final���͵�
 * 3.�ֶα�����volatile���εģ�Ҳ�������ݱ����Ƕ�һ�µ�
 * 4.���Ա���Ե�ǰ��Updater���ڵ������ǿɼ��ģ�������ǵ�ǰ���ڲ�����ԭ�Ӹ�������������ʹ��private��
 *   protected�����������ʱ���η�������protectȨ�޼����ϣ�
 *   �����ͬһ��package���������defaultȨ�޼����ϣ�Ҳ����˵���ۺ�ʱ��Ӧ�ñ�֤�������뱻�������Ŀɼ��ԡ�
 */
public class AtomicIntegerFieldUpdaterDemo {
    public static class Candidate {
        int id;
        volatile int score;
    }

    public static class Game {
        int id;
        volatile String name;

        public Game(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Game{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static AtomicIntegerFieldUpdater<Candidate> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");
    static AtomicReferenceFieldUpdater<Game, String> atomicReferenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(Game.class, String.class, "name");

    //������֤
    public static AtomicInteger atomicInteger = new AtomicInteger();

    //����ʹ��AtomicIntegerFieldUpdater���º�ѡ��(Candidate)�ķ���score��������10000���߳�ͶƱ��
    //�����ֵ����0.4ʱ��һƱ����������һ�Σ�����atomicInteger������֤�����Ƿ���ȷ(��ʵ������֤AtomicIntegerFieldUpdater���µ��ֶ��Ƿ��̰߳�ȫ)��
    //��atomicInteger��score��ͬʱ����˵��ͶƱ�������Ҳ����AtomicIntegerFieldUpdater����ȷ�����ֶ�score��ֵ�����̰߳�ȫ�ġ�
    //����AtomicReferenceFieldUpdater�������ڴ����м���ʾ����ʹ�÷�ʽ��ע����AtomicReferenceFieldUpdaterע������ʱ��Ҫ�������Ͳ�����һ�����޸ĵ������ͣ�һ���޸��ֶε�����
    public static void main(String[] args) throws InterruptedException {
        final Candidate candidate = new Candidate();
        Thread[] threads = new Thread[10000];
        //����10000���߳�
        for (int i = 0; i < 10000; i++) {
            threads[i] = new Thread(){
                @Override
                public void run() {
                    if (Math.random() > 0.4) {
                        atomicIntegerFieldUpdater.incrementAndGet(candidate);
                        atomicInteger.incrementAndGet();
                    }
                }
            };
            threads[i].start();
        }
        for (int i = 0; i < 10000; i++) {
            threads[i].join();
        }
        System.out.println("���շ���:" + candidate.score);
        System.out.println("У�������" + atomicInteger);

        //AtomicReferenceFieldUpdater �򵥵�ʹ��
        Game game = new Game(2, "haha");
        atomicReferenceFieldUpdater.compareAndSet(game, game.name, "Java-haha");
        System.out.println(game.toString());
    }
    
}

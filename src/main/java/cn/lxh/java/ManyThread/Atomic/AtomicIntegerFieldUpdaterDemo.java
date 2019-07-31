package cn.lxh.java.ManyThread.Atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by starlin
 * on 2018/4/15 16:11.
 * 原子更新属性
 * 请注意原子更新器的使用存在比较苛刻的条件如下：
 * 1.操作的字段不能是static类型
 * 2.操作的字段不能是final类型的
 * 3.字段必须是volatile修饰的，也就是数据本身是读一致的
 * 4.属性必须对当前的Updater所在的区域是可见的，如果不是当前类内部进行原子更新器操作不能使用private，
 *   protected子类操作父类时修饰符必须是protect权限及以上，
 *   如果在同一个package下则必须是default权限及以上，也就是说无论何时都应该保证操作类与被操作类间的可见性。
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

    //用于验证
    public static AtomicInteger atomicInteger = new AtomicInteger();

    //我们使用AtomicIntegerFieldUpdater更新候选人(Candidate)的分数score，开启了10000条线程投票，
    //当随机值大于0.4时算一票，分数自增一次，其中atomicInteger用于验证分数是否正确(其实用于验证AtomicIntegerFieldUpdater更新的字段是否线程安全)，
    //当atomicInteger与score相同时，则说明投票结果无误，也代表AtomicIntegerFieldUpdater能正确更新字段score的值，是线程安全的。
    //对于AtomicReferenceFieldUpdater，我们在代码中简单演示了其使用方式，注意在AtomicReferenceFieldUpdater注明泛型时需要两个泛型参数，一个是修改的类类型，一个修改字段的类型
    public static void main(String[] args) throws InterruptedException {
        final Candidate candidate = new Candidate();
        Thread[] threads = new Thread[10000];
        //开启10000个线程
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
        System.out.println("最终分数:" + candidate.score);
        System.out.println("校验分数：" + atomicInteger);

        //AtomicReferenceFieldUpdater 简单的使用
        Game game = new Game(2, "haha");
        atomicReferenceFieldUpdater.compareAndSet(game, game.name, "Java-haha");
        System.out.println(game.toString());
    }
    
}

package cn.lxh.java.ManyThread.LongAdder;

/**
 * Created by starlin
 * on 2019/9/10 15:25.
 * 既然已经意识到Atomic*有这样的缺陷，Doug Lea大神又给我们提供了LongAdder，
 * 内部的实现有点类似ConcurrentHashMap的分段锁，最好的情况下，每个线程都有独立的计数器，这样可以大量减少并发操作
 */
public class LongAdderTest {

}

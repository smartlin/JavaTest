package cn.lxh.java.ManyThread.CourrentHashMap;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by starlin
 * on 2020/9/16 15:22.
 */
public class ConcurrentHashMapWrongTest implements Runnable{
    private static int THREAD_COUNT = 10;
    private static int ITEM_COUNT = 1000;

    private static final Logger log = LoggerFactory.getLogger(ConcurrentHashMapWrongTest.class);

    //用来获得一个指定元素数量模拟数据的ConcurrentHashMap
    private ConcurrentHashMap<String, Long> getData(int count) {
        return LongStream.rangeClosed(1, count)
                .boxed()
                .collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(), Function.identity(),
                        (o1, o2) -> o1, ConcurrentHashMap::new));
    }

    @SneakyThrows
    @Override
    public void run() {
        ConcurrentHashMap<String, Long> concurrentHashMap = getData(ITEM_COUNT - 100);
        //初始900个元素
        log.info("init size:{}", concurrentHashMap.size());

        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        //使用线程池并发处理逻辑
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
            //查询还需要补充多少个元素
            //synchronized (concurrentHashMap) {
                int gap = ITEM_COUNT - concurrentHashMap.size();
                log.info("threadName : {},gap size:{}", Thread.currentThread().getName(),gap);
                //补充元素
                concurrentHashMap.putAll(getData(gap));
            //}
        }));
        //等待所有任务完成
        forkJoinPool.shutdown();
        try {
            forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //最后元素个数会是1000吗
        log.info("threadName : {}, finish size:{} ", Thread.currentThread().getName(),concurrentHashMap.size());
    }


    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMapWrongTest wrong = new ConcurrentHashMapWrongTest();
        Thread[] threads = new Thread[10];
        //创建10条线程
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(wrong);
        }
        //启动10条线程
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

    }
}

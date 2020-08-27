package cn.lxh.java.ManyThread.ThreadLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by starlin
 * on 2020/8/26 18:37.
 */
public class SimpleDateFormatThreadLocalTest {

    ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        }
    };

    public static void main(String[] args) {
        final SimpleDateFormatThreadLocalTest simpleDateFormatTest = new SimpleDateFormatThreadLocalTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.submit(()->{
                try {
                    System.out.println(simpleDateFormatTest.dateFormat.get().parse("2020-08-26 18:41:10"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}

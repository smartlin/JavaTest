package cn.lxh.java.ManyThread.CompletableFuture;



import java.util.concurrent.*;

/**
 * Created by starlin
 * on 2024/8/13 14:52.
 * CompletableFuture在回调方法中对异常进行了包装。
 * 大部分异常会封装成CompletionException后抛出，真正的异常存储在cause属性中，
 * 因此如果调用链中经过了回调方法处理那么就需要用Throwable.getCause()方法提取真正的异常。
 * 但是，有些情况下会直接返回真正的异常，可用使用工具类提取异常。
 */
public class Wrong1CompletableFutureDemo {
    public static void main(String[] args) {
        doGet();
    }

    public static void doGet() {
        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 5L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            int a = 0;
            int b = 666;
            int c = b / a;
            return true;
        }, executorService).thenAccept(System.out::println).exceptionally(throwable -> {
            // 调用下面ExceptionUtils中的extractRealException方法提取真正的异常
            System.out.println("error" + ExceptionUtils.extractRealException(throwable));
            return null;
        });
        future.join();
        //如果不加 get()方法这一行，看不到异常信息
//        try {
//            future.get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
    }
}

class ExceptionUtils {

    public static Throwable extractRealException(Throwable throwable) {
        //这里判断异常类型是否为CompletionException、ExecutionException，如果是则进行提取，否则直接返回。
        if (throwable instanceof CompletionException || throwable instanceof ExecutionException) {
            if (throwable.getCause() != null) {
                return throwable.getCause();
            }
        }
        return throwable;
    }
}

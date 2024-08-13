package cn.lxh.java.ManyThread.CompletableFuture;



import java.util.concurrent.*;

/**
 * Created by starlin
 * on 2024/8/13 14:52.
 * CompletableFuture�ڻص������ж��쳣�����˰�װ��
 * �󲿷��쳣���װ��CompletionException���׳����������쳣�洢��cause�����У�
 * �������������о����˻ص�����������ô����Ҫ��Throwable.getCause()������ȡ�������쳣��
 * ���ǣ���Щ����»�ֱ�ӷ����������쳣������ʹ�ù�������ȡ�쳣��
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
            // ��������ExceptionUtils�е�extractRealException������ȡ�������쳣
            System.out.println("error" + ExceptionUtils.extractRealException(throwable));
            return null;
        });
        future.join();
        //������� get()������һ�У��������쳣��Ϣ
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
        //�����ж��쳣�����Ƿ�ΪCompletionException��ExecutionException��������������ȡ������ֱ�ӷ��ء�
        if (throwable instanceof CompletionException || throwable instanceof ExecutionException) {
            if (throwable.getCause() != null) {
                return throwable.getCause();
            }
        }
        return throwable;
    }
}

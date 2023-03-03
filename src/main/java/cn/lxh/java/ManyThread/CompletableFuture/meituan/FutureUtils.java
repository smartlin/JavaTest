package cn.lxh.java.ManyThread.CompletableFuture.meituan;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * CompletableFuture��װ������
 */
@Slf4j
public class FutureUtils {
    /**
     * �÷���Ϊ�����ڲ�rpcע������ķ�װ��������Ϊ����ʵ�ֵĲ���
     * OctoThriftCallback Ϊthrift�ص�����
     * ThriftAsyncCall Ϊ�Զ��庯����������ʾһ��thrift���ã��������ϣ�
     */
//    public static <T> CompletableFuture<T> toCompletableFuture(final OctoThriftCallback<?, T> callback, ThriftAsyncCall thriftCall) {
//        CompletableFuture<T> thriftResultFuture = new CompletableFuture<>();
//        callback.addObserver(new OctoObserver<T>() {
//            @Override
//            public void onSuccess(T t) {
//                thriftResultFuture.complete(t);
//            }
//
//            @Override
//            public void onFailure(Throwable throwable) {
//                thriftResultFuture.completeExceptionally(throwable);
//            }
//        });
//        if (thriftCall != null) {
//            try {
//                thriftCall.invoke();
//            } catch (TException e) {
//                thriftResultFuture.completeExceptionally(e);
//            }
//        }
//        return thriftResultFuture;
//    }

    /**
     * ����CF״̬Ϊʧ��
     */
    public static <T> CompletableFuture<T> failed(Throwable ex) {
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        completableFuture.completeExceptionally(ex);
        return completableFuture;
    }

    /**
     * ����CF״̬Ϊ�ɹ�
     */
    public static <T> CompletableFuture<T> success(T result) {
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        completableFuture.complete(result);
        return completableFuture;
    }

    /**
     * ��List<CompletableFuture<T>> תΪ CompletableFuture<List<T>>
     */
    public static <T> CompletableFuture<List<T>> sequence(Collection<CompletableFuture<T>> completableFutures) {
        return CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture<?>[0]))
                .thenApply(v -> completableFutures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList())
                );
    }

    /**
     * ��List<CompletableFuture<List<T>>> תΪ CompletableFuture<List<T>>
     * �����ڷ�ҳ��ѯ�ĳ���
     */
    public static <T> CompletableFuture<List<T>> sequenceList(Collection<CompletableFuture<List<T>>> completableFutures) {
        return CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture<?>[0]))
                .thenApply(v -> completableFutures.stream()
                        .flatMap(listFuture -> listFuture.join().stream())
                        .collect(Collectors.toList())
                );
    }

    /*
     * ��List<CompletableFuture<Map<K, V>>> תΪ CompletableFuture<Map<K, V>>
     * @Param mergeFunction �Զ���key��ͻʱ��merge����
     */
//    public static <K, V> CompletableFuture<Map<K, V>> sequenceMap(
//            Collection<CompletableFuture<Map<K, V>>> completableFutures, BinaryOperator<V> mergeFunction) {
//        return CompletableFuture
//                .allOf(completableFutures.toArray(new CompletableFuture<?>[0]))
//                .thenApply(v -> completableFutures.stream().map(CompletableFuture::join)
//                        .flatMap(map -> map.entrySet().stream())
//                        .collect(Collectors.toMap(Entry::getKey, Entry::getValue, mergeFunction)));
//    }

    /**
     * ��List<CompletableFuture<T>> תΪ CompletableFuture<List<T>>�������˵�nullֵ
     */
    public static <T> CompletableFuture<List<T>> sequenceNonNull(Collection<CompletableFuture<T>> completableFutures) {
        return CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture<?>[0]))
                .thenApply(v -> completableFutures.stream()
                        .map(CompletableFuture::join)
                        .filter(e -> e != null)
                        .collect(Collectors.toList())
                );
    }

    /**
     * ��List<CompletableFuture<List<T>>> תΪ CompletableFuture<List<T>>�������˵�nullֵ
     * �����ڷ�ҳ��ѯ�ĳ���
     */
    public static <T> CompletableFuture<List<T>> sequenceListNonNull(Collection<CompletableFuture<List<T>>> completableFutures) {
        return CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture<?>[0]))
                .thenApply(v -> completableFutures.stream()
                        .flatMap(listFuture -> listFuture.join().stream().filter(e -> e != null))
                        .collect(Collectors.toList())
                );
    }

    /**
     * ��List<CompletableFuture<Map<K, V>>> תΪ CompletableFuture<Map<K, V>>
     *
     * @Param filterFunction �Զ�����˲���
     */
    public static <T> CompletableFuture<List<T>> sequence(Collection<CompletableFuture<T>> completableFutures,
                                                          Predicate<? super T> filterFunction) {
        return CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture<?>[0]))
                .thenApply(v -> completableFutures.stream()
                        .map(CompletableFuture::join)
                        .filter(filterFunction)
                        .collect(Collectors.toList())
                );
    }

    /**
     * ��List<CompletableFuture<List<T>>> תΪ CompletableFuture<List<T>>
     *
     * @Param filterFunction �Զ�����˲���
     */
    public static <T> CompletableFuture<List<T>> sequenceList(Collection<CompletableFuture<List<T>>> completableFutures,
                                                              Predicate<? super T> filterFunction) {
        return CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture<?>[0]))
                .thenApply(v -> completableFutures.stream()
                        .flatMap(listFuture -> listFuture.join().stream().filter(filterFunction))
                        .collect(Collectors.toList())
                );
    }

    /**
     * ��CompletableFuture<Map<K,V>>��listתΪ CompletableFuture<Map<K,V>>�� ���map�ϲ�Ϊһ��map�� ���key��ͻ�������µ�value���ǡ�
     */
//    public static <K, V> CompletableFuture<Map<K, V>> sequenceMap(
//            Collection<CompletableFuture<Map<K, V>>> completableFutures) {
//        return CompletableFuture
//                .allOf(completableFutures.toArray(new CompletableFuture<?>[0]))
//                .thenApply(v -> completableFutures.stream().map(CompletableFuture::join)
//                        .flatMap(map -> map.entrySet().stream())
//                        .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (a, b) -> b)));
//    }
}
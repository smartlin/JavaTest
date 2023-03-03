package cn.lxh.java.ManyThread.CompletableFuture.meituan;

@FunctionalInterface
public interface ThriftAsyncCall {
//    void invoke() throws TException;
    void invoke();
}
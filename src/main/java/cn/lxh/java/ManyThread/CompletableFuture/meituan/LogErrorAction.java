package cn.lxh.java.ManyThread.CompletableFuture.meituan;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;

/**
 * �����쳣ʱ�������Ƿ�Ϊҵ���쳣��ӡ��־��
 * ��CompletableFuture.whenComplete���ʹ�ã����ı�completableFuture�Ľ��������OR�쳣��
 */
@Slf4j
public class LogErrorAction<R> extends AbstractLogAction<R> implements BiConsumer<R, Throwable> {
    public LogErrorAction(String methodName, Object... args) {
        super(methodName, args);
    }

    @Override
    public void accept(R result, Throwable throwable) {
        logResult(result, throwable);
    }
}
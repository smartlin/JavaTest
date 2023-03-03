package cn.lxh.java.ManyThread.CompletableFuture.meituan;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * �������쳣ʱ�����Զ����ֵ
 */
public class DefaultValueHandle<R> extends AbstractLogAction<R> implements BiFunction<R, Throwable, R> {
    private final R defaultValue;
    /**
     * ������ֵΪ�յ�ʱ���Ƿ��滻ΪĬ��ֵ
     */
    private final boolean isNullToDefault;

    /**
     * @param methodName   ��������
     * @param defaultValue ���쳣����ʱ�Զ��巵�ص�Ĭ��ֵ
     * @param args         �������
     */
    public DefaultValueHandle(String methodName, R defaultValue, Object... args) {
        super(methodName, args);
        this.defaultValue = defaultValue;
        this.isNullToDefault = false;
    }

    /**
     * @param isNullToDefault
     * @param defaultValue    ���쳣����ʱ�Զ��巵�ص�Ĭ��ֵ
     * @param methodName      ��������
     * @param args            �������
     */
    public DefaultValueHandle(boolean isNullToDefault, R defaultValue, String methodName, Object... args) {
        super(methodName, args);
        this.defaultValue = defaultValue;
        this.isNullToDefault = isNullToDefault;
    }

    @Override
    public R apply(R result, Throwable throwable) {
        logResult(result, throwable);
        if (throwable != null) {
            return defaultValue;
        }
        if (result == null && isNullToDefault) {
            return defaultValue;
        }
        return result;
    }

    public static <R> DefaultValueHandle.DefaultValueHandleBuilder<R> builder() {
        return new DefaultValueHandle.DefaultValueHandleBuilder<>();
    }

    public static class DefaultValueHandleBuilder<R> {
        private boolean isNullToDefault;
        private R defaultValue;
        private String methodName;
        private Object[] args;

        DefaultValueHandleBuilder() {
        }

        public DefaultValueHandle.DefaultValueHandleBuilder<R> isNullToDefault(final boolean isNullToDefault) {
            this.isNullToDefault = isNullToDefault;
            return this;
        }

        public DefaultValueHandle.DefaultValueHandleBuilder<R> defaultValue(final R defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public DefaultValueHandle.DefaultValueHandleBuilder<R> methodName(final String methodName) {
            this.methodName = methodName;
            return this;
        }

        public DefaultValueHandle.DefaultValueHandleBuilder<R> args(final Object... args) {
            this.args = args;
            return this;
        }

        public DefaultValueHandle<R> build() {
            return new DefaultValueHandle<R>(this.isNullToDefault, this.defaultValue, this.methodName, this.args);
        }
        @Override
        public String toString() {
            return "DefaultValueHandle.DefaultValueHandleBuilder(isNullToDefault=" + this.isNullToDefault + ", defaultValue=" + this.defaultValue + ", methodName=" + this.methodName + ", args=" + Arrays.deepToString(this.args) + ")";
        }
    }
}
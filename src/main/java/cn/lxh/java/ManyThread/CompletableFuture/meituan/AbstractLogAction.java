package cn.lxh.java.ManyThread.CompletableFuture.meituan;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractLogAction<R> {
    protected final String methodName;
    protected final Object[] args;

    public AbstractLogAction(String methodName, Object... args) {
        this.methodName = methodName;
        this.args = args;
    }

    protected void logResult(R result, Throwable throwable) {
//        if (throwable != null) {
//            boolean isBusinessError = throwable instanceof TBase || (throwable.getCause() != null && throwable
//                    .getCause() instanceof TBase);
//            if (isBusinessError) {
//                logBusinessError(throwable);
//            } else if (throwable instanceof DegradeException || throwable instanceof DegradeRuntimeException) {//����Ϊ�ڲ�rpc����׳����쳣��ʹ��ʱ���������޸�
//                if (RhinoSwitch.getBoolean("isPrintDegradeLog", false)) {
//                    log.error("{} degrade exception, param:{} , error:{}", methodName, args, throwable);
//                }
//            } else {
//                log.error("{} unknown error, param:{} , error:{}", methodName, args, ExceptionUtils.extractRealException(throwable));
//            }
//        } else {
//            if (isLogResult()) {
//                log.info("{} param:{} , result:{}", methodName, args, result);
//            } else {
//                log.info("{} param:{}", methodName, args);
//            }
//        }
    }

    private void logBusinessError(Throwable throwable) {
//        log.error("{} business error, param:{} , error:{}", methodName, args, throwable.toString(), ExceptionUtils.extractRealException(throwable));
    }

    private boolean isLogResult() {
        //�����Ƕ�̬���ÿ��أ����ڶ�̬������־��ӡ����Դ��̬�������Ŀ���ʹ��nacos��apollo�ȣ������Ŀû��ʹ���������������ɾ��
//        return RhinoSwitch.getBoolean(methodName + "_isLogResult", false);
        return true;
    }
}
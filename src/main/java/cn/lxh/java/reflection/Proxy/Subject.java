package cn.lxh.java.reflection.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by starlin
 * on 2019/9/21 15:44.
 * ����java���е�java.lang.reflect.Proxyʹ�ö�̬����
 */
public interface Subject {
    //����һ������
    public void request();
}

class RealSubject implements Subject {

    @Override
    public void request() {
        //ҵ����
    }
}

class SubjectHandle implements InvocationHandler{

    private Subject subject;

    SubjectHandle(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = method.invoke(subject, args);
        return obj;
    }
}


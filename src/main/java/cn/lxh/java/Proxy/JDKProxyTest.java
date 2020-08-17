package cn.lxh.java.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by starlin
 * on 2020/8/14 18:31.
 * jdk proxy 动态代理实现
 */
public class JDKProxyTest {
    static interface Car{
        void running();
    }

    static class Bus implements Car{
        @Override
        public void running() {
            System.out.println("Bus is running");
        }
    }

    static class Taxi implements Car {
        @Override
        public void running() {
            System.out.println("Taxi is running");
        }
    }

    static class JDKProxy implements InvocationHandler {
        //代理对象
        private Object target;
        //获取到代理对象
        public Object getInstance(Object target) {
            this.target = target;
            return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = method.invoke(target, args);
            return result;
        }
    }

    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy();
        Car carInstance = (Car)jdkProxy.getInstance(new Taxi());
        carInstance.running();
    }
}

package cn.lxh.java.Proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by starlin
 * on 2020/8/14 18:55.
 * cglib proxy
 */
public class CgLibProxyTest {
    static class Car{
        public void running(){
            System.out.println("Car is running");
        };
    }

    static class CGlibProxy implements MethodInterceptor {
        private Object target;

        public Object getInstance(Object target) {
            this.target = target;
            Enhancer enhancer = new Enhancer();
            //设置父类为实例类
            enhancer.setSuperclass(this.target.getClass());
            //回调方法
            enhancer.setCallback(this);
            //创建代理对象
            return enhancer.create();
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            Object result = methodProxy.invokeSuper(o, objects);
            return result;
        }
    }

    public static void main(String[] args) {
        CGlibProxy cGlibProxy = new CGlibProxy();
        Car car = (Car) cGlibProxy.getInstance(new Car());
        car.running();
    }
}

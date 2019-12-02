package cn.lxh.java.DesignStyle.decorator.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * Created by starlin
 * on 2019/9/21 16:09.
 * 装饰模式、包装类
 */
public class DecoratorAnimal implements Animal{
    //被包装的动物
    private Animal animal;
    //使用哪一个包装器
    private Class<? extends Feature> clz;

    public DecoratorAnimal(Animal animal, Class<? extends Feature> clz) {
        this.animal = animal;
        this.clz = clz;
    }

    @Override
    public void duStuff() {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object obj = null;
                //设置包装条件
                if (Modifier.isPublic(method.getModifiers())) {
                    obj = method.invoke(clz.newInstance(), args);
                }
                animal.duStuff();
                return obj;
            }
        };
        //当前加载器
        ClassLoader cl = getClass().getClassLoader();
        //动态代理，由handle决定如何包装
        Feature proxy = (Feature) Proxy.newProxyInstance(cl, clz.getInterfaces(), handler);
        proxy.load();
    }
}

package cn.lxh.java.DesignStyle.decorator.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * Created by starlin
 * on 2019/9/21 16:09.
 * װ��ģʽ����װ��
 */
public class DecoratorAnimal implements Animal{
    //����װ�Ķ���
    private Animal animal;
    //ʹ����һ����װ��
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
                //���ð�װ����
                if (Modifier.isPublic(method.getModifiers())) {
                    obj = method.invoke(clz.newInstance(), args);
                }
                animal.duStuff();
                return obj;
            }
        };
        //��ǰ������
        ClassLoader cl = getClass().getClassLoader();
        //��̬������handle������ΰ�װ
        Feature proxy = (Feature) Proxy.newProxyInstance(cl, clz.getInterfaces(), handler);
        proxy.load();
    }
}

package cn.lxh.java;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

import java.lang.reflect.Method;

/**
 * Created by starlin
 * on 2020/8/6 18:01.
 */
public class JavassistTest {
    public static void main(String[] args) throws Exception {
        //初始化Javassist类池
        ClassPool classPool = ClassPool.getDefault();
        //创建一个TestJavassist类
        CtClass ctClass = classPool.makeClass("TestJavassist");
        //创建一个test方法
        CtMethod ctMethod = CtNewMethod.make("public static void test(){ System.out.println(\"hello javassist\"); }", ctClass);
        ctClass.addMethod(ctMethod);
        //生成class
        Class aclass = ctClass.toClass();
        //通过反射调用这个实例
        Object object = aclass.newInstance();
        Method method = aclass.getDeclaredMethod("test", null);
        method.invoke(object, null);
    }
}

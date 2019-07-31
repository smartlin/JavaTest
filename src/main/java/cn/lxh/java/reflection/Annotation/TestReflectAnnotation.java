package cn.lxh.java.reflection.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 使用Annotation修改工厂类
 * annotation三种存在范围：CLASS 保存在类中、RUNTIME 程序运行时起作用、SOURCE 在源代码中起作用
 * Created by starlin
 * on 2015/09/29 14:49.
 */
@Retention(value=RetentionPolicy.RUNTIME)//定义annotation的存在范围
@interface MyFactory{//定义属于自己的Annontation 用@interface
    public String classname();
}

interface Messages{
    public void print(String str);
}

class News implements Messages{

    @Override
    public void print(String str) {
        System.out.println("新闻的内容：" + str);
    }
}

class Email implements Messages{
    @Override
    public void print(String str) {
        System.out.println("邮件的内容：" + str);
    }
}

@MyFactory(classname="cn.lxh.java.Annotation.Email")
public class TestReflectAnnotation {
    public static  Messages get() throws Exception{
        Class<?> cls = TestReflectAnnotation.class;
        MyFactory an = cls.getAnnotation(MyFactory.class);//getAnnotation()取得Annotation
        String classname = an.classname();
        Class<?> ins = Class.forName(classname);
        Object obj = ins.newInstance();
        Messages msg = (Messages) obj;
        return msg;
    }
    public static void main(String[] args) throws Exception {
        Messages msg = get();
        msg.print("帅就一个字");
    }
}

package cn.lxh.java.Annotation;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * 创建属于自己的Annotation
 * Created by starlin
 * on 2015/09/29 16:38.
 */
@Retention(value= RetentionPolicy.RUNTIME)
public @interface CreateAnnotation {
    public String name() default "starlin";//设置默认值
    public String val();

}
@CreateAnnotation(val = "demo")//设置val
class Student implements Serializable{
}

class TestAnnotation{
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("cn.lxh.java.Annotation.Student");
//        Annotation[] an = cls.getAnnotations();//取得全部的Annotation
//        for(int i=0;i<an.length;i++){
//            System.out.println(an[i]);
//        }
        //取得一个指定的Annotation类型
        CreateAnnotation an = cls.getAnnotation(CreateAnnotation.class);
        System.out.println(an.name());
        System.out.println(an.val());
    }
}
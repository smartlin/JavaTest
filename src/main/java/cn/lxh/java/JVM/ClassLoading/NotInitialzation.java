package cn.lxh.java.JVM.ClassLoading;

import java.io.Serializable;

/**
 * Created by starlin
 * on 2018/8/26 23:18.
 * 子类引用父类的静态字段，子类不会被初始化
 */
public class NotInitialzation implements Serializable {

    public static void main(String[] args) {
        //子类引用父类的静态字段，子类不会被初始化
        System.out.println(SuperClass.value);

        //通过数组定义来引用类，不会触发此类的初始化
        SuperClass[] superClasses = new SuperClass[10];

        //常量在编译阶段会存入调用类的常量池，本质上并没有直接引用到定义常量的类，因此不会触发定义常量类的初始化
        System.out.println(ConstClass.VALUE);
    }
}

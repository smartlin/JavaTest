package cn.lxh.java.Constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * Class.forname("包.类名") 实例化newInstance时必须要有无参构造
 * Created by starlin
 * on 2015/09/29 20:22.
 */
class Book{
    private String title;
    private Double price;
    public Book(String title){
        this.title = title;
    }
    public Book(String title,Double price){
        this.title = title;
        this.price = price;
    }
    @Override
    public String toString() {
        return "书名：" + this.title + "价格：" +this.price;
    }
}
public class TestDemo {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("cn.lxh.java.Constructor.Book");
        Constructor<?> con [] = cls.getConstructors();//getConstructors 取得全部构造方法
        for(int i = 0;i<con.length;i++){
//            System.out.println(con[i]);
//            System.out.println(con[i].getModifiers());//取得修饰符的数字
            System.out.print(Modifier.toString(con[i].getModifiers()) + " ");//将修饰符还原
            System.out.print(con[i].getName() + "(");
            Class<?> parms[] = con[i].getParameterTypes();//取得所有参数类型
            for(int j = 0;j<parms.length;j++){
                System.out.print(parms[j].getSimpleName() + " arg" + j );
                if(j<parms.length-1){
                    System.out.print( ",");
                }
            }
            System.out.print(")");
            System.out.println();

        }
    }
}

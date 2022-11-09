package cn.lxh.java.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Set;

/**
 * Properties是hashtable的子类
 * Properties存储键值对
 * Created by starlin
 * on 2015/11/05 11:01.
 */
public class PropertiesDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        //设置元素
        properties.setProperty("starlin","20");
        properties.setProperty("zhangsan","21");
        properties.setProperty("lisi","22");
        //获取元素
        System.out.println(properties.getProperty("starlin"));
        //取得所有元素stringPropertyNames()
        Set<String> set = properties.stringPropertyNames();
        //用Iterator输出Set集合
//        Iterator<String> it =  set.iterator();
//        while (it.hasNext()){
//            String s = it.next();
//            System.out.println(s);
//        }
        //用高级for循环输出set集合
        for(String s:set){
            System.out.println(s + "===" + properties.getProperty(s));
        }

        //===============================================
        //读取文件load()方法
        try {
            FileInputStream fileInputStream = new FileInputStream("d:" + File.separator + "FutureTest.properties");
            Properties properties1 = new Properties();
            properties1.load(fileInputStream);//用properties中load方法加载文件流
           // System.out.println(properties1);
            properties1.setProperty("starlin","30");//此时改变只是内存中的元素，文件本身并未被修改
            System.out.println(properties1);
            FileOutputStream fileOutputStream = new FileOutputStream("d:" + File.separator + "FutureTest.properties");
            //store(OutputStream out, String comments) 后面的comments为描述文件，可以设置任意内容
            properties1.store(fileOutputStream,"FutureTest");//properties中store方法改变文件中的内容
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
}

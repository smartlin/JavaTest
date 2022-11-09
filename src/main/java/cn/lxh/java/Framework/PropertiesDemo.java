package cn.lxh.java.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * properties 操作
 * 在*.properties 属性文件中不能直接使用中文，需要转码，使用工具为java安装目录bin下的native2ascii.exe 文件
 * author:1762
 * Date:2015/09/12
 * Time:22:51
 */
public class PropertiesDemo {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
      //  pro.setProperty("BJ","北京");
       // pro.setProperty("TJ", "天津");
//        System.out.println(pro.getProperty("GZ"));//没有属性返回null
//        System.out.println(pro.getProperty("GZ","没有信息"));//没有属性返回null
//        System.out.println(pro);
        //PropertiesDemoTest 为描述，不能写中文 store()保存属性
        //利用输出流创建属性文件
       // pro.store(new FileOutputStream(new File("d:" + File.separator + "FutureTest.properties")),"PropertiesDemoTest");

        //读取属性文件
        pro.load(new FileInputStream(new File("d:" + File.separator + "FutureTest.properties")));
        System.out.println(pro.getProperty("BJ"));
        System.out.println(pro.getProperty("GZ"));
    }
}

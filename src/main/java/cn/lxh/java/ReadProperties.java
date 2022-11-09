package cn.lxh.java;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 读属性文件
 * Created by starlin
 * on 2015/09/29 9:39.
 */
public class ReadProperties {
    public static void main(String[] args) throws Exception{
        Properties pro = new Properties();
        pro.load(new FileInputStream(new File("d:" + File.separator + "reflect.properties")));
        System.out.println(pro.getProperty("cn.lxh.java.reflection"));
    }
}

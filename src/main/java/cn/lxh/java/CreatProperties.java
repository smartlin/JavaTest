package cn.lxh.java;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * 创建属性文件直接操作客户端的cn.starlin.reflect.Email
 * Created by starlin
 * on 2015/09/29 9:30.
 */
public class CreatProperties {
    public static void main(String[] args) throws Exception{
        Properties pro = new Properties();
        pro.setProperty("cn.starlin.reflect","Email");
        pro.setProperty("BJ","北京");
        pro.store(new FileOutputStream(new File("d:" + File.separator + "reflect.properties")),"PropertiesDemoTest");
    }
}

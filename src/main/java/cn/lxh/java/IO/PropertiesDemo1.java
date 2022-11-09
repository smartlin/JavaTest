package cn.lxh.java.IO;

import java.io.*;
import java.util.Properties;

/**
 * 利用属性文件记录程序运行的次数
 * Created by starlin
 * on 2015/11/05 15:42.
 */
public class PropertiesDemo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separator + "count.ini");
        if(!file.exists()){
            file.createNewFile();

        }
        FileInputStream fis = new FileInputStream(file);
        Properties ps = new Properties();
        ps.load(fis);//加载文件
        int count = 0;
        String value = ps.getProperty("time");
        if(value!=null){
            count = Integer.parseInt(value);
            if(count>=5){
                System.out.println("超过使用次数");
                return;
            }
        }
        count++;
        ps.setProperty("time",count+"");

        FileOutputStream fos = new FileOutputStream(file);
        ps.store(fos,"");//把内存中的数据写入到文件中时，必须使用该方法
        fis.close();
        fos.close();
    }
}

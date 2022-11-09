package cn.lxh.java.IO;

import java.io.*;
import java.util.Properties;

/**
 * ���������ļ���¼�������еĴ���
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
        ps.load(fis);//�����ļ�
        int count = 0;
        String value = ps.getProperty("time");
        if(value!=null){
            count = Integer.parseInt(value);
            if(count>=5){
                System.out.println("����ʹ�ô���");
                return;
            }
        }
        count++;
        ps.setProperty("time",count+"");

        FileOutputStream fos = new FileOutputStream(file);
        ps.store(fos,"");//���ڴ��е�����д�뵽�ļ���ʱ������ʹ�ø÷���
        fis.close();
        fos.close();
    }
}

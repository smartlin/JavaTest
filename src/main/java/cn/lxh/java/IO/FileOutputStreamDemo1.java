package cn.lxh.java.IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 字节输出流OutputStream
 * 字节输出流是以byte为主，字符输出流是以char为主，而且支持String的直接操作
 * author:1762
 * Date:2015/09/08
 * Time:21:10
 */
public class FileOutputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        File file = new File("d:" + File.separator + "FutureTest" + File.separator + "demo.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
//        OutputStream output = new FileOutputStream(file);//通过OutputStream的子类对象为父类对象实例化
//        //OutputStream output = new FileOutputStream(file,true);//通过OutputStream的子类对象为父类对象实例化，追加内容
//        String msg = "demo world \r\n";//要输出的对象
//        byte data[] = msg.getBytes();//字符串转换为byte
//      //  output.write(data);//将字节数组全部输出
//        output.write(data,0,5);//限定输出范围，当前只输出5个
//        output.close();//关闭流

        OutputStream output = new FileOutputStream(file);//通过OutputStream的子类对象为父类对象实例化
        String msg = "demo world \r\n";//要输出的对象
//        byte data[] = msg.getBytes();//字符串转换为byte
//        for(int i = 0 ;i<data.length; i++){
//            output.write(data[i]);
//        }
        //也可以写成下面这样
        for(int i = 0;i < msg.length();i++){
            output.write(msg.charAt(i));
        }
        output.close();
    }
}

package cn.lxh.java.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 字节输入InputStream
 * 字节流当程序在处理二进制数据（图片，音乐，电影）或者进行网络传输，或者保存到磁盘数据，一定是字节流操作
 * author:1762
 * Date:2015/09/08
 * Time:21:58
 */
public class FileInputStreamDemo2 {
    public static void main(String[] args) throws Exception{
        File file = new File("d:" + File.separator + "FutureTest" + File.separator + "demo.txt");
//        if(file.exists()){
//            InputStream input = new FileInputStream(file);//实例化输入流对象
//            byte data[] = new byte[2014];//此数组用于接收全部输入的数据
//            int len = input.read(data,0,2014);//读取全部数据
//            //int len = input.read(data,0,10);//读取10个字节
//            System.out.println("[" + new String(data,0,len) + "]");//将数组变为字符串
//            input.close();
//        }
        if(file.exists()){
            InputStream input = new FileInputStream(file);
            byte data[] = new byte[2014];
            int temp = 0;//接收每次读取进来的数据
            int foot = 0;//定义数组的脚标
            //temp = input.read() 表示读取单个的字符 (temp = input.read()) != -1表示判断temp的内容是否是-1（表示已经读到结尾了） 若不是继续读
            while ((temp = input.read()) != -1) {
                 data[foot++] = (byte) temp;
            }
            input.close();
            System.out.println(new String(data,0,foot));
        }
    }

}

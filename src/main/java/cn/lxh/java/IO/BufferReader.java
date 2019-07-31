package cn.lxh.java.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

/**
 * 利用BufferReader实现键盘操作 字符流
 * BufferReader提供了一个读取一行的方法readline()
 * 当返回null时，表示读取的是文件末尾,并且只返回回车符之前的内容，并不返回回车符
 * String len = null;
   while((len=buf.readLine())!=null){
         System.out.println(len);
   }
 * author:1762
 * Date:2015/09/10
 * Time:21:03
 */
public class BufferReader {
    public static void main(String[] args) throws Exception{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));//键盘录入最常用写法
        System.out.println("请输入数据");
        String str = buf.readLine();//读取一行数据
        System.out.println(str);



        System.out.println("请输入生日：");
        String msg = buf.readLine();//读取一行数据
        if(msg.matches("\\d{4}-\\d{2}-\\d{2}")){
            System.out.println(new SimpleDateFormat("yyy-MM-hh").parse(msg));
        }else {
            System.out.println("输入错误");
        }

        buf.close();
    }

}

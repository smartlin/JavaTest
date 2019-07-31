package cn.lxh.java.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/**
 * Write 字符流输出
 * 字符流当程序在处理中文的时候，字符流最方便
 * author:1762
 * Date:2015/09/08
 * Time:22:44
 */
public class WriteDemo {
    public static void main(String[] args) throws  Exception{
        File file = new File("d:" + File.separator + "FutureTest" + File.separator + "demo.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().createNewFile();
        }
        Writer out = new FileWriter(file);
        String msg = "Hello World";
        out.write(msg);//直接输出字符串
        out.close();
    }
}

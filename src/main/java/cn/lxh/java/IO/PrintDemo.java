package cn.lxh.java.IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * author:1762
 * Date:2015/09/10
 * Time:21:16
 */
public class PrintDemo {
    public static void main(String[] args) throws Exception{
        PrintStream pu = new PrintStream(new FileOutputStream(new File("d:" + File.separator + "11.txt")));
        pu.print("姓名：");
        pu.println("张三");
        pu.println(1 + 1);
        pu.print("成绩");
        pu.println(90.2);
        pu.print(new StringBuffer("demo"));
        pu.close();
    }
}

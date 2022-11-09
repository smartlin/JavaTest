package cn.lxh.java.IO;

import java.io.File;
import java.io.FileReader;

/**
 * Reader 字符流输入
 * author:1762
 * Date:2015/09/08
 * Time:22:51
 */
public class ReaderDemo {
    public static void main(String[] args) throws Exception{
        File file = new File("file: /d:" + File.separator  + "demo.txt");
        if(file.exists()){
            FileReader in = new FileReader(file);
            char[] data = new char[1024];//一般定义数组的长度为1024的整数倍
            int len = 0;
            while((len=in.read(data))!=-1) {//等于-1表示读完了
                System.out.println(new String(data, 0, len));//这里使用了String里面的方法 String(char[] value, int offset, int count)
            }
            in.close();
        }
    }
}

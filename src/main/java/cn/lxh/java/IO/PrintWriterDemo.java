package cn.lxh.java.IO;

import java.io.*;

/**
 * PrintWriter构造函数可以接收的参数类型
 * 1.file对象。File
 * 2.字符串路劲 String
 * 3.字节输出流 OutputStream
 * 4.字符输出流 Writer
 * Created by starlin
 * on 2015/11/05 16:23.
 */
public class PrintWriterDemo {
    public static void main(String[] args) throws IOException {
//        File file = new File("d:" + File.separator + "pw.txt");
//        if(!file.exists()){
//            file.createNewFile();
//        }
//        PrintWriter pw = new PrintWriter(new FileOutputStream(file));
//        pw.println("11");
//        pw.println("22");
//        pw.println("demo");
//        pw.close();
        File file = new File("d:" + File.separator + "pw.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new FileWriter(file),true);
        String line = null;
        while((line = br.readLine())!=null){
            if("over".equals(line))
                break;
            pw.println(line);
        }
        pw.close();
        br.close();
    }
}

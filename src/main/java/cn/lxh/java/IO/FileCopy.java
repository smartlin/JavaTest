package cn.lxh.java.IO;

import java.io.*;

/**
 * 文件拷贝
 * author:1762
 * Date:2015/09/09
 * Time:20:59
 */
public class FileCopy {
    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();
//        if(args.length != 2){//输入的参数不足2个
//            System.out.println("命令语法错误");
//            System.exit(1);
//        }
        File infile = new File(args[0]);//源文件
        if(!infile.exists()){
            System.out.println("源文件不存在");
            System.exit(1);
        }
        File outfile = new File(args[1]);//目标文件
        if(!outfile.getParentFile().exists()){
            outfile.getParentFile().mkdirs();
        }
        byte data[] = new byte[2048];
        InputStream input = new FileInputStream(infile);//输入流
        OutputStream output = new FileOutputStream(outfile);//输出流
        int temp = 0;
        while((temp = input.read(data))!=-1){//有内容读取
            output.write(data,0,temp);//输出内容
        }
        input.close();
        output.close();
        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end - start));
    }
}

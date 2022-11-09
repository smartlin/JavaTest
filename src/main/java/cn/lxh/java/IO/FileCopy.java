package cn.lxh.java.IO;

import java.io.*;

/**
 * �ļ�����
 * author:1762
 * Date:2015/09/09
 * Time:20:59
 */
public class FileCopy {
    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();
//        if(args.length != 2){//����Ĳ�������2��
//            System.out.println("�����﷨����");
//            System.exit(1);
//        }
        File infile = new File(args[0]);//Դ�ļ�
        if(!infile.exists()){
            System.out.println("Դ�ļ�������");
            System.exit(1);
        }
        File outfile = new File(args[1]);//Ŀ���ļ�
        if(!outfile.getParentFile().exists()){
            outfile.getParentFile().mkdirs();
        }
        byte data[] = new byte[2048];
        InputStream input = new FileInputStream(infile);//������
        OutputStream output = new FileOutputStream(outfile);//�����
        int temp = 0;
        while((temp = input.read(data))!=-1){//�����ݶ�ȡ
            output.write(data,0,temp);//�������
        }
        input.close();
        output.close();
        long end = System.currentTimeMillis();
        System.out.println("����ʱ�䣺" + (end - start));
    }
}

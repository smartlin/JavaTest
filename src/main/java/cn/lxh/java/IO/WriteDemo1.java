package cn.lxh.java.IO;

import java.io.*;

/**
 * author:1762
 * Date:2015/09/09
 * Time:15:54
 */
public class WriteDemo1 {
    public static void main(String[] args) throws Exception{
        File file = new File("d:" + File.separator + "FutureTest" + File.separator + "demo.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        String msg = "Hello world";
        OutputStream out = new FileOutputStream(file);
        byte data1[] = msg.getBytes();
        for(int i = 0;i<msg.length();i++){
            out.write(msg.charAt(i));
        }

//        Reader rd = new FileReader(file);
//        char data[] = new char[1024];
//        int len = rd.read(data);
//        System.out.println(new String(data,0,len));
//        rd.close();
        InputStream input = new FileInputStream(file);
        byte data[] = new byte[1024];
        int temp = 0;
        int foot = 0;
        while ((temp = input.read())!=-1){
            data[foot++] = (byte) temp;
        }
        input.close();
        System.out.println(new String(data,0,foot));
    }
}

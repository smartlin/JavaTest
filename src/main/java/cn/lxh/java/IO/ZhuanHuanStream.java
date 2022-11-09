package cn.lxh.java.IO;

import java.io.*;

/**
 * InputStreamReader  OutputStreamWriter 转换流
 * Created by starlin
 * on 2015/11/03 9:34.
 */
public class ZhuanHuanStream {
    public static void main(String[] args) throws IOException {
//        BufferedInputStreamDemo();
        BufferedOutputStreamDemo();
    }
    public static void BufferedInputStreamDemo() throws IOException{
//        InputStream in = System.in;
//        InputStreamReader is = new InputStreamReader(in);//将字节流转换为字符流
//        BufferedReader bri  = new BufferedReader(is);
        //简写为一句话
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//键盘录入最常用写法
        String len = null;
        while((len = br.readLine())!=null){
            if("over".equals(len)){
                break;
            }
            System.out.println(len.toUpperCase());
        }
        br.close();
    }
    //BufferedOutputStreamDemo
    public static void BufferedOutputStreamDemo() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        OutputStream out = System.out;
//        OutputStreamWriter isw = new OutputStreamWriter(out);//将字节流转换为字符流
//        BufferedWriter briw  = new BufferedWriter(isw);
        //上面3句简写为一句
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String len = null;
        while((len = br.readLine())!=null){
            if("over".equals(len)){
                break;
            }
            bw.write(len.toUpperCase());
            bw.newLine();
            bw.flush();
       }
        bw.close();
    }
}

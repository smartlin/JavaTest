package cn.lxh.java.IO;

import java.io.*;

/**
 * 字节流实现文件copy
 * Created by starlin
 * on 2015/11/06 15:01.
 */
public class tttt {
    public static void main(String[] args) throws IOException {
     //   ziJieLiuCopy();//字节流实现文件copy
//        ziFuLiuCopy();//字符流时间文件copy
//        InputStreamReaderDemo(); //转换流InputStreamReader
        OutputStreamWriterDemo();//转换流OutputStreamWriter
    }
    //字符流文件copy
    public static void ziFuLiuCopy() throws IOException {
        //源文件
        File inpFile = new File("d:" + File.separator + "11.txt");
        if(!inpFile.exists()){
            System.out.println("源文件不存在");
            System.exit(1);
        }
        //目标文件
        File outFile = new File("d:" + File.separator + "22.txt");
        if(!outFile.exists()){
            outFile.createNewFile();
        }
        BufferedReader is = new BufferedReader(new FileReader(inpFile));//定义缓冲区BufferedInputStream，提高效率
        BufferedWriter os = new BufferedWriter(new FileWriter(outFile));//定义缓冲区BufferedOutputStream，提高效率
        char[] ch = new char[1024];
        int len = 0;
        while((len = is.read(ch))!=-1){
            os.write(ch,0,len);
        }
        is.close();
        os.close();
    }
    //字节流文件copy
    public static void ziJieLiuCopy() throws IOException {
        //源文件
        File inpFile = new File("d:" + File.separator + "11.txt");
        if(!inpFile.exists()){
            System.out.println("源文件不存在");
            System.exit(1);
        }
        //目标文件
        File outFile = new File("d:" + File.separator + "22.txt");
        if(!outFile.exists()){
            outFile.createNewFile();
        }
        InputStream is = new BufferedInputStream(new FileInputStream(inpFile));//定义缓冲区BufferedInputStream，提高效率
        OutputStream os = new BufferedOutputStream(new FileOutputStream(outFile));//定义缓冲区BufferedOutputStream，提高效率
        byte[] ch = new byte[1024];
        int len = 0;
        while((len = is.read(ch))!=-1){
            os.write(ch,0,len);
        }
        is.close();
        os.close();
    }
    //转换流InputStreamReader  OutputStreamWriter
    public static void InputStreamReaderDemo() throws IOException{
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
    public static void OutputStreamWriterDemo() throws IOException{
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

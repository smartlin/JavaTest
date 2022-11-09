package cn.lxh.java.IO;

import java.io.*;

/**
 * InputStreamReader  OutputStreamWriter ת����
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
//        InputStreamReader is = new InputStreamReader(in);//���ֽ���ת��Ϊ�ַ���
//        BufferedReader bri  = new BufferedReader(is);
        //��дΪһ�仰
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//����¼�����д��
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
//        OutputStreamWriter isw = new OutputStreamWriter(out);//���ֽ���ת��Ϊ�ַ���
//        BufferedWriter briw  = new BufferedWriter(isw);
        //����3���дΪһ��
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

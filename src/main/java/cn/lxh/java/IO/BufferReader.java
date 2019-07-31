package cn.lxh.java.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

/**
 * ����BufferReaderʵ�ּ��̲��� �ַ���
 * BufferReader�ṩ��һ����ȡһ�еķ���readline()
 * ������nullʱ����ʾ��ȡ�����ļ�ĩβ,����ֻ���ػس���֮ǰ�����ݣ��������ػس���
 * String len = null;
   while((len=buf.readLine())!=null){
         System.out.println(len);
   }
 * author:1762
 * Date:2015/09/10
 * Time:21:03
 */
public class BufferReader {
    public static void main(String[] args) throws Exception{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));//����¼�����д��
        System.out.println("����������");
        String str = buf.readLine();//��ȡһ������
        System.out.println(str);



        System.out.println("���������գ�");
        String msg = buf.readLine();//��ȡһ������
        if(msg.matches("\\d{4}-\\d{2}-\\d{2}")){
            System.out.println(new SimpleDateFormat("yyy-MM-hh").parse(msg));
        }else {
            System.out.println("�������");
        }

        buf.close();
    }

}

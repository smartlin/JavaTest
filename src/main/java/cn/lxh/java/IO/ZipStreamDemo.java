package cn.lxh.java.IO;

import java.io.*;
import java.util.zip.*;

/**
 * Created by starlin
 * on 2015/11/05 21:00.
 */
public class ZipStreamDemo {
    public static void main(String[] args) throws IOException{
        ZipInputStream zs = new ZipInputStream(new FileInputStream("d:" + File.separator + "1.zip" ));
        ZipEntry ze = null;
        int len = 0;
        while ((ze = zs.getNextEntry())!=null){
            FileOutputStream fout = new FileOutputStream(ze.getName());
            while ((len = zs.read())!=-1){
                fout.write(len);
                zs.closeEntry();
                fout.flush();
                fout.close();
            }
        }
        zs.close();
//        File file = new File("d:" + File.separator + "1.zip") ;   // ����ѹ���ļ�����
//        File outFile = null ;   // ����ļ���ʱ��Ҫ���ļ��еĲ���
//        ZipFile zipFile = new ZipFile(file) ;   // ʵ����ZipFile����
//        ZipInputStream zipInput = null ;    // ����ѹ��������
//        OutputStream out = null ;   // ������������������ÿһ��ʵ������
//        InputStream input = null ;  // ��������������ȡÿһ��ZipEntry
//        ZipEntry entry = null ; // ÿһ��ѹ��ʵ��
//        zipInput = new ZipInputStream(new FileInputStream(file)) ;  // ʵ����ZIpInputStream
//        while((entry = zipInput.getNextEntry())!=null){ // �õ�һ��ѹ��ʵ��
//            System.out.println("��ѹ��" + entry.getName() + "�ļ���") ;
//            outFile = new File("d:" + File.separator + entry.getName()) ;   // ����������ļ�·��
//            if(!outFile.getParentFile().exists()){  // �������ļ��в�����
//                outFile.getParentFile().mkdir() ;   // �����ļ���
//            }
//            if(!outFile.exists()){  // �ж�����ļ��Ƿ����
//                outFile.createNewFile() ;   // �����ļ�
//            }
//            input = zipFile.getInputStream(entry) ; // �õ�ÿһ��ʵ���������
//            out = new FileOutputStream(outFile) ;   // ʵ�����ļ������
//            int temp = 0 ;
//            while((temp=input.read())!=-1){
//                out.write(temp) ;
//            }
//            input.close() ;     // �ر�������
//            out.close() ;   // �ر������
//        }
//        input.close() ;
    }
}

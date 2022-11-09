package cn.lxh.java.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ��������ɺ���ļ�·��д���ļ���
 * Created by starlin
 * on 2015/11/04 22:35.
 */
public class FileListDemo {
    public static void main(String[] args) {
        File file = new File("d:" + File.separator + "share" );
        List<File> list = new ArrayList<File>();
        FileToList(file,list);
//        System.out.println(list.size());
        //File()���˽����ַ��������ܽ���File����File����ת��ΪString������toString����
        File file1 = new File("d:" + File.separator + "listName.txt");
        ListToFile(list,file1.toString());
    }
    //�Ѳ�ѯ���Ľ��װ�뼯��
    public static void FileToList(File file,List<File> list){
        File[] f = file.listFiles();
        if(f!=null) {
            for (int i = 0; i < f.length; i++) {
                if (f[i].isDirectory()) {
                    FileToList(f[i], list);
                } else {
                    if (f[i].getName().endsWith(".class")) {
//                    System.out.println(f[i]);
                        list.add(f[i]);
                    }
                }
            }
        }
    }
    //��list�еĴ��������д�뵽�ļ���
    public static void ListToFile(List<File> list,String FielName){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(FielName));
            for(File f:list){
                String path = f.getAbsolutePath();
                bw.write(path);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

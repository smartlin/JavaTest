package cn.lxh.java.IO;

import java.io.File;

/**
 * File��������
 * ������createNewFile()   �����ļ���mkdir() �����༶�ļ���mkdirs()
 * ɾ����delete()
 * �жϣ�exists()�Ƿ���� isFile()�Ƿ�Ϊ�ļ� isDirectory()�Ƿ�Ϊ�ļ���
 * ��ȡ��Ϣ��getName() getPath() getParent() lastModified()
 * Created by starlin
 * on 2015/11/04 19:56.
 */
public class FileDemo {
    public static void main(String[] args) {
        //******************************************
//        File f = new File("d:" + File.separator + "file.txt");
//        try {
//            System.out.println(f.createNewFile());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //******************************************
//
//        //�����ļ��������ڲ��� FilenameFilter�ӿ�***************
//        File file = new File("d:" + File.separator + "share");
//        String[] str = file.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                return name.endsWith(".class");
//            }
//        });
//        for (String name:str) {
//            System.out.println(name);
//        }
//        //&***************************************************
//
//        //************��ȡ��ǰĿ¼�е��ļ�������listFiles() ****************
//        File file1 = new File("d:" + File.separator + "share");
//        File[] files = file1.listFiles();
//        for (File f1:files) {
//            System.out.println(f1.getName() + "======" + f1.length());
//        }
        //********************************************

        //�ݹ��г�Ŀ¼�µ������ļ�
        File file2 = new File("d:" + File.separator );
        show(file2);

    }
    public static void show(File f){
        //�ݹ��г�����Ŀ¼
//        if(f.exists()&&f.isDirectory()) {
          //  System.out.println(f);
            File[] files1 = f.listFiles();
            if(files1!=null) {
                for (int i = 0; i < files1.length; i++) {
                    if (files1[i].isDirectory()) {//�Ƿ����ļ���
                        show(files1[i]);
                    } else {
                        if(files1[i].getName().endsWith(".txt")){//�г�����txt�ļ�
                            System.out.println(files1[i]);
                        }
                    }
                }
            }
//        }
    }
}

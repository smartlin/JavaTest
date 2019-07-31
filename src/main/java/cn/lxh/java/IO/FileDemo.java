package cn.lxh.java.IO;

import java.io.File;

/**
 * File常见方法
 * 创建：createNewFile()   创建文件夹mkdir() 创建多级文件夹mkdirs()
 * 删除：delete()
 * 判断：exists()是否存在 isFile()是否为文件 isDirectory()是否为文件夹
 * 获取信息：getName() getPath() getParent() lastModified()
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
//        //过滤文件，匿名内部类 FilenameFilter接口***************
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
//        //************获取当前目录中的文件，利用listFiles() ****************
//        File file1 = new File("d:" + File.separator + "share");
//        File[] files = file1.listFiles();
//        for (File f1:files) {
//            System.out.println(f1.getName() + "======" + f1.length());
//        }
        //********************************************

        //递归列出目录下的所有文件
        File file2 = new File("d:" + File.separator );
        show(file2);

    }
    public static void show(File f){
        //递归列出所有目录
//        if(f.exists()&&f.isDirectory()) {
          //  System.out.println(f);
            File[] files1 = f.listFiles();
            if(files1!=null) {
                for (int i = 0; i < files1.length; i++) {
                    if (files1[i].isDirectory()) {//是否是文件夹
                        show(files1[i]);
                    } else {
                        if(files1[i].getName().endsWith(".txt")){//列出所有txt文件
                            System.out.println(files1[i]);
                        }
                    }
                }
            }
//        }
    }
}

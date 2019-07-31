package cn.lxh.java.IO;

import java.io.File;

/**
 * File文件操作
 * author:1762
 * Date:2015/09/08
 * Time:19:51
 */

public class IODemo {
    public static void main(String[] args) throws Exception{
      //  File file = new File("d:\\demo.txt");
//        File file = new File("d:" + File.separator + "demo.txt");  //针对不同平台路径写法不一样
//        if(file.exists()){//判断文件是否存在
//            file.delete();//删除文件
//        }else{
//            file.createNewFile();//创建文件
//        }
//
//        //创建多级目录文件
//        File file1 = new File("d:" + File.separator + "demo" + File.separator + "demo.txt");
//        if(!file1.getParentFile().exists()){
//            file1.getParentFile().mkdirs();//创建多级目录
//        }
//        if(file1.exists()){//判断文件是否存在
//            file1.delete();//删除文件
//        }else{
//            file1.createNewFile();//创建文件
//        }

        //判断是文件还是文件夹
//        File file2 = new File("d:" + File.separator + "demo.txt");
//        if(file2.exists()){
//            System.out.println(file2.isFile()?"是文件":"不是文件夹");//判断是否是文件
//            System.out.println(file2.isDirectory()?"是文件夹":"不是文件夹");//判断是否是文件夹
//            System.out.println("最后一次修改日期："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
//                                 .format(new Date( file2.lastModified())));//取得最后一次修改日期
//            System.out.println("文件大小："+ file2.length()/1024/1024);//取得文件大小
//        }
//        File file3 = new File("d:" + File.separator + "Share");
//        print(file3);

        File file4 = new File("d:" + File.separator + "share");
        print(file4);
    }

    public static  void print(File file){
        if(file.exists() && file.isDirectory()){
            File resulet[] = file.listFiles();//列出文件目录
            if(resulet!=null){
                for(int i=0 ; i<resulet.length;i++){
                    System.out.println(resulet[i]);
                    print(resulet[i]);//递归调用
                }
            }
        }
//        System.out.println(file);
        //file.delete();//删除列出的所有文件 谨慎操作
    }
}
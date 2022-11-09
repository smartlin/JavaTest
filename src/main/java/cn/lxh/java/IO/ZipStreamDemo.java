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
//        File file = new File("d:" + File.separator + "1.zip") ;   // 定义压缩文件名称
//        File outFile = null ;   // 输出文件的时候要有文件夹的操作
//        ZipFile zipFile = new ZipFile(file) ;   // 实例化ZipFile对象
//        ZipInputStream zipInput = null ;    // 定义压缩输入流
//        OutputStream out = null ;   // 定义输出流，用于输出每一个实体内容
//        InputStream input = null ;  // 定义输入流，读取每一个ZipEntry
//        ZipEntry entry = null ; // 每一个压缩实体
//        zipInput = new ZipInputStream(new FileInputStream(file)) ;  // 实例化ZIpInputStream
//        while((entry = zipInput.getNextEntry())!=null){ // 得到一个压缩实体
//            System.out.println("解压缩" + entry.getName() + "文件。") ;
//            outFile = new File("d:" + File.separator + entry.getName()) ;   // 定义输出的文件路径
//            if(!outFile.getParentFile().exists()){  // 如果输出文件夹不存在
//                outFile.getParentFile().mkdir() ;   // 创建文件夹
//            }
//            if(!outFile.exists()){  // 判断输出文件是否存在
//                outFile.createNewFile() ;   // 创建文件
//            }
//            input = zipFile.getInputStream(entry) ; // 得到每一个实体的输入流
//            out = new FileOutputStream(outFile) ;   // 实例化文件输出流
//            int temp = 0 ;
//            while((temp=input.read())!=-1){
//                out.write(temp) ;
//            }
//            input.close() ;     // 关闭输入流
//            out.close() ;   // 关闭输出流
//        }
//        input.close() ;
    }
}

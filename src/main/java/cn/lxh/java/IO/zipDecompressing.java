package cn.lxh.java.IO;
import java.util.zip.*;
import java.io.*;

public class zipDecompressing {

  public static void main(String[] args) {  
    // TODO Auto-generated method stub  
    long startTime=System.currentTimeMillis();  
    try {  
      ZipInputStream Zin=new ZipInputStream(new FileInputStream(  
          "d:" + File.separator + "1.zip"));//����Դzip·��
      BufferedInputStream Bin=new BufferedInputStream(Zin);  
      String Parent="F:\\ziptest\\"; //���·�����ļ���Ŀ¼��  
      File Fout=null;  
      ZipEntry entry;  
      try {  
        while((entry = Zin.getNextEntry())!=null && !entry.isDirectory()){  
          Fout=new File(Parent,entry.getName());  
          if(!Fout.exists()){  
            (new File(Fout.getParent())).mkdirs();  
          }  
          FileOutputStream out=new FileOutputStream(Fout);  
          BufferedOutputStream Bout=new BufferedOutputStream(out);  
          int b;  
          while((b=Bin.read())!=-1){  
            Bout.write(b);  
          }  
          Bout.close();  
          out.close();  
          System.out.println(Fout+"��ѹ�ɹ�");	  
        }  
        Bin.close();  
        Zin.close();  
      } catch (IOException e) {  
        e.printStackTrace();  
      }  
    } catch (FileNotFoundException e) {  
      e.printStackTrace();  
    }  
    long endTime=System.currentTimeMillis();  
    System.out.println("�ķ�ʱ�䣺 "+(endTime-startTime)+" ms");  
  }  

} 
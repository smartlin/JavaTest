package cn.lxh.java.IO;

import java.io.*;

/**
 * Created by starlin
 * on 2015/11/06 13:45.
 */
public class FilenameFilterDemo {
    public static void main(String[] args) {
        File file = new File("d:" + File.separator);
        File[] arrary = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isFile() && name.endsWith(".java");
            }
        });
        for(File f:arrary){
            System.out.println(f.getName());
        }
    }
}

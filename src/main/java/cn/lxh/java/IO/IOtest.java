package cn.lxh.java.IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by starlin
 * on 2015/11/01 23:33.
 */
public class IOtest {
    public static void main(String[] args) throws IOException {
        FileReader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader("d:\\my.txt");
            writer = new FileWriter("d:\\1.txt");
            char[] data = new char[2048];
            int len = 0;
            while ((len=reader.read(data))!=-1){
                writer.write(data,0,len);
            }
        }catch (IOException e){
            throw new RuntimeException("¶ÁÐ´Ê§°Ü");
        }finally {
            reader.close();
            writer.close();
        }

    }
}

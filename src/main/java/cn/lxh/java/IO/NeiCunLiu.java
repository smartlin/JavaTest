package cn.lxh.java.IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 内存流
 * author:1762
 * Date:2015/09/09
 * Time:22:05
 */
public class NeiCunLiu {
    public static void main(String[] args) throws Exception{
        String str = "demo world";
        InputStream input = new ByteArrayInputStream(str.getBytes());
        OutputStream output = new ByteArrayOutputStream();
        int temp = 0;
        while((temp = input.read())!= -1){
            output.write(Character.toUpperCase(temp));
        }
        String msg = output.toString();
        input.close();
        output.close();
        System.out.println(msg);
    }
}

package cn.lxh.java.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 利用Scanner读取文件
 * author:1762
 * Date:2015/09/10
 * Time:20:57
 */
public class ScannerDemo {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(new FileInputStream(new File("d:" + File.separator + "my.txt")));
            scan.useDelimiter("\n");
            while(scan.hasNext()){
                System.out.println(scan.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

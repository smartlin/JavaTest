package cn.lxh.java.IO;

import java.io.IOException;

/**
 * Created by starlin
 * on 2015/11/01 15:56.
 */
public class RunTimeDemo {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process p = runtime.exec("notepad.exe");//execִ��
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.destroy();//����
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

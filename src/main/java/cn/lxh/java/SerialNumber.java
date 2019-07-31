package cn.lxh.java;

import java.io.*;

public class SerialNumber {
    public String executeVolCommand() {
        String NEWLINE = System.getProperty("line.separator");
        StringBuffer buffer = new StringBuffer();
        try {

            Process pb = new ProcessBuilder("cmd", "/c", "vol").start();
            InputStream in = pb.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null) {
                buffer.append(line + NEWLINE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        new SerialNumber().executeVolCommand();
    }
}
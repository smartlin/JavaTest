package cn.lxh.java.IO;import java.io.FileNotFoundException;import java.io.PrintStream;/** * 打印系统信息 * author:1762 * Date:2015/09/09 * Time:21:47 */public class SystemProperties {    public static void main(String[] args) throws FileNotFoundException {        System.getProperties().list(System.out);        System.getProperties().list(new PrintStream("d:\\info.txt"));//将输出信息指定到相关目录    }}
package cn.lxh.java.string;

/**
 * Created by starlin
 * on 2015/10/04 20:17.
 */
public class SplitDemo {
    public static void main(String[] args) {
        String str = "192.168.1.1";
        String [] result = str.split("\\.");//若拆分要求有敏感字符（正则表达式），需使用\\
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
        String star = "张三:20|李四:21|王五:22";
        String [] result1 = star.split("\\|");
        for(int i=0;i<result1.length;i++){
            String temp [] = result1[i].split(":");
            System.out.println(temp[0] + " " + temp[1] );
        }
    }
}

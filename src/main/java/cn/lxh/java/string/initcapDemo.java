package cn.lxh.java.string;

/**
 * 定义首字母大写方法
 * Created by starlin
 * on 2015/10/04 21:07.
 */
public class initcapDemo {
    public static void main(String[] args) {
        String str = "demo";
        System.out.println(initcap(str));
    }
    public static String initcap(String temp){
        return temp.substring(0,1).toUpperCase() + temp.substring(1);
    }
}

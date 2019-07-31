package cn.lxh.java.string;

/**
 * 字符串查找
 * Created by starlin
 * on 2015/10/04 19:45.
 */
public class FindStringDemo {
    public static void main(String[] args) {
        String str = "HelloWorld陆鲸";
        System.out.println(str.indexOf("World"));//indexof返回满足条件的第一个字母的索引
        System.out.println(str.indexOf("l",5));//从第5个位置开始查找
        System.out.println(str.lastIndexOf("l"));//从后开始查找
        //从jdk1.5开始使用contains直接返回boolean
        if(str.contains("陆鲸")){
            System.out.println("找到了");
        }
        String string = "**@@*hellworld##";
        System.out.println(string.startsWith("**"));//针对开头和结尾的判断
        System.out.println(string.startsWith("@@",2));//针对开头和结尾的判断
        System.out.println(string.endsWith("##"));//针对开头和结尾的判断
    }
}

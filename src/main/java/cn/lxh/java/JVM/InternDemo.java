package cn.lxh.java.JVM;

/**
 * Created by starlin
 * on 2018/8/24 22:00.
 * intern()方法会先查询常量池中是否已经存在，如果存在则返回常量池中的引用
 * 在JDK1.7之后，如果常量池中找不到对应的字符串，则不会在将字符串拷贝至常量池
 * 而只是在常量池中生成一个对原字符串的引用
 */
public class InternDemo {
    public static void main(String[] args) {

        String str3 = new StringBuilder("sss").append("xxx").toString();
        String str2 = str3.intern();
        System.out.println(str2 == str3);
        //
        //String s1=new String("kvill");
        //String s2=s1.intern();
        //System.out.println(s2.intern() == s2);
        //
        //String s3=new String("kill");
        //String s4=s3.intern();
        //System.out.println(s3.intern() == s4);

        String str1 = new StringBuffer("ja").append("va").toString();
        String str4 = str1.intern();
        System.out.println(str4 == str1);


    }
}

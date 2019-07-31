package cn.lxh.java.string;

/**
 * Created by starlin
 * on 2016/06/01 14:00.
 */
public class Append1 {
    public static void main(String[] args) {
        String str[] = { "hello", "beijing", "world", "shenzhen" };
        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < str.length; i++) {
            buf.append(str[i]).append(",");
        }

        if (buf.length() > 0) {
            //方法一  : substring
            System.out.println(buf.substring(0, buf.length()-1));
            //方法二 ：replace
            System.out.println(buf.replace(buf.length() - 1, buf.length(), ""));
            //方法三： deleteCharAt
            System.out.println(buf.deleteCharAt(buf.length()-1));
        }
    }
}

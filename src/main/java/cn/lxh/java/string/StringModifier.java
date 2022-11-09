package cn.lxh.java.string;

import java.lang.reflect.Field;

/**
 * 改变字符串的值
 */
public class StringModifier {
    public static void main(String[] str){
        try {
            String test="aaaa";
            String test2 =test;
            String test3 = new String(test);
            String test4 = new String(test.toCharArray());
            Field values = String.class.getDeclaredField("value");
 
            values.setAccessible(true);
            char[] ref = (char [])values.get(test);
            ref[0] = 'b';
            //aaaa后面加空格 和 aaaa后面不加空格 的输出区别
            System.out.println("aaaa"+" "+test+" "+test2+" "+test3+" "+test4 );//aaaa后面加空格
            System.out.println("aaaa"+test+" "+test2+" "+test3+" "+test4 );//aaaa后面不加空格

        } catch (NoSuchFieldException|SecurityException|
            IllegalArgumentException|IllegalAccessException ex) {
        }
    }
}
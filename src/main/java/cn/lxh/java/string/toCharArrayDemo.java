package cn.lxh.java.string;

/**
 * 将字符串变为字符数组toCharArray()；
 * 将字符串变为字节数组getBytes()
 * 将基本数据类型转换为字符串valueOf(基本数据类型)
 * 去除两端空格trim()
 * compareTo()两个字符串比较，比较的是acisii码，s1.compareTo(s2),如果返回的是整数则s1>s2,返回负数s1<s2,返回零则相等
 * Created by starlin
 * on 2015/10/04 14:30.
 */
public class toCharArrayDemo {
    public static void main(String[] args) {
        String temp = "123a4567";
        if(isNumber(temp)){
            System.out.println("字符串由数字组成");
        }else{
            System.out.println("字符串不是由数字组成");
        }
    }
    public static boolean isNumber(String temp){
        char[] str = temp.toCharArray();//将字符串变为字符数组toCharArray()；将字符串变为字节数组getBytes()
        for(int i = 0;i<str.length;i++){
            if(str[i]<'0'||str[i]>'9'){
                return false;
            }
        }
        return true;
    }
}

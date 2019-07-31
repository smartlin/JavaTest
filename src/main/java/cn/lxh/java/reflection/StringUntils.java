package cn.lxh.java.reflection;

/**
 * 将首字母大写方法
 * Created by starlin
 * on 2015/09/29 23:03.
 */
public class StringUntils {
    public static String initcap(String str){
        if(str==null){
            return null;
        }
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
}

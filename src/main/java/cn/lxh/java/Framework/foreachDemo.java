package cn.lxh.java.Framework;

import java.util.ArrayList;
import java.util.List;

/**
 * foreach新的输出，不建议使用
 * author:1762
 * Date:2015/09/12
 * Time:20:10
 */
public class foreachDemo {
    public static void main(String[] args) {
        List<String> all = new ArrayList<String>();
        all.add("Hello");
        all.add("world");
        all.add("Hello1");
        all.add("你好");
         for(String str : all){
             System.out.println(str);
         }
    }
}

package cn.lxh.java.Framework;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 古老的输出Enumeration
 * author:1762
 * Date:2015/09/12
 * Time:19:53
 */
public class EnumerationDemo {
    public static void main(String[] args) throws Exception{
        Vector<String> all = new Vector<String>();
        all.add("Hello");
        all.add("world");
        all.add("Hello1");
        all.add("你好");
        Enumeration<String> enu = all.elements();
        while(enu.hasMoreElements()){//hasNext() 判断是否有数据
            String str = enu.nextElement();//next()取得数据
            System.out.println(str);
        }
    }
}

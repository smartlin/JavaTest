package cn.lxh.java.Framework;

import java.util.Enumeration;
import java.util.Vector;

/**
 * ���ϵ����Enumeration
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
        all.add("���");
        Enumeration<String> enu = all.elements();
        while(enu.hasMoreElements()){//hasNext() �ж��Ƿ�������
            String str = enu.nextElement();//next()ȡ������
            System.out.println(str);
        }
    }
}

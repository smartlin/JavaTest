package cn.lxh.java.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期操作类SimpleDateFormat
 * 将Date转化为String：public final String format(Date date)
 * 将String转化为Date：public Date parse(String source) throw ParseException
 * long与Date转化依靠的是getTime()方法
 * String与基本类型之间的转换依据的是包装类与String valueOf()方法
 * Created by starlin
 * on 2015/10/10 13:26.
 */
public class DateDemo {
    public static void main(String[] args) throws Exception{
        Date date = new Date();
        System.out.println(date.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));//将date型变为String型，调用format方法格式化date对象
        //====将字符串变为日期格式
        String str = "2015-10-10 14:14:14";
        Date date1 = sdf.parse(str);
        System.out.println(date1);
        System.out.println(date1.getTime());
        //======long类型转java.until.date========
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

        long mseconds= 1558057515000L /1000;
        java.util.Date date2 = new Date(mseconds * 1000);
        String str1 = sdf.format(date2);
        System.out.println(str1);

    }
}

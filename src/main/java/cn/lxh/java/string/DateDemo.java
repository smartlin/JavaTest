package cn.lxh.java.string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 1762 on 2015/09/05.
 */
public class DateDemo {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());//getTime 能将date类型转换为long型
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String str = sdf.format(date);//日期格式化
        System.out.println(str);


        String date1 = "2015-09-05 21:34:21:074";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        Date str1 = sdf1.parse(date1);//字符串转换为日期
        System.out.println(str1);
    }
}

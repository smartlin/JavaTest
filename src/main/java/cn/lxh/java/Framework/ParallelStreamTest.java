package cn.lxh.java.Framework;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by starlin
 * on 2022/12/27 10:33.
 * 现象：使用parallelStream运行结果存在一些重复的情况
 * 结论：在使用parallelStream().forEach()时,操作了线程不安全的对象
 * 本例子中为SimpleDateFormat对象的format方法
 * format()方法中操作了一个成员变量calendar,且该方法上未加同步锁,说明该方法在多线程并发访问时,存在线程安全问题.这就是上面测试代码中出现重复数据的根本原因.
 */
public class ParallelStreamTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Calendar> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Calendar startDay = new GregorianCalendar();
            Calendar checkDay = new GregorianCalendar();
            checkDay.setTime(startDay.getTime());//不污染入参
            checkDay.add(checkDay.DATE,i);
            list.add(checkDay);
            checkDay = null;
            startDay = null;
        }
        //使用stream().forEach(),就是单纯的串行遍历循环,和使用for循环得到的效果一样,只是这种方式可以使代码更精简;
        list.stream().forEach(day ->  System.out.println(sdf.format(day.getTime())));
        System.out.println("-----------------------");
        //使用parallelStream().forEach(),是并行遍历循环,相当于是使用了多线程处理.
        //这样可以在一定程度上提高执行效率.而程序在运行过程中具体会使用多少个线程进行处理,系统会根据运行服务器的资源占用情况自动进行分配.
        list.parallelStream().forEach(day ->  System.out.println(sdf.format(day.getTime())));
        System.out.println("-----------------------");
    }
}

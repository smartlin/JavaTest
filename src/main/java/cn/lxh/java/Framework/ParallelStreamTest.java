package cn.lxh.java.Framework;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by starlin
 * on 2022/12/27 10:33.
 * ����ʹ��parallelStream���н������һЩ�ظ������
 * ���ۣ���ʹ��parallelStream().forEach()ʱ,�������̲߳���ȫ�Ķ���
 * ��������ΪSimpleDateFormat�����format����
 * format()�����в�����һ����Ա����calendar,�Ҹ÷�����δ��ͬ����,˵���÷����ڶ��̲߳�������ʱ,�����̰߳�ȫ����.�����������Դ����г����ظ����ݵĸ���ԭ��.
 */
public class ParallelStreamTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Calendar> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Calendar startDay = new GregorianCalendar();
            Calendar checkDay = new GregorianCalendar();
            checkDay.setTime(startDay.getTime());//����Ⱦ���
            checkDay.add(checkDay.DATE,i);
            list.add(checkDay);
            checkDay = null;
            startDay = null;
        }
        //ʹ��stream().forEach(),���ǵ����Ĵ��б���ѭ��,��ʹ��forѭ���õ���Ч��һ��,ֻ�����ַ�ʽ����ʹ���������;
        list.stream().forEach(day ->  System.out.println(sdf.format(day.getTime())));
        System.out.println("-----------------------");
        //ʹ��parallelStream().forEach(),�ǲ��б���ѭ��,�൱����ʹ���˶��̴߳���.
        //����������һ���̶������ִ��Ч��.�����������й����о����ʹ�ö��ٸ��߳̽��д���,ϵͳ��������з���������Դռ������Զ����з���.
        list.parallelStream().forEach(day ->  System.out.println(sdf.format(day.getTime())));
        System.out.println("-----------------------");
    }
}

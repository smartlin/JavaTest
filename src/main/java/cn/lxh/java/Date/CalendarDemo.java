package cn.lxh.java.Date;

import java.util.Calendar;

/**
 * Calendar��Ĳ���
 * Created by starlin
 * on 2015/10/10 14:16.
 */
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar cl = Calendar.getInstance();
        StringBuffer sb = new StringBuffer();
        sb.append(cl.get(Calendar.YEAR)).append("��-");
        sb.append(cl.get(Calendar.MONTH)+1).append("��-");
        sb.append(cl.get(Calendar.DAY_OF_MONTH)).append("�� ");
        sb.append(cl.get(Calendar.HOUR_OF_DAY)).append(":");
        sb.append(cl.get(Calendar.MINUTE)).append(":");
        sb.append(cl.get(Calendar.SECOND));
        System.out.println(sb.toString());
    }
}

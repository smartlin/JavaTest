package cn.lxh.java.Date4Java8;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 * Created by starlin
 * on 2020/9/22 17:40.
 */
public class Date8Test {
    public static void main(String[] args) throws ParseException {
        //ʹ�øղŶ����DateTimeFormatterBuilder������DateTimeFormatter���������ʱ��
        LocalDateTime localDateTime = LocalDateTime.parse("2020/1/2 12:34:56.789", dateTimeFormatter);
        //�����ɹ�
        System.out.println(localDateTime.format(dateTimeFormatter));
        // ʹ��yyyyMM��ʽ����20160901�Ƿ���Գɹ��أ�
        String dt = "20160901";
        //DateTimeFormatter �Ľ����Ƚ��ϸ���Ҫ�������ַ����͸�ʽ��ƥ��ʱ����ֱ�ӱ���
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMM");
        System.out.println("result:" + dateTimeFormatter.parse(dt));
    }

    private static DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
            .appendValue(ChronoField.YEAR)//��
            .appendLiteral("/")
            .appendValue(ChronoField.MONTH_OF_YEAR) //��
            .appendLiteral("/")
            .appendValue(ChronoField.DAY_OF_MONTH) //��
            .appendLiteral(" ") .appendValue(ChronoField.HOUR_OF_DAY) //ʱ
            .appendLiteral(":") .appendValue(ChronoField.MINUTE_OF_HOUR) //��
            .appendLiteral(":") .appendValue(ChronoField.SECOND_OF_MINUTE) //��
            .appendLiteral(".") .appendValue(ChronoField.MILLI_OF_SECOND) //����
            .toFormatter();
}

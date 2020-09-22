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
        //使用刚才定义的DateTimeFormatterBuilder构建的DateTimeFormatter来解析这个时间
        LocalDateTime localDateTime = LocalDateTime.parse("2020/1/2 12:34:56.789", dateTimeFormatter);
        //解析成功
        System.out.println(localDateTime.format(dateTimeFormatter));
        // 使用yyyyMM格式解析20160901是否可以成功呢？
        String dt = "20160901";
        //DateTimeFormatter 的解析比较严格，需要解析的字符串和格式不匹配时，会直接报错
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMM");
        System.out.println("result:" + dateTimeFormatter.parse(dt));
    }

    private static DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
            .appendValue(ChronoField.YEAR)//年
            .appendLiteral("/")
            .appendValue(ChronoField.MONTH_OF_YEAR) //月
            .appendLiteral("/")
            .appendValue(ChronoField.DAY_OF_MONTH) //日
            .appendLiteral(" ") .appendValue(ChronoField.HOUR_OF_DAY) //时
            .appendLiteral(":") .appendValue(ChronoField.MINUTE_OF_HOUR) //分
            .appendLiteral(":") .appendValue(ChronoField.SECOND_OF_MINUTE) //秒
            .appendLiteral(".") .appendValue(ChronoField.MILLI_OF_SECOND) //毫秒
            .toFormatter();
}

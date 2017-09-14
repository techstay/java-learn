package yitian.study.java8.datetime;

import java.time.*;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.util.Date;

public class DateTimeSample {
    static void oldDate() {
        Date date = new Date();
        System.out.println(date);
    }

    static void newDateTime() {
        //日期
        LocalDate date = LocalDate.now();
        System.out.println(date);
        //时间
        LocalTime time = LocalTime.now();
        System.out.println(time);
        //日期时间
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        LocalDate birthday = LocalDate.of(1994, Month.JANUARY, 18);

    }

    static void datetimeOperations() {
        //日期运算
        LocalDate date = LocalDate.of(1993, 12, 25);
        //十天以后
        LocalDate dateAfter10Days = date.plusDays(10);
        System.out.println("十天以后:" + dateAfter10Days);
        //一个月前
        LocalDate dateBefore1Month = date.minusMonths(1);
        System.out.println("一个月前:" + dateBefore1Month);
        //这个月的最后一天
        LocalDate lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("这个月最后一天:" + lastDayOfMonth);
        //今年第一天
        System.out.println("今年第一天:" + date.with(TemporalAdjusters.firstDayOfYear()));

        //查询
        TemporalQuery<Integer> remainDaysOfYear = temporal -> {
            LocalDate d = LocalDate.from(temporal);
            LocalDate lastDayOfYear = d.with(TemporalAdjusters.lastDayOfYear());
            Period period = d.until(lastDayOfYear);
            return period.getDays();
        };
        int days = date.query(remainDaysOfYear);
        System.out.println("到年底还剩几天:" + days);


    }

    static void formatDateTime() {
        LocalDateTime datetime = LocalDateTime.now();
        //默认toString方法
        System.out.println(datetime);

        //手动格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(
                datetime.format(formatter));

        //字符串到对象
        datetime = LocalDateTime.from(formatter.parse("1993-11-25 12:00:15"));
        System.out.println(datetime);
    }

    static void transformBetweenNewAndOld() {
        //旧日期转换为新日期
        Date date = new Date();
        LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant()
                , ZoneId.of("Asia/Shanghai"));
        System.out.println(dateTime);

        //新日期转换为旧日期
        Date now = Date.from(Instant.now());
        System.out.println(now);
    }

    public static void main(String[] args) {
        oldDate();
        System.out.println("----------------");
        newDateTime();
        System.out.println("----------------");
        datetimeOperations();
        System.out.println("----------------");
        formatDateTime();
        System.out.println("----------------");
        transformBetweenNewAndOld();
    }
}

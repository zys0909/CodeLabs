package com.leecode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainC {
    static long getTime(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss", Locale.CHINA);
            return simpleDateFormat.parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void main(String[] args) {

        long time1 = getTime("20201231 00:59:50");
        long now = getTime("20210101 23:09:50");

        int diffDay = test2(time1, now);
        String result;
        switch (diffDay){
            case -1:
                result = "昨天";
                break;
            case 0:
                result = "今天";
                break;    case 1:
                result = "明天";
                break;
            default:
                if (diffDay < 0){
                    result = -diffDay + "天前";
                } else {
                    result = diffDay + "天后";
                }
                break;
        }
        System.out.println(result);
    }

    private static int test2(long target, long now) {
        long formatTarget = format(target);
        long formatNow = format(now);
        return (int) ((formatTarget - formatNow)/(1000 * 3600 * 24));
    }

    private static long format(long source) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        String str = format.format(new Date(source));
        try {
            return format.parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return source;
        }
    }

    private static void test(long target, long now) {
        LocalDateTime targetLocalDateTime = parse(target);
        System.out.println(targetLocalDateTime.toString());
        LocalDateTime nowLocalDateTime = parse(now);
        System.out.println(nowLocalDateTime.toString());
        Duration duration = Duration.between(targetLocalDateTime, nowLocalDateTime);

        System.out.println("相差 ： " + duration.toDays());
    }

    private static LocalDateTime parse(long timeSimple) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(timeSimple));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        System.out.println(String.format("%d年%d月%d日%d时%d分%d秒", year, month, day, hour, minute, second));
        return LocalDateTime.of(year, month, day, hour, minute, second);
    }

}

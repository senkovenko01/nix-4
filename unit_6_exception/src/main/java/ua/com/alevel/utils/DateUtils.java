package ua.com.alevel.utils;

import ua.com.alevel.entity.Date;
import ua.com.alevel.exceptions.InvalidInput;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class DateUtils {

    public static Date addTimeToData(Date date, int time){
        date.setDataInDayFormat(date.getDataInDayFormat() + time);
        return date;
    }

    public static Date addSecondsToData(Date date, int time){
        int days = date.getTime().setTimeFromSeconds(time + date.getTime().getSeconds());
        DateUtils.addTimeToData(date, days);
        return date;
    }
    public static void subtractData(Date date1, Date date2) {
        BigInteger data = BigInteger.valueOf(Math.abs(date1.getDataInDayFormat() - date2.getDataInDayFormat()));
        BigInteger result = data.multiply(BigInteger.valueOf(86400000));
        BigInteger secondsResult = BigInteger.valueOf(Math.abs(date1.getTime().getSeconds() - date2.getTime().getSeconds()));
        System.out.println("in milliseconds: " + result.add(secondsResult.multiply(BigInteger.valueOf(1000))));
        result = data.multiply(BigInteger.valueOf(86400));
        System.out.println("in seconds: " + result.add(secondsResult));
        result = data.multiply(BigInteger.valueOf(24));
        System.out.println("in hours: " + result.add(secondsResult.divide(BigInteger.valueOf(3600))));
        System.out.println("in days: " + data);
        int inYear = Integer.parseInt(date1.getYear()) - Integer.parseInt(date2.getYear());
        System.out.println("in years: " + inYear);
        System.out.println("in centuries: " + inYear/100);
    }

    public static Date subtractSecondsToData(Date date, int time){
        if (time > date.getTime().getSeconds()) {
            int days = 0;
            while (time > 86400) {
                days++;
                time -= 86400;
            }
            if (time > date.getTime().getSeconds()) {
                time -= date.getTime().getSeconds();
                days++;
            }
            date.getTime().setTimeFromSeconds(86400 - time);
            takeAwayTimeInData(date, days);

        } else {
            date.getTime().setTimeFromSeconds(date.getTime().getSeconds() - time);
        }
        return date;
    }

    public static Date takeAwayTimeInData(Date date, int time){
        if (time >= date.getDataInDayFormat()) {
            throw new InvalidInput(InvalidInput.YEAR_EXCEPTION);
        }
        date.setDataInDayFormat(date.getDataInDayFormat() - time);
        return date;
    }

    public static List<Date> compareData(Date[] arr){
        return stream(arr).sorted(Comparator.comparing(Date::getDataInSeconds)).collect(Collectors.toList());
    }

    public static List<Date> compareDataRevers(Date[] arr){
        return stream(arr).sorted(Comparator.comparing(Date::getDataInSeconds).reversed()).collect(Collectors.toList());
    }
}

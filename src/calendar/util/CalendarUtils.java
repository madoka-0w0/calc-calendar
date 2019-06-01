package calendar.util;

import java.util.HashMap;
import java.util.stream.IntStream;

public class CalendarUtils {
    public static final int FIRST_MONTH = 1;
    public static final int LAST_MONTH = 12;
    public static final int EFFECT_LEAP_YEAR_MONTH = 2;
    public static final HashMap<Integer, Integer> MONTH_OF_DAYS = new HashMap<Integer, Integer>() {
        {
            put(1, 31);
            put(2, 28);
            put(3, 31);
            put(4, 30);
            put(5, 31);
            put(6, 30);
            put(7, 31);
            put(8, 31);
            put(9, 30);
            put(10, 31);
            put(11, 30);
            put(12, 31);
        }
    };

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;

        }
    }

    public static int getDaysOfMonth(int year, int month) {
        if (isMonth(month)) {
            int daysOfMonth = CalendarUtils.MONTH_OF_DAYS.get(month);
            if (isLeapYear(year) && month == EFFECT_LEAP_YEAR_MONTH ) {
                return daysOfMonth + 1;
            }
            return daysOfMonth;
        }
        return 0;
    }

    public static int getDaysOfYear(int year) {
        return IntStream.range(FIRST_MONTH, LAST_MONTH + 1)
                .map(month -> getDaysOfMonth(year, month))
                .sum();
    }

    public static boolean isMonth(int month) {
        return month >= FIRST_MONTH && month <= LAST_MONTH;
    }
}

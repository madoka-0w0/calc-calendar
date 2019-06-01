package calendar.calc;


import calendar.model.Date;
import calendar.util.CalendarUtils;

import java.util.stream.IntStream;

import static calendar.util.CalendarUtils.LAST_MONTH;
import static calendar.util.CalendarUtils.getDaysOfMonth;

public class CalcOneYearCalendar implements CalcDays {

    @Override
    public int passedDays(Date date) {
        int daysOfYear = CalendarUtils.getDaysOfYear(date.getYear());
        int untilDays = this.untilDays(date);
        // 引かれた当日分を追加
        return daysOfYear - (untilDays + 1);
    }

    @Override
    public int untilDays(Date date) {
        int year = date.getYear();

        int daysOfMonthsUtilLastMonth = IntStream.range(date.getMonth(), LAST_MONTH + 1)
                .map(month -> getDaysOfMonth(year, month))
                .sum();

        return daysOfMonthsUtilLastMonth - date.getDay();
    }
}

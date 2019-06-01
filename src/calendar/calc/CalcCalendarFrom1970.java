package calendar.calc;

import calendar.util.CalendarUtils;
import calendar.model.Date;
import calendar.model.Week;

import java.util.stream.IntStream;

public class CalcCalendarFrom1970 implements CalcCalendar {
    private static final Date BASE_DATE = new Date(1970, 1, 1);
    private static final Week WEEK = Week.Thr;
    private static final CalcOneYearCalendar CALC_ONE_YEAR_CALENDAR = new CalcOneYearCalendar();

    @Override
    public Week getWeek(Date date) {
        int passedDays = calcPassedDays(date);
        int len = Week.len();
        // passedDaysが負であってもよいようにもう一度lenを足すことで正になおす。
        int remain = ((passedDays % len) + len) % len;
        Week week = WEEK;
        for (int i = 0; i < remain; i++) {
            week = week.next();
        }
        return week;
    }

    @Override
    public int passedDays(Date date) {
        return -this.untilDays(date);
    }

    @Override
    public int untilDays(Date date) {
        if (date.compare(BASE_DATE) <= 0) {
            return calcUntilDays(date);
        } else {
            return -calcPassedDays(date);
        }
    }

    private int calcUntilDays(Date date) {
        int daysOfYearBaseLastYear = IntStream.range(date.getYear(), BASE_DATE.getYear() - 1)
                .map(CalendarUtils::getDaysOfYear)
                .sum();
        return daysOfYearBaseLastYear + CALC_ONE_YEAR_CALENDAR.untilDays(date);

    }

    private int calcPassedDays(Date date) {
        int daysOfYearLastYear = IntStream.range(BASE_DATE.getYear(), date.getYear())
                .map(CalendarUtils::getDaysOfYear)
                .sum();
        return daysOfYearLastYear + CALC_ONE_YEAR_CALENDAR.passedDays(date);
    }
}

package calendar.calc;

import calendar.model.Date;
import calendar.model.Week;

public class CalcCalendarImpl implements CalcCalendar {
    private Date baseDate;
    private static final CalcCalendarFrom1970 CALC_CALENDAR_FROM_1970 = new CalcCalendarFrom1970();


    public CalcCalendarImpl(Date baseYear) {
        this.baseDate = baseYear;
    }

    public Date getBaseDate() {
        return baseDate;
    }

    public void setBaseDate(Date baseDate) {
        this.baseDate = baseDate;
    }

    @Override
    public Week getWeek(Date date) {
        return CALC_CALENDAR_FROM_1970.getWeek(date);
    }

    @Override
    public int passedDays(Date date) {
        int baseDateDays = CALC_CALENDAR_FROM_1970.passedDays(this.baseDate);
        int dateDays = CALC_CALENDAR_FROM_1970.passedDays(date);
        return dateDays - baseDateDays;
    }

    @Override
    public int untilDays(Date date) {
        int baseDateDays = CALC_CALENDAR_FROM_1970.passedDays(this.baseDate);
        int dateDays = CALC_CALENDAR_FROM_1970.passedDays(date);
        return baseDateDays - dateDays;
    }
}

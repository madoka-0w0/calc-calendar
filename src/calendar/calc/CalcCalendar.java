package calendar.calc;

import calendar.model.Date;
import calendar.model.Week;

public interface CalcCalendar extends CalcDays {
    public Week getWeek(Date date);
}

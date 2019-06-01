package calendar.model;

import calendar.util.CalendarUtils;

import java.util.Comparator;

public class Date implements Comparator<Date> {
    private int year;
    private int month;
    private int day;


    public Date(int year, int month, int day) {
        setDate(year, month, day);
    }

    public Date(int year, int month) {
        setDate(year, month, 1);
    }

    public Date(int year) {
        setDate(year, 1, 1);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    private void setDate(int year, int month, int day) {
        if (validateYear(year) && validateMonth(month) && validateDay(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    private boolean validateYear(int year) {
        return true;
    }

    private boolean validateMonth(int month) {
        if (CalendarUtils.isMonth(month)) {
            return true;
        }
        throw new IllegalArgumentException(String.format("%d does not exist in the month.", month));
    }

    private boolean validateDay(int year, int month, int day) {
        int daysOfMonth = CalendarUtils.getDaysOfMonth(year, month);
        if (day <= daysOfMonth) {
            return true;
        }
        throw new IllegalArgumentException(String.format("year: %d, month: %d is until %d days.", year, month, daysOfMonth));
    }


    @Override
    public int compare(Date o1, Date o2) {
        int compareYear = Integer.compare(o1.getYear(), o2.getYear());
        if (compareYear == 0) {
            int compareMonth = Integer.compare(o1.getMonth(), o2.getMonth());
            if (compareMonth == 0) {
                return Integer.compare(o1.getDay(), o2.getDay());
            } else {
                return compareMonth;
            }
        } else {
            return compareYear;
        }
    }

    public int compare(Date o1) {
        return this.compare(this, o1);
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", year, month, day);
    }
}

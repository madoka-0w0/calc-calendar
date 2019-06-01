package presentation.reader;

import calendar.model.Date;

import java.util.Scanner;
import java.util.logging.Logger;

import static calendar.util.CalendarUtils.getDaysOfMonth;

public class DayPicker implements InputPicker<Date> {
    private static Logger logger = Logger.getLogger(DayPicker.class.getName());
    private int day;
    private Date yearMonth;

    public DayPicker(Date date) {
        this.yearMonth = date;
    }


    @Override
    public Date read(Scanner scanner) {
        day = scanner.nextInt();
        logger.info(String.format("%d が入力されました。", day));
        try {
            return new Date(yearMonth.getYear(), yearMonth.getMonth(), day);
        } catch (IllegalArgumentException e) {
            logger.severe(e.getMessage());
            throw new IllegalArgumentException(getErrorMessage());
        }
    }

    private String getErrorMessage() {
        return String.format("%d は不正です。1 ~ %d の数値を入力してください", day,
                getDaysOfMonth(yearMonth.getYear(), yearMonth.getMonth()));
    }

    @Override
    public String getGuideMessage() {
        return "日を入力してください。";
    }

}

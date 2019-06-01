package presentation.reader;

import calendar.model.Date;

import java.util.Scanner;
import java.util.logging.Logger;

import static calendar.util.CalendarUtils.FIRST_MONTH;
import static calendar.util.CalendarUtils.LAST_MONTH;
import static calendar.util.CalendarUtils.isMonth;

public class MonthPicker implements InputPicker<Date> {
    public static Logger logger = Logger.getLogger(MonthPicker.class.getName());
    private int month;
    private final Date year;

    public MonthPicker(Date year) {
        this.year = year;
    }

    @Override
    public Date read(Scanner scanner) {
        month = scanner.nextInt();
        logger.info(String.format("%d が入力されました。", month));
        try {
            if (isMonth(month)) {
                return new Date(year.getYear(), month);
            } else {
                throw new IllegalArgumentException(getErrorMessage());
            }
        } catch (IllegalArgumentException e) {
            logger.severe(e.getMessage());
            throw new IllegalArgumentException(getErrorMessage());
        }
    }

    private String getErrorMessage() {
        return String.format("%d は不正です。%d ~ %dの数値を入力してください。",
                FIRST_MONTH,
                LAST_MONTH,
                month);
    }

    @Override
    public String getGuideMessage() {
        return "月を入力してください。";
    }

}

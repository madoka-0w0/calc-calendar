package presentation.reader;

import calendar.model.Date;

import java.util.Scanner;
import java.util.logging.Logger;

public class YearPicker implements InputPicker<Date> {
    private static Logger logger = Logger.getLogger(YearPicker.class.getName());
    private int year;

    @Override
    public Date read(Scanner scanner) {
        year = scanner.nextInt();
        logger.info(String.format("%d が入力されました。", year));
        try {
            return new Date(year);
        } catch (IllegalArgumentException e) {
            logger.severe(e.getMessage());
            throw new IllegalArgumentException(getErrorMessage());
        }
    }

    private String getErrorMessage() {
        return String.format("%d は不正です。数値を入力してください。", year);
    }

    @Override
    public String getGuideMessage() {
        return "年を入力してください。";
    }

}

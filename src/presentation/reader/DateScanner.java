package presentation.reader;

import calendar.model.Date;
import calendar.model.UserStatus;

import java.io.PrintStream;
import java.util.Scanner;

public class DateScanner {
    private PrintStream guideWriter;
    private Scanner in;

    public DateScanner(Scanner scanner, PrintStream guideWriter) {
        this.in = scanner;
        this.guideWriter = guideWriter;
    }


    public Date read() {
        UserStatus status = UserStatus.START;
        Date date = null;
        while (!(status.isDone() || status.isExit())) {
            InputPicker<Date> reader = getInputReader(status, date);
            if (reader != null) {
                guideWriter.println(reader.getGuideMessage());
                try {
                    date = reader.read(in);
                    status = status.next();
                } catch (IllegalArgumentException e) {
                    guideWriter.println(e.getMessage());
                }
            }
        }
        return date;
    }


    private InputPicker<Date> getInputReader(UserStatus userStatus, Date date) {
        switch (userStatus) {
            case START:
                return new YearPicker();
            case IN_YEAR:
                return new MonthPicker(date);
            case IN_MONTH:
                return new DayPicker(date);
        }
        return null;
    }
}

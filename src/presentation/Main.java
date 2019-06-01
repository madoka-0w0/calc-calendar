package presentation;

import calendar.calc.*;
import calendar.model.Date;
import calendar.model.Week;
import presentation.reader.DateScanner;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Logger;
// - 引数でわたされた年月日に対して、その年の1月1日からの経過日数を返すプログラムを作りなさい。
// - 引数でわたされた年月日に対して、その年の12月31日までの日数を返すプログラムを作りなさい。
// - 引数でわたされた2000年以降の年に対して、2000年1月1日からの経過日数を返すプログラムを作りなさい。
// - 引数でわたされた2000年以前の年に対して、2000年1月1日までの日数を返すプログラムを作りなさい。
// - 上記を利用して、引数でわたされた2000年1月1日以降の年月日に対して、その曜日を返すプログラムを作りなさい。土曜
// - 上記を利用して、引数でわたされた2000年1月1日以前の年月日に対して、その曜日を返すプログラムを作りなさい。
// - 上記を利用して、引数でわたされた年月日に対して、その曜日を返すプログラムを作りなさい。
// - 1970年1月1日を基準に置き換えて、引数でわたされた年月日に対して、その曜日を返すプログラムを作りなさい。木曜


public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try (PrintStream writer = new PrintStream(System.out);
             Scanner in = new Scanner(System.in)) {
            writer.println("基準の年月日を入力してください。");
            writer.flush();
            DateScanner baseDatePicker = new DateScanner(in, writer);
            Date baseDate = baseDatePicker.read();
            writer.println(String.format("%s を基準にします。", baseDate));
            writer.println();

            writer.println("計算を行う年月日を入力してください。");
            writer.flush();
            DateScanner datePicker = new DateScanner(in, writer);
            Date date = datePicker.read();
            writer.println(String.format("%s について計算します。", date));
            writer.println();

            CalcCalendar calcCalendar = new CalcCalendarImpl(baseDate);
            writer.println(String.format("%s から %s の経過日数は %d 日です。", baseDate, date, calcCalendar.passedDays(date)));
            writer.println(String.format("%s は %s です。", date, calcCalendar.getWeek(date)));
            writer.flush();
        } catch (Error e0) {
            logger.severe(e0.getMessage());
            try (PrintWriter writer = new PrintWriter(System.out)) {
                writer.println("予期せぬエラーが発生しました。処理を終了します。");
            } catch (Error e1) {
                logger.severe(e1.getMessage());
            }
        }
    }


}

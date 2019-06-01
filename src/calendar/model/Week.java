package calendar.model;

import java.util.stream.Stream;

public enum Week {
    Mon,
    Thu,
    Web,
    Thr,
    Fri,
    Sat,
    Sun,
    ;

    public Week next() {
        return getValueFromOrdinal((this.ordinal() + 1) % len());
    }

    public static int len() {
        return Week.values().length;
    }

    private Week getValueFromOrdinal(int ordinal) {
        return Stream.of(Week.values()).filter(week -> week.ordinal() == ordinal).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

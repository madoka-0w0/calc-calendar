package calendar.model;

import java.util.stream.Stream;

public enum UserStatus {
    START,
    IN_YEAR,
    IN_MONTH,
    DONE,
    EXIT,
    ;

    public boolean isDone() {
        return this == DONE;
    }

    public boolean isExit() {
        return this == EXIT;
    }

    public UserStatus next() {
        return getValueFromOrdinal((this.ordinal() + 1) % len());
    }
    public static int len() {
        return UserStatus.values().length;
    }

    private UserStatus getValueFromOrdinal(int ordinal) {
        return Stream.of(UserStatus.values()).filter(status -> status.ordinal() == ordinal).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }


}

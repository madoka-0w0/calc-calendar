package presentation.reader;

import java.util.Scanner;

public interface InputPicker<E> {
    public E read(Scanner scanner);

    public String getGuideMessage();
}

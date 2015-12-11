package lv.javaguru.tdd.workshop.section1;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String EMPTY_STRING = "";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_DELIMITER = "\n";

    public int add(String numbers) {

        if (isEmptyString(numbers)) {
            return 0;
        } else {
            return getSeparatedNumbers(numbers).stream()
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

    }

    private List<String> getSeparatedNumbers(String numbers) {
        String[] separatedNumbers = numbers.split(COMMA_DELIMITER + "|" + NEW_LINE_DELIMITER);
        return Arrays.asList(separatedNumbers);
    }

    private boolean isEmptyString(String str) {
        return EMPTY_STRING.equals(str);
    }

}

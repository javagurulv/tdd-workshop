package lv.javaguru.tdd.workshop.section1;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String EMPTY_STRING = "";
    private static final String DELIMITERS_REGEXP = "[,\n]";

    public int add(String numbers) {
        return getSeparatedNumbers(numbers).stream()
                .filter(number -> !isEmptyString(number))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private List<String> getSeparatedNumbers(String numbers) {
        String[] separatedNumbers = numbers.split(DELIMITERS_REGEXP);
        return Arrays.asList(separatedNumbers);
    }

    private boolean isEmptyString(String str) {
        return EMPTY_STRING.equals(str);
    }

}

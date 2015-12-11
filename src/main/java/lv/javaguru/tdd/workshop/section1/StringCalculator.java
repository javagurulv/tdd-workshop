package lv.javaguru.tdd.workshop.section1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


public class StringCalculator {

    private static final String EMPTY_STRING = "";
    private static final String DELIMITERS_REGEXP = "[,\n]";

    public int add(String numbers) {
        List<String> splitedNumbers = splitNumbers(numbers);

        List<Integer> negativeNumbers = splitedNumbers.stream()
                .filter(number -> !isEmptyString(number))
                .map(Integer::parseInt)
                .filter(this::isNegativeNumber)
                .collect(toList());

        if (!negativeNumbers.isEmpty()) {
            String errorMessage = "negatives not allowed: "
                    + negativeNumbers.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException(errorMessage);
        }

        return splitedNumbers.stream()
                .filter(number -> !isEmptyString(number))
                .mapToInt(Integer::parseInt)
                .filter(number -> !isNegativeNumber(number))
                .sum();
    }

    private List<String> splitNumbers(String numbers) {
        String[] separatedNumbers = numbers.split(DELIMITERS_REGEXP);
        return Arrays.asList(separatedNumbers);
    }

    private boolean isEmptyString(String str) {
        return EMPTY_STRING.equals(str);
    }

    private boolean isNegativeNumber(int number) {
        return number < 0;
    }

}
